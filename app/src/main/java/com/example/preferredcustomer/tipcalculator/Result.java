package com.example.preferredcustomer.tipcalculator;

/**
 * Created by Michael Lentzis on 2/23/17.
 */



import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class Result extends MainActivity{



    private TextView tipTextView;
    private TextView totalTextView;
    private TextView personTextView;

    private Button finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tipTextView = (TextView) findViewById(R.id.tip);
        totalTextView = (TextView) findViewById(R.id.total);
        personTextView = (TextView) findViewById(R.id.divide);


        initializeTextViews();

        finished = (Button) findViewById(R.id.confirm);

        finished.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void initializeTextViews(){

        double tip = getIntent().getExtras().getDouble(MainActivity.TAG_TIP);
        double total = getIntent().getExtras().getDouble(MainActivity.TAG_GRAND_TOTAL);
        double divide = getIntent().getExtras().getDouble(MainActivity.TAG_DIVIDE);

        String currentTipText = tipTextView.getText().toString();

        currentTipText =  currentTipText + "$"+ tip;

        String currentTotalText = totalTextView.getText().toString();

        currentTotalText = currentTotalText + "$" + total;

        String currentDivideText = personTextView.getText().toString();

        currentDivideText = currentDivideText + "$" + divide;

        tipTextView.setText(currentTipText);
        totalTextView.setText(currentTotalText);
        personTextView.setText(currentDivideText);
    }




}
