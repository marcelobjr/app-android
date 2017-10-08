package com.example.marcelo.aulaandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.marcelo.aulaandroid.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo on 08/10/17.
 */

public class StudentDAO extends SQLiteOpenHelper {
    public StudentDAO(Context context) {
        super(context, "aula", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student(id integer primary key, name TEXT, email TEXT, phone TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table student;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void save(Student student){
        //Montar o Dicionário de Dados = ContentValues
        ContentValues cv = getContentValues(student);
        //pegar uma instância de SQLiteDatabe
        SQLiteDatabase db = getWritableDatabase();
        //insert
        if (student.getId() == null){
            db.insert("student",null,cv);
        }else{
            update(student);
        }

    }

    @NonNull
    private ContentValues getContentValues(Student student) {
        ContentValues cv = new ContentValues();
        cv.put("name",student.getName());
        cv.put("email", student.getEmail());
        cv.put("phone", student.getPhone());
        return cv;
    }

    public Student update(Student student){

        ContentValues cv = getContentValues(student);
        //SQLiteDatabase
        SQLiteDatabase db = getWritableDatabase();
        // operação de update
        String[] params = {student.getId().toString()};
        int retorno = db.update("student",cv,"id = ?",params);
        if (retorno > 0){
            return student;
        }
        return null;
    }

    public Student delete(Student student){

        ContentValues cv = getContentValues(student);
        //SQLiteDatabase
        SQLiteDatabase db = getWritableDatabase();
        // operação de deletar
        String[] params = {student.getId().toString()};
        int retorno = db.delete("student","id = ?",params);
        if (retorno > 0){
            return student;
        }
        return null;
    }

    public List<Student> buscarStudents(){
        String sql = "select * from student;";
        List<Student> students = new ArrayList<Student>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Student student = new Student();
            student.setId(cursor.getInt(cursor.getColumnIndex("id")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));
            student.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            student.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            students.add(student);
        }
        return students;
    }
}
