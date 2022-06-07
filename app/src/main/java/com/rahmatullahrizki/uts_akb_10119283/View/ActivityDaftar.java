package com.rahmatullahrizki.uts_akb_10119283.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rahmatullahrizki.uts_akb_10119283.Model.DataHelper;
import com.rahmatullahrizki.uts_akb_10119283.Presenter.CreateData;
import com.rahmatullahrizki.uts_akb_10119283.Presenter.ReadData;
import com.rahmatullahrizki.uts_akb_10119283.Presenter.UpdateData;
import com.rahmatullahrizki.uts_akb_10119283.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class ActivityDaftar extends AppCompatActivity {

    String[] daftar,judul;
    DataHelper dbcenter;
    protected Cursor cursor;
    ListView listView01;
    public static ActivityDaftar fd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDaftar.this, CreateData.class);
                startActivity(intent);
            }
        });


        fd = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }


    public void RefreshList() {
        dbcenter = new DataHelper(this);
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan ORDER BY judul", null);
        daftar = new String[cursor.getCount()];
        judul = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(0);
            judul[cc] = cursor.getString(1);
        }

        listView01 = findViewById(R.id.listTeman);
        listView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, judul));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                System.out.println(arg2+" arg2 sel "+selection);
                final CharSequence[] dialogitem = {"Lihat judul", "Update judul", "Hapus judul"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDaftar.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), ReadData.class);
                                i.putExtra("id", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent intent = new Intent(getApplicationContext(), UpdateData.class);
                                intent.putExtra("id", selection);
                                startActivity(intent);
                                break;
                            case 2:
                                System.out.println("delete");
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM catatan WHERE id='" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView01.getAdapter()).notifyDataSetInvalidated();

        //Menampilkan Toolbar
    }

}
