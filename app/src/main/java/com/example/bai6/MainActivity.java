package com.example.bai6;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbHelper;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        listView = findViewById(R.id.listView);
        students = dbHelper.getAllStudents();

        StudentAdapter adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private static final long DOUBLE_CLICK_TIME_DELTA = 300;
            private long lastClickTime = 0;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long clickTime = System.currentTimeMillis();

                if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                    // DOUBLE CLICK
                    Student s = students.get(position);
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("name", s.getName());
                    intent.putExtra("mssv", s.getMssv());
                    intent.putExtra("avatar", s.getAvatar());
                    intent.putExtra("phone", s.getPhone());
                    intent.putExtra("year", s.getYear());
                    intent.putExtra("major", s.getMajor());
                    intent.putExtra("planfuture", s.getPlanfuture());
                    startActivity(intent);
                }

                lastClickTime = clickTime;
            }
        });



    }
}
