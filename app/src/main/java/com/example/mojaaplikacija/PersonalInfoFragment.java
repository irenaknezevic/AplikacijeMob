package com.example.mojaaplikacija;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class PersonalInfoFragment extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    ImageView imageView;
    TextInputEditText oInputIme;
    TextInputEditText oInputPrezime;
    EditText oEditTextDatum;
    String ime, prezime, datum;
    PersonalInfoListener personalInfoListener;

    public interface PersonalInfoListener {
        void onPersonalInfoSent(String ime, String prezime, String datum);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_personal_info, container, false);

        //text watcher postaviti na inpute

        oInputIme = (TextInputEditText)view.findViewById(R.id.ime);
        oInputPrezime = (TextInputEditText)view.findViewById(R.id.prezime);
        oEditTextDatum = (EditText)view.findViewById(R.id.etUnos);
        imageView = (ImageView)view.findViewById(R.id.slika);

        oInputIme.addTextChangedListener(personalWatcher);
        oInputPrezime.addTextChangedListener(personalWatcher);
        oEditTextDatum.addTextChangedListener(personalWatcher);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

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
            ime = oInputIme.getText().toString();
            prezime = oInputPrezime.getText().toString();
            datum = oEditTextDatum.getText().toString();

            personalInfoListener.onPersonalInfoSent(ime, prezime, datum);
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof PersonalInfoListener) {
            personalInfoListener = (PersonalInfoListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        personalInfoListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}
