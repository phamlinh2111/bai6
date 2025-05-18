package com.example.bai6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "StudentData.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "mssv TEXT, " +
                "avatar TEXT, " +
                "phone TEXT, " +
                "year TEXT, " +
                "major TEXT, " +
                "planfuture TEXT)";
        db.execSQL(createTable);

        db.execSQL("INSERT INTO student (name, mssv, avatar, phone, year, major, planfuture) VALUES " +
                "('Nguyễn Văn A', '20123456', 'a1', '0901234567', 'Năm 3', 'MT_HTN', 'Học Android xong sẽ đi thực tập')," +
                "('Trần Thị B', '20123457', 'b2', '0987654321', 'Năm 2', 'Viễn thông', 'Tập trung học AI, thi IELTS')," +
                "('Lê Văn C', '20123458', 'c3', '0911222333', 'Năm 4', 'Điện tử', 'Làm đồ án tốt nghiệp, xin việc')," +
                "('Phạm Thị D', '20123459', 'd4', '0933444555', 'Năm 1', 'Viễn thông', 'Rèn luyện kỹ năng lập trình cơ bản')," +
                "('Hoàng Văn E', '20123460', 'e5', '0966112233', 'Năm 3', 'Hệ thống nhúng', 'Tham gia nghiên cứu khoa học và dự án thực tế')," +
                "('Đặng Thị F', '20123461', 'f6', '0977334455', 'Năm 3', 'An toàn thông tin', 'Đi thực tập')," +
                "('Ngô Văn G', '20123462', 'g7', '0909887766', 'Năm 4', 'Điện tử', 'Hoàn thành đồ án và xin việc')," +
                "('Võ Thị H', '20123463', 'h8', '0911223344', 'Năm 3', 'MT_HTN', 'Tham gia các cuộc thi về dữ liệu')," +
                "('Mai Văn I', '20123464', 'i9', '0933556677', 'Năm 2', 'Viễn thông', 'Nâng cao kỹ năng cấu hình mạng')," +
                "('Phan Thị J', '20123465', 'j10', '0922113344', 'Năm 1', 'MT_HTN', 'Tìm hiểu về Machine Learning')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("mssv", student.getMssv());
        values.put("avatar", student.getAvatar());
        values.put("phone", student.getPhone());
        values.put("year", student.getYear());
        values.put("major", student.getMajor());
        values.put("planfuture", student.getPlanfuture());
        db.insert("student", null, values);
        db.close();
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String mssv = cursor.getString(2);
                String avatar = cursor.getString(3);
                String phone = cursor.getString(4);
                String year = cursor.getString(5);
                String major = cursor.getString(6);
                String planfuture = cursor.getString(7);
                studentList.add(new Student(id, name, mssv, avatar, phone, year, major, planfuture));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentList;
    }
}
