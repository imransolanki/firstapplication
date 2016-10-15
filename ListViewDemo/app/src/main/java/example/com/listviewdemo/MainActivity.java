package example.com.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String[] FROM = new String[]{"ExamName", "SubjectName", "ScoredMarks", "TotalMarks"};
    private int[] TO = new int[]{R.id.exam_name, R.id.subject_name, R.id.scored_marks, R.id.total_marks
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> data = populateData();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.exam_detail_list_item, FROM, TO);
        ListView examList = (ListView) findViewById(R.id.exam_detail_list_view);
        examList.setAdapter(simpleAdapter);

    }

    private ArrayList<HashMap<String, String>> populateData() {

        ArrayList<HashMap<String, String>> detail = new ArrayList<>();

        HashMap<String, String> examDetail = new HashMap<>();
        examDetail.put("ExamName", "External");
        examDetail.put("SubjectName", "Android");
        examDetail.put("ScoredMarks", "49");
        examDetail.put("TotalMarks", "50");

        detail.add(examDetail);

        examDetail.put("ExamName", "Internal");
        examDetail.put("SubjectName", "JQuery");
        examDetail.put("ScoredMarks", "39");
        examDetail.put("TotalMarks", "50");

        detail.add(examDetail);

        return detail;
    }
}
