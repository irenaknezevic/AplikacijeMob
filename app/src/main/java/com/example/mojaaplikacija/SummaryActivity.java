package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private Button oBtnPocetna;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent iN = getIntent();
        String mojZapis = iN.getExtras().getString("zapisUnosa");
        tv =  (TextView)findViewById(R.id.tvZapis);
        tv.setText(mojZapis);

        oBtnPocetna = (Button)findViewById(R.id.buttonPocetna);

        oBtnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pocetna = new Intent(SummaryActivity.this, MainActivity.class);
                pocetna.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pocetna);
            }
        });
    }
}
