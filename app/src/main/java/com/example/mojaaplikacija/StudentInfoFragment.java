package com.example.mojaaplikacija;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class StudentInfoFragment extends Fragment {

    TextInputEditText oInputPredmet;
    EditText oEditTextProf;
    EditText oEditTextAkGodina;
    EditText oEditTextBrPredavanja;
    EditText oEditTextBrLv;
    String predmet, imeProf, akGod, satiPred, satiLV;
    StudentInfoListener studentInfoListener;


    public interface StudentInfoListener {
        void onStudentInfoSent(String predmet, String imeProf, String akGod, String satiPred, String satiLV);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_student_info, container, false);

        oInputPredmet = (TextInputEditText)view.findViewById(R.id.predmet);
        oEditTextProf =(EditText)view.findViewById(R.id.profIme);
        oEditTextAkGodina =(EditText)view.findViewById(R.id.editAkGod);
        oEditTextBrPredavanja =(EditText)view.findViewById(R.id.etSatiPredavanja);
        oEditTextBrLv =(EditText)view.findViewById(R.id.etSatiLv);

        oInputPredmet.addTextChangedListener(personalWatcher);
        oEditTextProf.addTextChangedListener(personalWatcher);
        oEditTextAkGodina.addTextChangedListener(personalWatcher);
        oEditTextBrPredavanja.addTextChangedListener(personalWatcher);
        oEditTextBrLv.addTextChangedListener(personalWatcher);

        return view;
    }

    private TextWatcher personalWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            predmet = oInputPredmet.getText().toString();
            imeProf = oEditTextProf.getText().toString();
            akGod = oEditTextAkGodina.getText().toString();
            satiPred = oEditTextBrPredavanja.getText().toString();
            satiLV = oEditTextBrLv.getText().toString();

            studentInfoListener.onStudentInfoSent(predmet, imeProf, akGod, satiPred, satiLV);
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof StudentInfoListener) {
            studentInfoListener = (StudentInfoListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        studentInfoListener = null;
    }
}
