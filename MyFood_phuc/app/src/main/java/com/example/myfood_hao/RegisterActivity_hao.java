package com.example.myfood_hao;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity_hao extends AppCompatActivity {

    EditText edtUser_hao, edtPass_hao, edtRepass_hao;
    DBHelper_hao dbHelper_hao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_hao);

        edtUser_hao = findViewById(R.id.edtUser_hao);
        edtPass_hao = findViewById(R.id.edtPass_hao);
        edtRepass_hao = findViewById(R.id.edtRepass_hao);
        dbHelper_hao = new DBHelper_hao(this);
    }

    public void dangKy_hao(View view) {
        String user = edtUser_hao.getText().toString().trim();
        String pass = edtPass_hao.getText().toString().trim();
        String repass = edtRepass_hao.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(repass)) {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper_hao.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", pass);

        long result = db.insert("User_hao", null, values);
        if (result != -1) {
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity_hao.class));
            finish();
        } else {
            Toast.makeText(this, "Tên tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
        }
    }
}
