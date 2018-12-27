package com.example.webwerks.retrolambda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtAddition,txtSubtraction,txtMultiplication,txtDivision;
    Button btnCalculate;
    EditText etOne,etTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        txtAddition = findViewById(R.id.txtAddition);
        txtSubtraction = findViewById(R.id.txtSubtraction);
        txtMultiplication = findViewById(R.id.txtMultiplication);
        txtDivision = findViewById(R.id.txtDivision);

        etOne = findViewById(R.id.etOne);
        etTwo = findViewById(R.id.etTwo);

        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(this::eventHandler);

    }


    private void eventHandler(View view){

        int One = Integer.parseInt(etOne.getText().toString());
        int Two = Integer.parseInt(etTwo.getText().toString());


        //Addition
        Addition add = (int x, int y) -> x+y;
        String addResult = String.valueOf(add.addition(One,Two));
        txtAddition.setText(addResult);

        //Subtraction
        Subtraction sub = (int x,int y) -> x-y;
        String subResult = String.valueOf(sub.subtraction(One,Two));
        txtSubtraction.setText(subResult);

        //Multiplication
        Multiplication multi = (int x,int y)-> x*y;
        String multiResult = String.valueOf(multi.multiplication(One,Two));
        txtMultiplication.setText(multiResult);

        //Division
        Division div = (int x,int y)-> x/y;
        String divResult = String.valueOf(div.division(One,Two));
        txtDivision.setText(divResult);
    }


    interface Addition{

        int addition(int a,int b);
    }


    interface Subtraction{

        int subtraction(int a,int b);
    }

    interface Multiplication{

        int multiplication(int a,int b);
    }

    interface Division{

        int division(int a,int b);
    }
}
