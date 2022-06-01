package com.example.MoneyProblemSolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureButtons();
    }

    private void configureButtons(){
        configureAddButton();
        configureExitButton();
        configureViewButton();
    }

    private void configureViewButton(){
        Button viewButton = findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, viewPayments.class));
            }
        });
    }

    private void configureAddButton(){
        Button viewButton = findViewById(R.id.insButton);
        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, MainScreen.class));
            }
        });
    }

    public void configureExitButton(){
        Button goBack = findViewById(R.id.exitButton);
        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                finish();
                System.exit(0);
            }
        });


    }

}