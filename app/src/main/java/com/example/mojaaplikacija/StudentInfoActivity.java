package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private Button oBtnSljedeca;
    private String sPredmet;
    private String sZapis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        oBtnSljedeca = (Button)findViewById(R.id.buttonSljedeca);
        oBtnSljedeca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                TextInputEditText oInputPredmet = (TextInputEditText)findViewById(R.id.predmet);

                sPredmet = oInputPredmet.getText().toString();
                if(sPredmet.matches("")) {

                }
                else {
                    Intent i = getIntent();
                    String mojeIme = i.getExtras().getString("imePrezime");

                    sZapis = mojeIme + " upisali ste " + sPredmet;

                    Intent inn = new Intent(StudentInfoActivity.this, SummaryActivity.class);
                    inn.putExtra("zapisUnosa", sZapis);
                    startActivity(inn);
                }
            }
        });
    }
}
