package com.example.marcelo.aulaandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcelo.aulaandroid.dao.StudentDAO;
import com.example.marcelo.aulaandroid.model.Student;

import java.util.ArrayList;

public class ExercicioSQL extends AppCompatActivity {

    //private static final int ADICIONAR_ALUNO_CODE = 1987;
    private Student student;
    private ListView lvStudent;
    private ArrayList<Student> students;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_sql);

        carregaLista();
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercicioSQL.this, ExercicioSQLCadastro.class);
                startActivity(intent);
            }
        });

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ExercicioSQL.this, ExercicioSQLCadastro.class);
                it.putExtra("student", adapter.getItem(position));
                startActivity(it);
            }
        });

        registerForContextMenu(lvStudent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student student = adapter.getItem(info.position);
        switch (item.getItemId()) {
            case R.id.mi_nome:
                Toast.makeText(this, "Nome: " + student, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_delete:
                StudentDAO dao = new StudentDAO(this);
                dao.delete(student);
                carregaLista();
                return true;
            default:
                return super.onContextItemSelected(item);
        /*AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.mi_nome:
                Toast.makeText(this, "Nome: "+aluno, Toast.LENGTH_SHORT).show(); */

        }
    }

    private void carregaLista() {
        lvStudent = (ListView) findViewById(R.id.lv_students);
        StudentDAO dao = new StudentDAO(this);
        students = (ArrayList<Student>) dao.buscarStudents();
        adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);
        lvStudent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        carregaLista();
        super.onResume();
    }

}
