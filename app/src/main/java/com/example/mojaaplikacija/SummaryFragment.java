package com.example.mojaaplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class SummaryFragment extends Fragment {

    TextView sIme;
    TextView sPrezime;
    TextView sDatum;
    TextView sPredmet;
    TextView sProfesor;
    TextView sAkGodina;
    TextView sPredavanja;
    TextView sLabosi;
    Button oButton;
    String m_ime, m_prezime, m_predmet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_summary, container, false);

        sIme = (TextView)view.findViewById(R.id.mojeIme);
        sPrezime = (TextView)view.findViewById(R.id.mojePrezime);
        sDatum = (TextView)view.findViewById(R.id.mojeRodenje);
        sPredmet = (TextView)view.findViewById(R.id.predmet);
        sProfesor = (TextView)view.findViewById(R.id.imeProfesora);
        sAkGodina = (TextView)view.findViewById(R.id.akademskaGod);
        sPredavanja = (TextView)view.findViewById(R.id.brojPredavanja);
        sLabosi = (TextView)view.findViewById(R.id.brojLv);
        oButton = (Button)view.findViewById(R.id.buttonPocetna);

        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getActivity(), MainActivity.class);
                i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);

                MyDataStorage data = MyDataStorage.getInstance();
                Student st = new Student(m_ime, m_prezime, m_predmet);
                data.addStudent(st);

                startActivity(i);
            }
        });

        return view;
    }

    public void updatePersonalInfo(String ime, String prezime, String datum) {
        m_ime = ime;
        m_prezime = prezime;

        sIme.setText(ime);
        sPrezime.setText(prezime);
        sDatum.setText(datum);
    }

    public void updateStudentInfo(String predmet, String imeProf, String akGod, String satiPred, String satiLV) {
        m_predmet = predmet;

        sPredmet.setText(predmet);
        sProfesor.setText(imeProf);
        sAkGodina.setText(akGod);
        sPredavanja.setText(satiPred);
        sLabosi.setText(satiLV);
    }
}
