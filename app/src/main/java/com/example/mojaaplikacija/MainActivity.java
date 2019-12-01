package com.example.mojaaplikacija;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> studentiArray = new ArrayList<>();
    private ArrayList<String> predmetiArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button)findViewById(R.id.dalje);

        ActionBar aBar = getSupportActionBar();
        aBar.setTitle(getResources().getString(R.string.app_name));

        initRV();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jezik, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String local = parent.getSelectedItem().toString();
                local = local.substring(local.indexOf("(")+1, local.indexOf(")"));

                setLocal(local);

                ActionBar aBar = getSupportActionBar();
                aBar.setTitle(getResources().getString(R.string.app_name));

                button.setText(getResources().getString(R.string.dalje));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setLocal(String jezik) {
        Locale loc = new Locale(jezik);
        Locale.setDefault(loc);

        Configuration config = new Configuration();
        config.locale = loc;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    private void initRV() {
        MyDataStorage studenti = MyDataStorage.getInstance();
        List<Object> lista = studenti.getStudents();

        RecyclerView rv = findViewById(R.id.my_recycler_view);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(lista);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
