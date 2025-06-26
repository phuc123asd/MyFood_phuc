package com.example.myfood_hao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_hao extends SQLiteOpenHelper {

    public static final String DB_NAME = "Food_hao.db";
    public static final int DB_VERSION = 1;

    public DBHelper_hao(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User_hao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT)");

        db.execSQL("CREATE TABLE Restaurant_hao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "address TEXT, " +
                "image TEXT)");

        db.execSQL("CREATE TABLE Food_hao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "description TEXT, " +
                "price INTEGER, " +
                "size TEXT, " +
                "image TEXT, " +
                "restaurant_id INTEGER)");

        insertInitialData_hao(db);
    }

    private void insertInitialData_hao(SQLiteDatabase db) {
        db.execSQL("INSERT INTO User_hao(username, password) VALUES" +
                "('admin', '123'), ('teo', '123'), ('ti', '123'), ('user1', '123'), ('user2', '123')");

        db.execSQL("INSERT INTO Restaurant_hao(name, address, image) VALUES" +
                "('Bánh mì cô Ba', '123 Lê Lợi', 'banhmi.jpg')," +
                "('Cơm tấm Phúc Mập', '456 Trần Hưng Đạo', 'comtam.jpg')," +
                "('Phở 24h', '789 Nguyễn Huệ', 'pho24.jpg')," +
                "('Gà rán Texas', '321 Hai Bà Trưng', 'texas.jpg')," +
                "('The Coffee House', '654 Nguyễn Văn Cừ', 'coffee.jpg')");

        db.execSQL("INSERT INTO Food_hao(name, description, price, size, image, restaurant_id) VALUES" +
                "('Bánh mì bơ tỏi', 'Giòn, thơm bơ', 15000, 'Small', 'bmt.jpg', 1)," +
                "('Bánh mì bò kho', 'Bò kho ngon', 35000, 'Large', 'bmbo.jpg', 1)," +
                "('Cơm sườn bì', 'Cơm ngon, thịt mềm', 40000, 'Small', 'comsuon.jpg', 2)," +
                "('Cơm trứng chiên', 'Đơn giản mà ngon', 30000, 'Small', 'comtrung.jpg', 2)," +
                "('Phở tái', 'Nước dùng đậm đà', 45000, 'Small', 'pho.jpg', 3)," +
                "('Phở đặc biệt', 'Tái, nạm, gầu đầy đủ', 60000, 'Large', 'phodacbiet.jpg', 3)," +
                "('Gà rán phần nhỏ', 'Gà giòn cay', 30000, 'Small', 'gagan.jpg', 4)," +
                "('Gà rán phần lớn', 'Thêm khoai, nước', 50000, 'Large', 'galon.jpg', 4)," +
                "('Trà sữa House', 'Trà sữa trân châu', 35000, 'Small', 'trasua.jpg', 5)," +
                "('Cà phê sữa đá', 'Đậm đà', 25000, 'Small', 'caphe.jpg', 5)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User_hao");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_hao");
        db.execSQL("DROP TABLE IF EXISTS Food_hao");
        onCreate(db);
    }
}
