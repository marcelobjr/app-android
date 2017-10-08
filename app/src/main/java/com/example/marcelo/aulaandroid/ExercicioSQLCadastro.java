package com.example.marcelo.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marcelo.aulaandroid.dao.StudentDAO;
import com.example.marcelo.aulaandroid.model.Student;

public class ExercicioSQLCadastro extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_sqlcadastro);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPhone = (EditText) findViewById(R.id.et_phone);
        Button button = (Button) findViewById(R.id.bt_salvar);

        student = (Student) getIntent().getSerializableExtra("student");
        if (student != null){
            etName.setText(student.getName());
            etEmail.setText(student.getEmail());
            etPhone.setText(student.getPhone());
        }else{
            student = new Student();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setName(etName.getText().toString());
                student.setEmail(etEmail.getText().toString());
                student.setPhone(etPhone.getText().toString());

                StudentDAO dao = new StudentDAO(ExercicioSQLCadastro.this);
                dao.save(student);
                //setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
