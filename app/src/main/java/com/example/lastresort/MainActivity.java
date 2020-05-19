package com.example.lastresort;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FractionCalc";

    Fraction ob;

    TextView result;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button0;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMul;
    Button buttonDiv;
    Button buttonSlash;
    Button buttonEnd;
    Button buttonClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        result = (TextView) findViewById(R.id.result);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonSlash = (Button) findViewById(R.id.buttonSlash);
        buttonEnd = (Button) findViewById(R.id.buttonEnd);
        buttonClean = (Button) findViewById(R.id.buttonClean);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void clickMyBtn(View v) {
        Log.d(TAG, "Button["+((Button)v).getText()+"] id: " + v.getId() + " clicked");

        switch (v.getId()) {
            case R.id.button1: result.setText(result.getText() + "1");
            break;
            case R.id.button2: result.setText(result.getText() + "2");
            break;
            case R.id.button3: result.setText(result.getText() + "3");
            break;
            case R.id.button4: result.setText(result.getText() + "4");
            break;
            case R.id.button5: result.setText(result.getText() + "5");
            break;
            case R.id.button6: result.setText(result.getText() + "6");
            break;
            case R.id.button7: result.setText(result.getText() + "7");
            break;
            case R.id.button8: result.setText(result.getText() + "8");
            break;
            case R.id.button9: result.setText(result.getText() + "9");
            break;
            case R.id.button0: result.setText(result.getText() + "0");
            break;
            case R.id.button10:
//                result.setText(result.getText() );
                String num = result.getText().toString().trim();
                StringBuilder kv = new StringBuilder(num);
                String kvadrat = kv.toString();
//                result.setText(kv);
                int sqare = Integer.parseInt(kvadrat);
                String lol = String.valueOf(sqare * sqare);
                StringBuilder str = new StringBuilder(lol);

                result.setText(str.toString());
                break;


            case R.id.buttonEnd:
                CalcString enter = new CalcString();
                ob = enter.Calculate_str(new StringBuilder(result.getText()));
                result.setText(result.getText() + "  =  " + ob.toString());
//            Parser p = new Parser();
//            String res = result.getText().toString();
//                System.out.println("----------" + res);
//
//                Arrays.toString(p.arr);
//            p.calcStr(res);
//                System.out.println(p.chis1);
//                System.out.println(p.znam1);
//                System.out.println(p.chis);
//                System.out.println(p.znam);
//
//            result.setText(result.getText() + "=" + ob);
                break;

            case R.id.buttonClean:
                Toast toast = Toast.makeText(this, "Clean example!",Toast.LENGTH_LONG);
                toast.show();
                result.setText(" "); break;

            case R.id.buttonAdd: result.setText(result.getText() + "  +  "); break;
            case R.id.buttonSub: result.setText(result.getText() + "  -  "); break;
            case R.id.buttonMul: result.setText(result.getText() + "  *  "); break;
            case R.id.buttonDiv: result.setText(result.getText() + "  %  "); break;
            case R.id.buttonSlash: result.setText(result.getText() + "/"); break;

        }
    }
}
