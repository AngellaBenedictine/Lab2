package com.angella.sqlab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 10/20/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Strathmore";

    // Table Names
    private static final String TABLE_UNIT = "Unit";
    private static final String TABLE_LECTURER = "Lecturer";


    // Lec Table - column nmaes
    private static final String KEY_LecId = "Id";
    private static final String KEY_LecName = "Name";

    // Unit Table - column names
    private static final String KEY_ID = "Id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_INFO = "Info";


    // Unit table create statement
    private static final
    String CREATE_UNIT_TABLE = "CREATE TABLE " + TABLE_UNIT + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_INFO + " TEXT" + ");";


    // Lec table create statement
    private static final String
            CREATE_LECTURER_TABLE = "CREATE TABLE " + TABLE_LECTURER + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT " + ");";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_UNIT_TABLE);
        db.execSQL(CREATE_LECTURER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LECTURER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIT);

        // create new tables
        onCreate(db);
    }

    public void addUnit(Unit unit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, unit.getID());
        values.put(KEY_NAME, unit.getName());
        db.insert(TABLE_UNIT, null, values);
        db.close();
    }


    public Unit getUnit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_UNIT, new String[]{KEY_ID, KEY_NAME, KEY_INFO}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Unit unit = new Unit(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return unit;
    }

    public List<Unit> getAllUnit() {
        List<Unit> unitList = new ArrayList<Unit>();
        String selectQuery = "SELECT * FROM " + TABLE_UNIT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Unit unit = new Unit();
                unit.setID(Integer.parseInt(cursor.getString(0)));
                unit.setName(cursor.getString(1));
                unit.set_info(cursor.getString(2));
                unitList.add(unit);
            } while (cursor.moveToNext());
        }
        return unitList;
    }

    public int getUnitsCount() {
        String countQuery = "SELECT * FROM " + TABLE_UNIT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public int updateUnit(Unit unit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, unit.getName());
        values.put(KEY_INFO, unit.get_info());
        return db.update(TABLE_UNIT, values, KEY_ID + "=?", new String[]{String.valueOf(unit.getID())});
    }

    public void deleteUnit(Unit unit) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_UNIT, KEY_ID + "=?", new String[]{String.valueOf(unit.getID())});
        db.close();
    }

    public void addLecturer(Lecturer lecturer){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(KEY_ID,lecturer.getLecId());
        values.put(KEY_NAME, lecturer.getLecName());

        db.insert(TABLE_LECTURER, null, values);
        db.close();
    }
    public Lecturer getLecturer(int id){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_LECTURER, new String []{ KEY_ID, KEY_NAME}, KEY_ID +"=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
      Lecturer lecturer=new Lecturer(Integer.parseInt(cursor.getString(0)), cursor.getString(1));

        return lecturer;
    }
    public List<Lecturer>getAllLecturer(){
        List<Lecturer> lecturersList= new ArrayList<Lecturer>();
        String selectQuery= "SELECT * FROM " + TABLE_LECTURER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
               Lecturer lecturer = new Lecturer();
                lecturer.setLecId(Integer.parseInt(cursor.getString(0)));
                lecturer.setLecName(cursor.getString(1));
               lecturersList.add(lecturer);
            }while(cursor.moveToNext());
        }
        return lecturersList;
    }
    public int getLecturerCount(){
        String countQuery="SELECT * FROM " + TABLE_LECTURER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }
    public int updateLecturer(Lecturer lecturer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME ,lecturer.getLecName());
        return db.update(TABLE_LECTURER, values,KEY_ID + "=?", new String []{String.valueOf(lecturer.getLecId())});
    }
    public void deleteLecturer(Lecturer lecturer){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LECTURER,KEY_ID+"=?", new String []{String.valueOf(lecturer.getLecId())});
        db.close();
    }

}

