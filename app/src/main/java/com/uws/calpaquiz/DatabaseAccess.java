package com.uws.calpaquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.Random;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor so that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);
    }

    //to return the single instance of the database
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    //method to return capital of given country

    public String getCapital(String country){

        c=db.rawQuery("select Capital from Countries where Country = '"+country+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String capital = c.getString(0);
            buffer.append(""+capital);
        }
        return buffer.toString();
    }

    public String randCountry(){

        c=db.rawQuery("select Country from Countries order by random() limit 1;", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String country = c.getString(0);
            buffer.append(""+country);
        }
        return buffer.toString();
    }

    public boolean checkAnswer(String country, String answer){

        c=db.rawQuery("select Country, Capital from Countries where Country = '"+country+"' AND Capital = '"+answer+"'", null);

        if (c.moveToFirst()) {
            return true;
        }
        else{
            return false;
        }

    }

    public Question genQuestion(int diffNum){

        Question q = new Question();

        c=db.rawQuery("select Country, Capital from Countries where Difficulty = "+diffNum+" order by random() limit 1;", new String[]{});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String country = c.getString(0);
            String capital = c.getString(1);
            buffer.append(""+country);
            q.setCountry(country);
            q.setCapital(capital);
            q.setCityA(randCity());
            q.setCityB(randCity());
            q.setCityC(randCity());
        }
        //q.setCapital(capital);
        return q;
    }


    public String randCity(){

        c=db.rawQuery("select Capital from Countries order by random() limit 1;", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String country = c.getString(0);
            buffer.append(""+country);
        }
        return buffer.toString();


    }

}
