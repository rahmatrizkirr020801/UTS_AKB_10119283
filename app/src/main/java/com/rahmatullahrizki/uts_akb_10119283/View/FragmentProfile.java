package com.rahmatullahrizki.uts_akb_10119283.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rahmatullahrizki.uts_akb_10119283.R;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class FragmentProfile extends Fragment {
    TextView nim, nama, kelas, deskripsi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        nim = view.findViewById(R.id.tv_nim);
        nama = view.findViewById(R.id.tv_nama);
        kelas = view.findViewById(R.id.tv_kelas);
        deskripsi = view.findViewById(R.id.tv_deskripsi);

        nim.setText("NIM: 10119283");
        nama.setText("Nama: Rahmatullah Rizki");
        kelas.setText("Kelas: IF-7");
        deskripsi.setText("Deskripsi: \nMahasiswa jurusan Teknik Informatika di UNIKOM yang sedang menempuh jenjang pendidikan S1");
        return view;
    }
}
