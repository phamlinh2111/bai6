package com.example.bai6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);

        Student s = students.get(position);

        ImageView imgAvatar = convertView.findViewById(R.id.imgAvatar);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtMssv = convertView.findViewById(R.id.txtMssv);

        String avatarName = s.getAvatar();

        int imageResId = context.getResources().getIdentifier(avatarName, "drawable", context.getPackageName());

        imgAvatar.setImageResource(imageResId);

        txtName.setText(s.getName());
        txtMssv.setText("MSSV: " + s.getMssv());

        return convertView;
    }
}

