package com.example.MoneyProblemSolver;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {

    public DBHandler database = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        configChangeToMainScreen();
        configChangeToViewExams();
        configSubmitExam();
    }

    public void configChangeToMainScreen(){
        Button goBack = findViewById(R.id.backButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivity(new Intent(MainScreen.this, MainActivity.class));
            }
        });


    }

    public void configChangeToViewExams(){
        Button goBack = findViewById(R.id.viewPayments);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivity(new Intent(MainScreen.this, viewPayments.class));
            }
        });


    }


    public void configSubmitExam(){
        Button submitData = findViewById(R.id.submitButton);
        EditText course = findViewById(R.id.editTextPaymentName);
        EditText selfEval = findViewById(R.id.editTextCategory);
        EditText examDate = findViewById(R.id.editPaymentDate);
        EditText nbLectures = findViewById(R.id.editPaymentTime);
        EditText timePerLecture = findViewById(R.id.editPaymentLocation);
        EditText observations = findViewById(R.id.editObservations);
        submitData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                database.addPayment(course.getText().toString(),examDate.getText().toString(),selfEval.getText().toString(),
                        nbLectures.getText().toString(),timePerLecture.getText().toString(),observations.getText().toString());
                course.setText("");
                selfEval.setText("");
                examDate.setText("");
                nbLectures.setText("");
                timePerLecture.setText("");
                observations.setText("");


            }
        });

    }

}