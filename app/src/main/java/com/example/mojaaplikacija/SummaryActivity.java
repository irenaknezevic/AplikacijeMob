package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private Button oBtnPocetna;
    private TextView ime;
    private TextView prezime;
    private TextView datum_rodenja;
    private TextView predmet;
    private TextView profesor;
    private TextView ak_godina;
    private TextView br_predavanja;
    private TextView br_labosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent iN = getIntent();
        String sIme = iN.getExtras().getString("ime");
        ime =  (TextView)findViewById(R.id.mojeIme);
        ime.setText(sIme);

        String sPrezime = iN.getExtras().getString("prezime");
        prezime =  (TextView)findViewById(R.id.mojePrezime);
        prezime.setText(sPrezime);

        String sDatum = iN.getExtras().getString("datum");
        datum_rodenja =  (TextView)findViewById(R.id.mojeRodenje);
        datum_rodenja.setText(sDatum);

        String sPredmet = iN.getExtras().getString("predmet");
        predmet =  (TextView)findViewById(R.id.predmet);
        predmet.setText(sPredmet);

        String sProfesor = iN.getExtras().getString("profesor");
        profesor =  (TextView)findViewById(R.id.imeProfesora);
        profesor.setText(sProfesor);

        String sAkGodina = iN.getExtras().getString("akGod");
        ak_godina =  (TextView)findViewById(R.id.akademskaGod);
        ak_godina.setText(sAkGodina);

        String sPredavanja = iN.getExtras().getString("predavanja");
        br_predavanja =  (TextView)findViewById(R.id.brojPredavanja);
        br_predavanja.setText(sPredavanja);

        String sLabosi = iN.getExtras().getString("lv");
        br_labosa =  (TextView)findViewById(R.id.brojLv);
        br_labosa.setText(sLabosi);

        oBtnPocetna = (Button)findViewById(R.id.buttonPocetna);

        oBtnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pocetna = new Intent(SummaryActivity.this, MainActivity.class);
                pocetna.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pocetna);
            }
        });

        MyDataStorage data = MyDataStorage.getInstance();
        Student st = new Student(sIme, sPrezime, sPredmet);
        data.addStudent(st);
    }
}
