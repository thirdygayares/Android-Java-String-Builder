package com.thirdygayares.android_java_string_builder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity {

    private EditText editTextIndex, editTextStudentName;
    private TextView textViewStudents;
    private Button buttonAdd, buttonUpdate, buttonDelete;

    private ArrayList<String> studentList = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        editTextIndex = findViewById(R.id.editTextIndex);
        editTextStudentName = findViewById(R.id.editTextStudentName);
        textViewStudents = findViewById(R.id.textViewStudents);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(v -> addStudent());
        buttonUpdate.setOnClickListener(v -> updateStudent());
        buttonDelete.setOnClickListener(v -> deleteStudent());
    }

    private void addStudent() {
        String studentName = editTextStudentName.getText().toString().trim();
        if (!studentName.isEmpty()) {
            studentList.add(studentName);
            displayStudents();
            editTextStudentName.setText("");
        }
    }

    private void updateStudent() {
        String indexStr = editTextIndex.getText().toString().trim();
        String studentName = editTextStudentName.getText().toString().trim();

        if (!indexStr.isEmpty() && !studentName.isEmpty()) {
            int index = Integer.parseInt(indexStr) - 1; // Convert to zero-based index
            if (index >= 0 && index < studentList.size()) {
                studentList.set(index, studentName);
                displayStudents();
                editTextIndex.setText("");
                editTextStudentName.setText("");
            }
        }
    }

    private void deleteStudent() {
        String indexStr = editTextIndex.getText().toString().trim();
        if (!indexStr.isEmpty()) {
            int index = Integer.parseInt(indexStr) - 1; // Convert to zero-based index
            if (index >= 0 && index < studentList.size()) {
                studentList.remove(index);
                displayStudents();
                editTextIndex.setText("");
                editTextStudentName.setText("");
            }
        }
    }

    private void displayStudents() {
        stringBuilder.setLength(0); // Clear the StringBuilder
        for (int i = 0; i < studentList.size(); i++) {
            stringBuilder.append(i + 1).append(". ").append(studentList.get(i)).append("\n");
        }
        textViewStudents.setText(stringBuilder.toString());
    }
}
