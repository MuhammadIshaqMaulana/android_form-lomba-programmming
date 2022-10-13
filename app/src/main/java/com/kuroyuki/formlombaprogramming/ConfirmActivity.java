package com.kuroyuki.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
    DatePickerDialog datepickerdialog;
    TextView tvnama, tvjk, tvnowhatsapp, tvalamat, tvtanggal;
    Button btntanggal, btnkonfirmasi;
    String nama, jk, nowhatsapp, alamat, choosendate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvnowhatsapp = findViewById(R.id.tv_no_whatsapp);
        tvalamat = findViewById(R.id.tv_alamat);
        tvtanggal = findViewById(R.id.tv_tanggal);

        btntanggal = findViewById(R.id.btn_tanggal);
        btnkonfirmasi = findViewById(R.id.btn_konfirmasi);

        Intent terima = getIntent();
        nama = terima.getStringExtra("Varnama");
        alamat = terima.getStringExtra("Varalamat");
        nowhatsapp = terima.getStringExtra("Varnowhatsapp");
        jk = terima.getStringExtra("Varjeniskelamin");

        tvnama.setText(nama);
        tvjk.setText(jk);
        tvnowhatsapp.setText(nowhatsapp);
        tvalamat.setText((alamat));

        btntanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalender = Calendar.getInstance();
                datepickerdialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(dayofmonth);
                        choosendate = tanggal + " / " + bulan + " / " + tahun;
                        tvtanggal.setText(choosendate);
                    }
                }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH),
                        newCalender.get(Calendar.DAY_OF_MONTH));
                datepickerdialog.show();
            }
        });

        btnkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah Data Anda Sudah Benar?");

                //button positif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ConfirmActivity.this,
                                "Terima kasih, Pendaftaran Anda Berhasil.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this, "Pendaftaran Anda Tidak Berhasil", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();


            }
        });
    }
}