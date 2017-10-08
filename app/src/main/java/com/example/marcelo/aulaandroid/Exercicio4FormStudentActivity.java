package com.example.marcelo.aulaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marcelo.aulaandroid.model.Student;

public class Exercicio4FormStudentActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio4_form_student);


        this.mViewHolder.buttonSave = (Button) findViewById(R.id.buttonSave);
        this.mViewHolder.editName = (EditText) findViewById(R.id.ex4EditName);
        this.mViewHolder.editEmail = (EditText) findViewById(R.id.ex4EditEmail);
        this.mViewHolder.editPhone = (EditText) findViewById(R.id.ex4EditPhone);

        this.mViewHolder.buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name, email, phone;
        name = mViewHolder.editName.getText().toString();
        email = mViewHolder.editEmail.getText().toString();
        phone = mViewHolder.editPhone.getText().toString();
        Student student = new Student(name, email, phone);
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.buttonSave:
                intent.putExtra("student", student);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    private static class ViewHolder {
        EditText editName;
        EditText editEmail;
        EditText editPhone;
        Button buttonSave;

    }
}
