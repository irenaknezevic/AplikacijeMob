package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    private Button oBtnDalje;
    private String sIme;
    private String sPrezime;
    private String sDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        oBtnDalje = (Button)findViewById(R.id.buttonDalje);
        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                TextInputEditText oInputIme = (TextInputEditText)findViewById(R.id.ime);
                TextInputEditText oInputPrezime = (TextInputEditText)findViewById(R.id.prezime);
                EditText oEditTextDatum = (EditText)findViewById(R.id.etUnos);

                sIme = oInputIme.getText().toString();
                sPrezime = oInputPrezime.getText().toString();
                sDatum = oEditTextDatum.getText().toString();


                if(sIme.matches("") && sPrezime.matches("") && sDatum.matches("")) {

                }
                else {
                    Intent in = new Intent(PersonalInfoActivity.this, StudentInfoActivity.class);
                    in.putExtra("ime", sIme);
                    in.putExtra("prezime", sPrezime);
                    in.putExtra("datum", sDatum);
                    startActivity(in);
                }
            }
        });
    }
}
