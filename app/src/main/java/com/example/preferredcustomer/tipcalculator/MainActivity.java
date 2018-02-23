package com.example.preferredcustomer.tipcalculator;

/**
 * Created by Michael Lentzis on 2/23/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    public static final String TAG_TIP = "tag";
    public static final String TAG_GRAND_TOTAL = "total";
    public static final String TAG_DIVIDE = "divide";


    private EditText bill;
    private EditText tip;
    private EditText people;

    private Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = (EditText) findViewById(R.id.editText);
        tip = (EditText) findViewById(R.id.editText2);
        people = (EditText) findViewById(R.id.editText4);


        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                double tipPercent;


                String text1 = bill.getText().toString();

                if (text1.equals("")) {

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.enter_bill), Toast.LENGTH_LONG).show();

                    return;
                }


                String text2 = tip.getText().toString();

                if (text2.equals("")) {

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.enter_tip), Toast.LENGTH_LONG).show();

                    return;
                }


                String text3 = people.getText().toString();

                if (text3.equals("")) {

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.error_et), Toast.LENGTH_LONG).show();

                    return;
                }




                launchResultActivity(Double.parseDouble(bill.getText().toString()), Double.parseDouble(tip.getText().toString()), Double.parseDouble(people.getText().toString()));

            }
        });



    }


    private void launchResultActivity(double total, double tipPercent, double people) {

        double tip = total * (tipPercent/ 100);
        double grandTotal = total + tip;
        double divide = grandTotal / people;

        Intent resultActivity = new Intent(MainActivity.this, Result.class);

        resultActivity.putExtra(TAG_TIP, tip);
        resultActivity.putExtra(TAG_GRAND_TOTAL, grandTotal);
        resultActivity.putExtra(TAG_DIVIDE, divide);


        startActivity(resultActivity);


    }


}
