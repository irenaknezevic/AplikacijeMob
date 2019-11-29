package com.example.mojaaplikacija;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class PersonalInfoFragment extends Fragment {

    TextInputEditText oInputIme;
    TextInputEditText oInputPrezime;
    EditText oEditTextDatum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.activity_personal_info, container, false);

        //text watcher postaviti na inpute
        
        oInputIme = (TextInputEditText)view.findViewById(R.id.ime);
        oInputPrezime = (TextInputEditText)view.findViewById(R.id.prezime);
        oEditTextDatum = (EditText)view.findViewById(R.id.etUnos);

        return view;
    }

}
