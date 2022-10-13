package com.kuroyuki.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etnama, etnowhatsapp, etalamat, etpassword, etpin;
    private RadioGroup rgjk;
    private RadioButton rbjk;
    private Button btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etnowhatsapp = findViewById(R.id.et_no_whatsapp);
        etalamat = findViewById(R.id.et_alamat);
        etpassword = findViewById(R.id.et_password);
        etpin = findViewById(R.id.et_pin);
        rgjk = findViewById(R.id.rg_jk);
        btndaftar = findViewById(R.id.btn_daftar);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etnama.getText().toString();
                String nowhatsapp = etnowhatsapp.getText().toString();
                String alamat = etalamat.getText().toString();
                String password = etpassword.getText().toString();
                String pin = etpin.getText().toString();

                int jeniskelaminid = rgjk.getCheckedRadioButtonId();
                rbjk = findViewById(jeniskelaminid);

                String jeniskelamin = rbjk.getText().toString();

                if (nama.trim().equals(""))
                {
                    etnama.setError("Nama Tidak Boleh Kosong");
                }
                else if (nowhatsapp.trim().equals(""))
                {
                    etnowhatsapp.setError("No WhatsApp Tidak Boleh Kosong");
                }
                else if (alamat.trim().equals(""))
                {
                    etalamat.setError("Alamat Tidak Boleh Kosong");
                }
                else if (password.trim().equals(""))
                {
                    etpassword.setError("Password Tidak Boleh Kosong");
                }
                else if (pin.trim().equals(""))
                {
                    etpin.setError("PIN Tidak Boleh Kosong");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("Varnama", nama);
                    intent.putExtra("Varnowhatsapp", nowhatsapp);
                    intent.putExtra("Varalamat", alamat);
                    intent.putExtra("Varjeniskelamin", jeniskelamin);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etalamat.setText("");
        etnowhatsapp.setText("");
        etpassword.setText("");
        etpin.setText("");
    }
}