package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "coursedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mycourses";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DURATION_COL = "duration";
    private static final String DESCRIPTION_COL = "description";
    private static final String TRACKS_COL = "tracks";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)";
        db.execSQL(query);
    }
    public void addNewCourse(String courseName, String courseDuration, String courseDescription, String courseTracks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, courseName);
        values.put(DURATION_COL, courseDuration);
        values.put(DESCRIPTION_COL, courseDescription);
        values.put(TRACKS_COL, courseTracks);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<CourseModal> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
//                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
//                        cursorCourses.getString(4),
//                        cursorCourses.getString(2),
//                        cursorCourses.getString(3)));
                CourseModal courseModal = new CourseModal();
                courseModal.setCourseName(cursorCourses.getString(1));
                courseModal.setCourseDuration(cursorCourses.getString(2));
                courseModal.setCourseDescription(cursorCourses.getString(3));
                courseModal.setCourseTracks(cursorCourses.getString(4));
                courseModalArrayList.add(courseModal);
            } while (cursorCourses.moveToNext());
        }

        cursorCourses.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
