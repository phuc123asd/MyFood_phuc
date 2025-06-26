package com.example.myfood_hao;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_hao extends AppCompatActivity {

    EditText edtUsername_hao, edtPassword_hao;
    Button btnLogin_hao;
    TextView txtRegister_hao;
    DBHelper_hao dbHelper_hao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_hao);

        edtUsername_hao = findViewById(R.id.edtUsername_hao);
        edtPassword_hao = findViewById(R.id.edtPassword_hao);
        btnLogin_hao = findViewById(R.id.btnLogin_hao);
        txtRegister_hao = findViewById(R.id.txtRegister_hao);

        dbHelper_hao = new DBHelper_hao(this);

        btnLogin_hao.setOnClickListener(v -> checkUser_hao());

        txtRegister_hao.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity_hao.this, RegisterActivity_hao.class);
            startActivity(intent);
        });
    }

    private void checkUser_hao() {
        String username = edtUsername_hao.getText().toString().trim();
        String password = edtPassword_hao.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper_hao.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User_hao WHERE username=? AND password=?", new String[]{username, password});

        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity_hao.class));
            finish();
        } else {
            Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
    }
}
