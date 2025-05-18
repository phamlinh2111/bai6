package com.example.bai6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgAvatar = findViewById(R.id.imgAvatarDetail);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtMssv = findViewById(R.id.txtMssv);
        TextView txtPhone = findViewById(R.id.txtPhone);
        TextView txtYear = findViewById(R.id.txtYear);
        TextView txtMajor = findViewById(R.id.txtMajor);
        TextView txtPlan = findViewById(R.id.txtPlan);

        Intent intent = getIntent();

        // Lấy tên hình ảnh và hiển thị
        String avatarName = intent.getStringExtra("avatar");
        int imageResId = getResources().getIdentifier(avatarName, "drawable", getPackageName());
        imgAvatar.setImageResource(imageResId);

        // Lấy và hiển thị các thông tin khác
        txtName.setText("Họ tên: " + intent.getStringExtra("name"));
        txtMssv.setText("MSSV: " + intent.getStringExtra("mssv"));
        txtPhone.setText("SĐT: " + intent.getStringExtra("phone"));
        txtYear.setText("Năm: " + intent.getStringExtra("year"));
        txtMajor.setText("Chuyên ngành: " + intent.getStringExtra("major"));
        txtPlan.setText("Kế hoạch: " + intent.getStringExtra("planfuture"));  // Sửa ở đây
    }
}
