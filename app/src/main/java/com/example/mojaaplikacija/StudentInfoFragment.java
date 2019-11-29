package com.example.mojaaplikacija;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class StudentInfoFragment extends Fragment {

    TextInputEditText oInputPredmet;
    EditText oEditTextProf;
    EditText oEditTextAkGodina;
    EditText oEditTextBrPredavanja;
    EditText oEditTextBrLv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.activity_student_info, container, false);

        oInputPredmet = (TextInputEditText)view.findViewById(R.id.predmet);
        oEditTextProf =(EditText)view.findViewById(R.id.profIme);
        oEditTextAkGodina =(EditText)view.findViewById(R.id.editAkGod);
        oEditTextBrPredavanja =(EditText)view.findViewById(R.id.etSatiPredavanja);
        oEditTextBrLv =(EditText)view.findViewById(R.id.etSatiLv);

        return view;
    }
}
