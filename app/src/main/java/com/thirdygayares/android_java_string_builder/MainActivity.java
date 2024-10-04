package com.thirdygayares.android_java_string_builder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName;
    private Button btnConcatenate, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText and Button
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        btnConcatenate = findViewById(R.id.btnConcatenate);
        btnStudent = findViewById(R.id.btnStudent);

        btnConcatenate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get user input
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();

                // Use StringBuilder to add first name and last name
                StringBuilder fullName = new StringBuilder();
                fullName.append(firstName).append(" ").append(lastName);

                // Display the full name in a Toast
                Toast.makeText(MainActivity.this, "Full Name: " + fullName.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentList.class));
            }
        });
    }
}