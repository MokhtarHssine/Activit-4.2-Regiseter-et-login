package com.projet.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Classe pour manipuler la base de données
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Contacts table name
    private final String TABLE_REGISTER = "register";
    private final String KEY_ID = "id";
    private final String KEY_FIRST_NAME = "first_name";
    private final String KEY_lAST_NAME = "last_name";
    private final String KEY_EMAIL_ID = "email_id";
    private final String KEY_DATE = "date_naiss";
    private final String KEY_PASSWORD = "password";
    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRST_NAME + " TEXT," + KEY_lAST_NAME
            + " TEXT," + KEY_EMAIL_ID + " TEXT,"
            + KEY_DATE + " TEXT," + KEY_PASSWORD + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);

    }

    void addRegister(RegisterData registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, registerdata.getfirstName()); // register first Name
        values.put(KEY_lAST_NAME, registerdata.getlastName()); // register last name
        values.put(KEY_EMAIL_ID, registerdata.getEmailId());//register email id
        values.put(KEY_DATE, registerdata.getDateNaiss());//register mobile no
        values.put(KEY_PASSWORD, registerdata.getPassword());

        // Inserting Row
        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection
    }

    public RegisterData getRegister(String userid) {
        RegisterData reg = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_REGISTER, null, "email_id=?",
                new String[]{userid}, null, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
        } else if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            reg = new RegisterData(
                    cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)),
                    cursor.getString(cursor.getColumnIndex(KEY_lAST_NAME)),
                    cursor.getString(cursor.getColumnIndex(KEY_EMAIL_ID)),
                    cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)),
                    cursor.getString((cursor.getColumnIndex(KEY_DATE)))
            );
            cursor.close();
        }
        return reg;
    }

    //code to get a register
    public boolean updateData(String id, String firstName, String lastName, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FIRST_NAME, firstName);
        contentValues.put(KEY_lAST_NAME, lastName);
        contentValues.put(KEY_DATE, date);
        db.update(TABLE_REGISTER, contentValues, "email_id=?", new String[]{id});
        return true;
    }

    public String getKeylastName() {
        return KEY_lAST_NAME;
    }

    public String getKeyEmailId() {
        return KEY_EMAIL_ID;
    }

    public String getKeyFirstName() {
        return KEY_FIRST_NAME;
    }

    public String getKeyId() {
        return KEY_ID;
    }

    public String getKeyDate() {
        return KEY_DATE;
    }

    public String getKeyPassword() {
        return KEY_PASSWORD;
    }
}
