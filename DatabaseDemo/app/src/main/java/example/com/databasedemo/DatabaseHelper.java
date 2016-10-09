package example.com.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imran on 8/10/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "student_app.db";
    public final static int version = 1;

    private String CREAT_TABLE = "CREATE TABLE student (name text);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //Do nothing for now
    }

}
