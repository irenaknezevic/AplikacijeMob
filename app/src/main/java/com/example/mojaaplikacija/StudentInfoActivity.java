package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private Button oBtnSljedeca;
    private String sPredmet;
    private String sProf;
    private String sAkGod;
    private String sPredavanja;
    private String sLv;
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
                EditText oEditTextProf =(EditText)findViewById(R.id.profIme);
                EditText oEditTextAkGodina =(EditText)findViewById(R.id.editAkGod);
                EditText oEditTextBrPredavanja =(EditText)findViewById(R.id.etSatiPredavanja);
                EditText oEditTextBrLv =(EditText)findViewById(R.id.etSatiLv);

                sPredmet = oInputPredmet.getText().toString();
                sProf = oEditTextProf.getText().toString();
                sAkGod = oEditTextAkGodina.getText().toString();
                sPredavanja = oEditTextBrPredavanja.getText().toString();
                sLv = oEditTextBrLv.getText().toString();

                if(sPredmet.matches("") && sProf.matches("") && sAkGod.matches("") && sPredavanja.matches("") && sLv.matches("")) {

                }
                else {
                    Intent i = getIntent();
                    String mojeIme = i.getExtras().getString("ime");
                    String mojePrezime = i.getExtras().getString("prezime");
                    String datum = i.getExtras().getString("datum");

                    Intent inn = new Intent(StudentInfoActivity.this, SummaryActivity.class);
                    inn.putExtra("predmet", sPredmet);
                    inn.putExtra("profesor", sProf);
                    inn.putExtra("akGod", sAkGod);
                    inn.putExtra("predavanja", sPredavanja);
                    inn.putExtra("lv", sLv);
                    inn.putExtra("ime", mojeIme);
                    inn.putExtra("prezime", mojePrezime);
                    inn.putExtra("datum", datum);

                    startActivity(inn);
                }
            }
        });
    }
}
