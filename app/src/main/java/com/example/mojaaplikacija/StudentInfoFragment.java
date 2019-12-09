package com.example.mojaaplikacija;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse> {

    CourseResponse courses = new CourseResponse();

    ArrayList<Course> courseLista = new ArrayList<>();

    ArrayList<String> coursesNames = new ArrayList<>();
    ArrayList<ArrayList<Instructor>> instructors = new ArrayList<>();
    ArrayList<String> instructorsNames = new ArrayList<>();

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

        oEditTextAkGodina =(EditText)view.findViewById(R.id.editAkGod);
        oEditTextBrPredavanja =(EditText)view.findViewById(R.id.etSatiPredavanja);
        oEditTextBrLv =(EditText)view.findViewById(R.id.etSatiLv);

        oEditTextAkGodina.addTextChangedListener(personalWatcher);
        oEditTextBrPredavanja.addTextChangedListener(personalWatcher);
        oEditTextBrLv.addTextChangedListener(personalWatcher);

        //asinkroni poziv
        ApiManager.getInstance().service().getCourses().enqueue(this);

        return view;
    }


    //LV5
    @Override
    public void onResponse(@NonNull Call<CourseResponse> call, @NonNull Response<CourseResponse> response) {
        String TAG = "api_call";
        if(response.isSuccessful() && response.body()!=null) {
            courses = response.body();
            courseLista = courses.getCourses();
            getAllCourses(courseLista);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    private void printCourses(CourseResponse courses) {
        String TAG = "apiCall";
        for (Course course: courses.getCourses()) {
            Log.d(TAG, "printCourses: " + course.toString());
        }

    }


    public void getAllCourses(ArrayList<Course> allCourses) {
        for (Course course: allCourses) {
            if(!course.getTitle().matches("")) {
                coursesNames.add(course.getTitle());
                instructors.add(course.getInstructors());
            }
        }
        makePredmetSpinner(getView().getRootView());
    }

    public Spinner makePredmetSpinner(View view) {
        Spinner spinner = view.findViewById(R.id.spinnerPredmet);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, coursesNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                predmet = adapterView.getSelectedItem().toString();
                studentInfoListener.onStudentInfoSent(predmet, imeProf, akGod, satiPred, satiLV);

                instructorsNames.clear();

                for(int i=0; i < instructors.get(position).size(); i++) {
                    instructorsNames.add(instructors.get(position).get(i).getName());
                }
                makeProfesorSpinner(getView().getRootView());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return spinner;
    }

    public Spinner makeProfesorSpinner(View view) {
        Spinner spinner = view.findViewById(R.id.spinnerProfesor);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, instructorsNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imeProf = adapterView.getSelectedItem().toString();
                studentInfoListener.onStudentInfoSent(predmet, imeProf, akGod, satiPred, satiLV);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return spinner;
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
