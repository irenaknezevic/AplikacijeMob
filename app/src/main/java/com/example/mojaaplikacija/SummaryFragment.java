package com.example.mojaaplikacija;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.activity_summary, container, false);

        sIme = (TextView)view.findViewById(R.id.mojeIme);
        sPrezime = (TextView)view.findViewById(R.id.mojePrezime);
        sDatum = (TextView)view.findViewById(R.id.mojeRodenje);
        sPredmet = (TextView)view.findViewById(R.id.predmet);
        sProfesor = (TextView)view.findViewById(R.id.imeProfesora);
        sAkGodina = (TextView)view.findViewById(R.id.akademskaGod);
        sPredavanja = (TextView)view.findViewById(R.id.brojPredavanja);
        sLabosi = (TextView)view.findViewById(R.id.brojLv);

        return view;
    }
}
