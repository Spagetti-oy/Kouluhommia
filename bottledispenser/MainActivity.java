package com.example.bottledispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.printArea);



        final SeekBar simpleSeekBar=(SeekBar)findViewById(R.id.seekBar2);

        final BottleDispenser kone = new BottleDispenser();


        Button insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seekBarValue= simpleSeekBar.getProgress();
                text.setText(kone.addMoney(seekBarValue));
                simpleSeekBar.setProgress(0);
            }
        });

        Button buySoda = findViewById(R.id.buySoda);
        buySoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kone.printSelection();
                text.setText(kone.buyBottle(1));
            }
        });

        Button returnMoney = findViewById(R.id.returnMoney);
        returnMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text.setText(kone.returnMoney());
            }
        });
    }




}