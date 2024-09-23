package com.example.jobportalplacement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;


public class JobDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "jobPortal.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_JOBS="jobs";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_COMPANY = "company";
    private static final String COLUMN_SALARY = "salary";
    private static final String COLUMN_LOCATION = "location";

    public JobDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_JOBS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_COMPANY + " TEXT, " +
                COLUMN_SALARY + " TEXT, " + COLUMN_LOCATION + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBS);
        onCreate(db);
    }

    public long insertJob(String title, String description, String company, String salary, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_COMPANY, company);
        values.put(COLUMN_SALARY, salary);
        values.put(COLUMN_LOCATION, location);

        // Insert the new row and return the id of the inserted row
        return db.insert(TABLE_JOBS, null, values);

    }
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_JOBS, null);

        if (cursor.moveToFirst()) {
            do {
                Job job = new Job();

                // Fetch each column value and set to the job object
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int titleIndex = cursor.getColumnIndex(COLUMN_TITLE);
                int descriptionIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
                int companyIndex = cursor.getColumnIndex(COLUMN_COMPANY);
                int salaryIndex = cursor.getColumnIndex(COLUMN_SALARY);
                int locationIndex = cursor.getColumnIndex(COLUMN_LOCATION);

                job.setId(cursor.getInt(idIndex));
                job.setTitle(cursor.getString(titleIndex));
                job.setDescription(cursor.getString(descriptionIndex));
                job.setCompany(cursor.getString(companyIndex));
                job.setSalary(cursor.getString(salaryIndex));
                job.setLocation(cursor.getString(locationIndex));

                // Add the job object to the list
                jobs.add(job);
            } while (cursor.moveToNext());
        }
        // Close the cursor after processing
        cursor.close();

        return jobs;
    }





}
