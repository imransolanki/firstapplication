package example.com.databasedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "DBDemo";
    private DatabaseHelper helper = null;
    protected SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatabase();
//        long insertedRows = storeStudent("Shriram");
//        Log.d(TAG, "onCreate: insertedRows = " + insertedRows);

        String studentName = getStudent();
        Log.d(TAG, "onCreate: studentName=" + studentName);

    }

    private String getStudent() {
        Cursor cursor = database.query("student", new String[]{"name"}, null, null, null, null, null);
        cursor.moveToNext();
        String name = cursor.getString(0);
        Log.d(TAG, "getStudent() returned: " + name);
        return name;
    }

    private void initDatabase() {
        helper = new DatabaseHelper(this, DatabaseHelper.DB_NAME, null, DatabaseHelper.version);
        database = helper.getWritableDatabase();
    }

    public long storeStudent(String studentName) {
        ContentValues values = new ContentValues();
        values.put("name", studentName);
        long result = database.insert("student", null, values);
        return result;
    }

}
