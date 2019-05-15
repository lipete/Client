package com.peterli.client;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri1 = Uri.parse("content://com.peter.provider/Student");
        Uri uri2 = Uri.parse("content://com.peter.provider/Teacher");

        ContentValues values1 = new ContentValues();
        values1.put("name", "小黑");
        values1.put("age", 18);
        ContentResolver resolver1 = getContentResolver();
        resolver1.insert(uri1, values1);

        ContentValues values2 = new ContentValues();
        values2.put("name", "黄老师");
        values2.put("age", 78);
        ContentResolver resolver2 = getContentResolver();
        resolver2.insert(uri2, values2);

        Cursor cursor1 = resolver1.query(uri1, null, null, null, null);
        if (cursor1 != null) {
            while (cursor1.moveToNext()) {
                Log.d("AAAAAAAAAAA1", cursor1.getInt(cursor1.getColumnIndex("id")) +
                        cursor1.getString(cursor1.getColumnIndex("name")) +
                        cursor1.getInt(cursor1.getColumnIndex("age")));
            }
            cursor1.close();
        }

        Cursor cursor2 = resolver2.query(uri2, null, null, null, null);
        if (cursor2 != null) {
            while (cursor2.moveToNext()) {
                Log.d("AAAAAAAAAAA2", cursor2.getInt(cursor2.getColumnIndex("id")) +
                        cursor2.getString(cursor2.getColumnIndex("name")) +
                        cursor2.getInt(cursor2.getColumnIndex("age")));
            }
            cursor2.close();
        }
    }
}
