package com.example.lastresort;


public class CalcString {
    private String Start_string, operation;
    private int temp;
    Fraction result, ob1, ob2;
    int dia = -1;

    public Fraction Calculate_str(StringBuilder str){

        StringBuilder test = str;//
        do {
            temp = test.indexOf(" ");
            if(temp != -1) test.deleteCharAt(temp);
        }while(temp != -1);

        Start_string = test.toString();
        while(dia == -1){
            dia = Start_string.indexOf("+");
            if(dia > -1) break;
            dia = Start_string.indexOf("-");
            if(dia > -1) break;
            dia = Start_string.indexOf("*");
            if(dia > -1) break;
            dia = Start_string.indexOf("%");
            if(dia > -1) break;
        }
        operation = Start_string.substring(dia,dia+1);
        System.out.print(test);

        String arrNumbers[] = Start_string.split("[+%*-]+");
        String Num1[] = arrNumbers[0].split("/");
        String Num2[] = arrNumbers[1].split("/");


        ob1 = new Fraction(Num1[0],Num1[1]);
        ob2 = new Fraction(Num2[0],Num2[1]);

        switch (operation){
            case "+": result = ob1.Add(ob2);
                break;
            case "-": result = ob1.Sub(ob2);
                break;
            case "*": result = ob1.Mul(ob2);
                break;
            case "%": result = ob1.Div(ob2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

        return result;

    }

}

