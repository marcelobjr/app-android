package com.example.marcelo.aulaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class HelloWord extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_EXERCICIO2 = 2;
    public static final int REQUEST_EXERCICIO3 = 3;
    public static final int REQUEST_EXERCICIO4 = 4;
    public static final int REQUEST_EXERCICIOSQL = 5;

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_word);

        // Configuração do botão Exercicio 2
        this.mViewHolder.buttonEx2 = (Button) findViewById(R.id.buttonEx2);
        this.mViewHolder.buttonEx2.setOnClickListener(this);
        // Configuração do botão Exercicio 3
        this.mViewHolder.buttonEx3 = (Button) findViewById(R.id.buttonEx3);
        this.mViewHolder.buttonEx3.setOnClickListener(this);
        // Configuração do botão Exercicio 4
        this.mViewHolder.buttonEx4 = (Button) findViewById(R.id.buttonEx4);
        this.mViewHolder.buttonEx4.setOnClickListener(this);
        // Configuração do botão Exercicio SQL
        this.mViewHolder.buttonExSQL = (Button) findViewById(R.id.buttonExSQL);
        this.mViewHolder.buttonExSQL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonEx2:
                intent = new Intent(HelloWord.this, Exercicio2.class);
                startActivityForResult(intent, REQUEST_EXERCICIO2);
                break;
            case R.id.buttonEx3:
                intent = new Intent(HelloWord.this, Exercicio3.class);
                startActivityForResult(intent, REQUEST_EXERCICIO3);
                break;
            case R.id.buttonEx4:
                intent = new Intent(HelloWord.this, Exercicio4.class);
                startActivityForResult(intent, REQUEST_EXERCICIO4);
                break;
            case R.id.buttonExSQL:
                intent = new Intent(HelloWord.this, ExercicioSQL.class);
                startActivityForResult(intent, REQUEST_EXERCICIOSQL);
                break;
        }
    }

    private static class ViewHolder {
        Button buttonEx2;
        Button buttonEx3;
        Button buttonEx4;
        Button buttonExSQL;
    }
}
