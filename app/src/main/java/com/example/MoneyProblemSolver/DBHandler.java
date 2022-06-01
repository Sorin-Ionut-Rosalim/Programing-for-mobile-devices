package com.example.MoneyProblemSolver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "MoneyProblem";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "MyPayments";
    private static final String PAYMENT_ID = "id";
    private static final String PAYMENT_NAME = "PAYMENT_NAME";
    private static final String PAYMENT_DATE = "PAYMENT_DATE";
    private static final String CATEGORY = "CATEGORY";
    private static final String PAYMENT_TIME = "PAYMENT_TIME";
    private static final String PAYMENT_LOCATION = "PAYMENT_LOCATION";
    private static final String OBSERVATIONS = "OBSERVATIONS";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PAYMENT_NAME + " TEXT,"
                + PAYMENT_DATE + " TEXT,"
                + CATEGORY + " TEXT,"
                + PAYMENT_TIME + " TEXT,"
                + PAYMENT_LOCATION + " TEXT,"
                + OBSERVATIONS + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addPayment(String paymentName, String paymentDate, String category, String paymentTime, String paymentLocation, String observations){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PAYMENT_NAME, paymentName);
        values.put(PAYMENT_DATE, paymentDate);
        values.put(CATEGORY, category);
        values.put(PAYMENT_TIME, paymentTime);
        values.put(PAYMENT_LOCATION, paymentLocation);
        values.put(OBSERVATIONS, observations);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<PaymentModel> readExams(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorExams = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<PaymentModel> allPayments = new ArrayList<>();

        if (cursorExams.moveToFirst()){
            do {
                allPayments.add(new PaymentModel(cursorExams.getString(0), cursorExams.getString(1),cursorExams.getString(2),cursorExams.getString(3),cursorExams.getString(4),
                        cursorExams.getString(5),cursorExams.getString(6)));
            } while (cursorExams.moveToNext());
        }
        cursorExams.close();
        return allPayments;

    }

    public void deleteEntry (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+PAYMENT_NAME+"='"+name+"'");
        db.close();
    }

}
