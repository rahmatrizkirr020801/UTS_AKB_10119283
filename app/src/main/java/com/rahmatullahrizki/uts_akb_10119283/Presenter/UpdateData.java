package com.rahmatullahrizki.uts_akb_10119283.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rahmatullahrizki.uts_akb_10119283.Model.DataHelper;
import com.rahmatullahrizki.uts_akb_10119283.R;
import com.rahmatullahrizki.uts_akb_10119283.View.ActivityDaftar;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class UpdateData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btn1, btn2;
    EditText judul, isi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbcenter = new DataHelper(this);

        judul = findViewById(R.id.updateText1);
        isi = findViewById(R.id.updateText2);

        judul.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE id='"+getIntent().getStringExtra("id") +"';", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            judul.setText(cursor.getString(1));
            isi.setText(cursor.getString(2));
        }

        btn1 = findViewById(R.id.btn_update1);
        btn2 = findViewById(R.id.btn_update2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("UPDATE catatan SET judul='"+ judul.getText().toString() +
                        "', isi='"+ isi.getText().toString() +
                        "' WHERE id='" + getIntent().getStringExtra("id")+"';");
                Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                ActivityDaftar.fd.RefreshList();
                finish();

                // pangggil method di fragmentDaftar
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
