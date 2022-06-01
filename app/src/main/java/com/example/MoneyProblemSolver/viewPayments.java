package com.example.MoneyProblemSolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class viewPayments extends AppCompatActivity {

    public DBHandler database = new DBHandler(this);

    public EditText infoBox;
    public ArrayList<PaymentModel> test;

    public int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_payments);

        this.infoBox = findViewById(R.id.infoBox);
        this.test = new ArrayList<>();

        test = database.readExams();

        if (test.size() > 0)
            infoBox.setText(test.get(index).toString());
        else
            infoBox.setText("You have not added any payments.");

        configChangeToMainScreen();
        configNext();
        configPrevious();
        configRemove();
    }


    public void configChangeToMainScreen(){
        Button goBack = findViewById(R.id.BackButton2);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                startActivity(new Intent(viewPayments.this, MainActivity.class));
            }
        });


    }

    public void configPrevious(){
        Button goBack = findViewById(R.id.prevButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                if (index > 0)
                {
                    index--;
                    infoBox.setText(test.get(index).toString());
                }
            }
        });


    }

    public void configNext(){
        Button goBack = findViewById(R.id.nextButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                if (test.size() > index)
                {index++;
                infoBox.setText(test.get(index).toString());}
            }
        });


    }


    public void configRemove(){
        Button removeButton = findViewById(R.id.removeButton);
        EditText removeNumber = findViewById(R.id.examNoBox);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                database.deleteEntry(Integer.parseInt(removeNumber.getText().toString()));
                if (test.size() > 0) {
                    database.deleteEntry(test.get(index).getCourseName());
                    test = database.readExams();
                }
                if (test.size() > 0)
                    infoBox.setText(test.get(index).toString());
                else
                    infoBox.setText("You have no payments.");
            }
        });
    }
}