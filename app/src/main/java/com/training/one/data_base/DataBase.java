package com.training.one.data_base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.training.one.model.Person;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(@Nullable Context context) {
        super(context, InfoDataBase.DATABASE_NAME, null, InfoDataBase.DATABASE_VERSION);
        this.context = context;
        isDataBase();
    }

    public void isDataBase() {
        File check = new File(InfoDataBase.PACKAGE);
        if (!check.exists()) {
            check.mkdir();
        }

        check = context.getDatabasePath(InfoDataBase.DATABASE_NAME);

        if (!check.exists()) {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(InfoDataBase.DATABASE_SOURCE);

        String outFileName = InfoDataBase.PACKAGE + InfoDataBase.DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public List<Person> getAllPerson() {
        SQLiteDatabase dbsLite = this.getReadableDatabase();
        List<Person> output = new ArrayList<>();
        String query = "SELECT * FROM person";
        Cursor cursor = dbsLite.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_FIELD)));
                person.setDescription(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_DESCRIPTION)));
                person.setImageUrl(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_IMAGE_URL)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_FAVORITE)));
                output.add(person);
            } while (cursor.moveToNext());
        }

        cursor.close();
        dbsLite.close();

        return output;
    }

    public List<Person> getIranPerson() {
        SQLiteDatabase dbsLite = this.getReadableDatabase();
        List<Person> output = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category = 'irani'";
        Cursor cursor = dbsLite.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_FIELD)));
                person.setDescription(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_DESCRIPTION)));
                person.setImageUrl(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_IMAGE_URL)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_FAVORITE)));
                output.add(person);
            } while (cursor.moveToNext());
        }

        cursor.close();
        dbsLite.close();

        return output;
    }

    public List<Person> getForeignPerson() {
        SQLiteDatabase dbsLite = this.getReadableDatabase();
        List<Person> output = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category = 'foreign'";
        Cursor cursor = dbsLite.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_FIELD)));
                person.setDescription(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_DESCRIPTION)));
                person.setImageUrl(cursor.getString(cursor.getColumnIndex(InfoDataBase.DATA_IMAGE_URL)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(InfoDataBase.DATA_FAVORITE)));
                output.add(person);
            } while (cursor.moveToNext());
        }

        cursor.close();
        dbsLite.close();

        return output;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
