package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button oBtnDalje;
    private String sImePrezime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oBtnDalje = (Button)findViewById(R.id.buttonDalje);
        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                TextInputEditText oInputImePrezime = (TextInputEditText)findViewById(R.id.imePrezime);

                sImePrezime = oInputImePrezime.getText().toString();
                if(sImePrezime.matches("")) {

                }
                else {
                    Intent in = new Intent(MainActivity.this, StudentInfoActivity.class);
                    in.putExtra("imePrezime", sImePrezime);
                    startActivity(in);
                }
            }
        });
    }
}
