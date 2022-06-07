package com.rahmatullahrizki.uts_akb_10119283.Presenter;


import android.content.Context;
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

import java.nio.charset.Charset;
import java.util.Random;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class CreateData extends AppCompatActivity {
    DataHelper dbcenter;
    Button btn1, btn2;
    EditText judul,isi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbcenter = new DataHelper(this);

        judul = findViewById(R.id.editText1);
        isi = findViewById(R.id.editText2);


        btn1 = findViewById(R.id.btn_edit1);
        btn2 = findViewById(R.id.btn_edit2);

        judul.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("INSERT INTO catatan VALUES('"+generateTextRandom()+"','"+judul.getText().toString()+"','"+isi.getText().toString()+"')");
//                db.execSQL("INSERT INTO catatan values ('" +
//                        judul.getText().toString() + "','" +
//                        isi.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                ActivityDaftar.fd.RefreshList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static String generateTextRandom(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}
