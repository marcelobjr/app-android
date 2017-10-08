package com.example.marcelo.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exercicio3 extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    public static final int REQUEST_EXERCICIO3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3);

        this.mViewHolder.button1 = (Button) findViewById(R.id.button1);
        this.mViewHolder.button2 = (Button) findViewById(R.id.button2);
        this.mViewHolder.editText = (EditText) findViewById(R.id.editText);

        this.mViewHolder.button1.setOnClickListener(this);
        this.mViewHolder.button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(getApplication(), mViewHolder.editText.getText().toString(), Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Intent intent = new Intent(this, Exercicio3SegundaTela.class);
                startActivityForResult(intent, REQUEST_EXERCICIO3);
                break;
        }
    }

    private static class ViewHolder {
        Button button1;
        Button button2;
        EditText editText;
    }
}
