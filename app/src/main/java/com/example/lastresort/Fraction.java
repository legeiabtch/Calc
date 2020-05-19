package com.example.lastresort;

public class Fraction {
    private int chis;
    private int znam;

    //Конструктори класу
    Fraction(){
        setChis(1);
        setZnam(1);
    }
    Fraction(int arg1, int arg2){
        setChis(arg1);
        setZnam(arg2);
    }

    Fraction(String arg1, String arg2){

        setChis(Integer.parseInt(arg1));
        setZnam(Integer.parseInt(arg2));
    }

    Fraction(Fraction ob){
        setChis(ob.getChis());
        setZnam(ob.getZnam());
    }

    //Властивості для інкапсуляції змінних
    public int getChis(){ return chis;}
    private void setChis(int value){chis = value;}

    public int getZnam(){ return znam;}
    private void setZnam(int value){znam = value;}


    //Додавання~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Fraction Add(Fraction ob){
        int newChis = 0;
        int newZnam = 0;
        Fraction res;
        int del = 1;
        double Num;

        if(znam == ob.getZnam()){
            newZnam = znam;
            newChis = chis + ob.getChis();
            del = Skr(newChis, newZnam);
            if (del > 1) {
                newChis = newChis / del;
                newZnam = newZnam / del;
            }
            res = new Fraction(newChis, newZnam);
        }
        else {
            newZnam = algEvklid(znam, ob.getZnam());    //визначення найменшого спільного знаменника
            newChis = ((newZnam / znam) * chis) + ((newZnam / ob.getZnam()) * ob.getChis());

            del = Skr(newChis, newZnam);
            if (del > 1) {
                newChis = newChis / del;
                newZnam = newZnam / del;
            }
            res = new Fraction(newChis, newZnam);
        }
        return res;
    }

    //Віднімання~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Fraction Sub(Fraction ob){
        int newChis = 0;
        int newZnam = 0;
        Fraction res;
        int del = 1;
        double Num;

        if(znam == ob.getZnam()){
            newZnam = znam;
            newChis = chis - ob.getChis();
            del = Skr(newChis, newZnam);
            if (del > 1) {
                newChis = newChis / del;
                newZnam = newZnam / del;
            }
            res = new Fraction(newChis, newZnam);
        }
        else {
            newZnam = algEvklid(znam, ob.getZnam());
            newChis = ((newZnam / znam) * chis) - ((newZnam / ob.getZnam()) * ob.getChis());

            del = Skr(newChis, newZnam);
            if (del > 1) {
                newChis = newChis / del;
                newZnam = newZnam / del;
            }
            res = new Fraction(newChis, newZnam);
        }
        return res;
    }

    //Множення~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Fraction Mul(Fraction ob){
        int newChis = 0, newZnam = 0, del = 1;
        Fraction res;
        if(((znam == 0) || (ob.getZnam() == 0)) || ((chis == 0) || (ob.getChis() == 0))){
            res = new Fraction(newChis, newZnam);
        }
        else {
            newChis = chis * ob.getChis();
            newZnam = znam * ob.getZnam();

            del = Skr(newChis, newZnam);
            if(del > 1){
                newChis = newChis / del;
                newZnam = newZnam / del;
            }

            res = new Fraction(newChis, newZnam);
        }
        return res;
    }

    //Ділення~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Fraction Div(Fraction ob){
        int newChis = 0, newZnam = 0, del = 1;
        Fraction res;
        if(((znam == 0) || (ob.getZnam() == 0)) || ((chis == 0) || (ob.getChis() == 0))){
            res = new Fraction(newChis, newZnam);
        }
        else {
            newChis = chis * ob.getZnam();
            newZnam = znam * ob.getChis();

            del = Skr(newChis, newZnam);
            if(del > 1){
                newChis = newChis / del;
                newZnam = newZnam / del;
            }

            res = new Fraction(newChis, newZnam);
        }
        return res;
    }


    //скорочення дробів~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //найбільший спільний знаменник
    private int Skr(int chisArg, int znamArg) {
        if(chisArg < 0)  chisArg = chisArg * -1;

        for(int i = chisArg; i > 0; i--){
            if(((chisArg % i) == 0) && ((znamArg % i) == 0)) return i;
        }
        return 1;
    }

    //найменший спільний знаменник~~~~~~~~~~~~~~~~~~~~~~
    private int algEvklid(int znam1, int znam2) {
        boolean ex = false;
        int i=1;
        do {
            i++;
            if (((i % znam1) == 0) && ((i % znam2) == 0)) {
                ex = true;
            }
        }while(ex == false);
        return i;
    }


    @Override
    public int hashCode(){
        final int Koef = 31;
        int result = 1;
        result = result * Koef + chis;
        result = result * Koef + znam;
        return result;
    }

    public boolean Ravno(Fraction ob) {
        if((chis == ob.getChis()) && (znam == ob.getZnam())) return true;
        else return false;
    }

    @Override
    public String toString() {
        return chis + "/" + znam;
    }
}



