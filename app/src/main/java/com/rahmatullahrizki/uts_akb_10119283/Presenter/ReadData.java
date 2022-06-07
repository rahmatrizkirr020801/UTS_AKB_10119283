package com.rahmatullahrizki.uts_akb_10119283.Presenter;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rahmatullahrizki.uts_akb_10119283.Model.DataHelper;
import com.rahmatullahrizki.uts_akb_10119283.R;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class ReadData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btn1;
    TextView judul,isi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        dbcenter = new DataHelper(this);
        judul = findViewById(R.id.textView1);
        isi = findViewById(R.id.textView2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE judul='" + getIntent().getStringExtra("judul") + "';", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            judul.setText("Judul: " + cursor.getString(0));
            isi.setText("Isi: " + cursor.getString(1));
        }

        btn1 = findViewById(R.id.btn_lihat);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
