package com.farid.spk.nasabah;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.farid.spk.R;
import com.farid.spk.helper.Konfigurasi;
import com.farid.spk.helper.RequestHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class CreateNasabahActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Edit_Nama, Edit_Tgl, Edit_tmpt, Edit_Alamat, Edit_No_Hp, Edit_Gaji, Edit_Peng, Edit_Bpkb;
    String Nama, Tgl, Tmpt, Alamat, No_Hp, Gaji, Peng, Bpkb;
    int intGaji, intPeng, intBpkb;
    Double bobotGaji, bobotPeng, bobotBpkb, totalBobot;
    Button BtnAdd;
    SimpleDateFormat dateFormat;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_nasabah);

        Edit_Nama = findViewById(R.id.editNas);
        Edit_tmpt = findViewById(R.id.editTmptLahir);
        Edit_Tgl = findViewById(R.id.editTglLahir);
        Edit_Alamat = findViewById(R.id.editAlamat);
        Edit_No_Hp = findViewById(R.id.editNoHP);
        Edit_Gaji = findViewById(R.id.editGaji);
        Edit_Peng = findViewById(R.id.editPeng);
        Edit_Bpkb = findViewById(R.id.editBpkb);
        BtnAdd = findViewById(R.id.btnAdd);

        //mengeset format tanggal yyyy-mm-dd
        dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);

        BtnAdd.setOnClickListener(this);
        Edit_Tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tanggal();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == BtnAdd){
            confirmAddData();
        }
    }

    private void tanggal(){
        //Calendar untuk mendapatka tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();

        //Inisialisasi datepicker dialog
        datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //set kalender untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                //meletakkan tanggal yang dipilih pada text view
                Edit_Tgl.setText(dateFormat.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR),newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        //menampilkan date picker dialog
        datePickerDialog.show();
    }

    private void addData(){
        Nama = Edit_Nama.getText().toString().trim();
        Tgl = Edit_Tgl.getText().toString().trim();
        Tmpt = Edit_tmpt.getText().toString().trim();
        Alamat = Edit_Alamat.getText().toString().trim();
        No_Hp = Edit_No_Hp.getText().toString().trim();
        Gaji = Edit_Gaji.getText().toString().trim();
        Peng = Edit_Peng.getText().toString().trim();
        Bpkb = Edit_Bpkb.getText().toString().trim();
        intGaji = Integer.parseInt(Gaji);
        intPeng = Integer.parseInt(Peng);
        intBpkb = Integer.parseInt(Bpkb);
        int a = 0, b = 0, c = 0;

        //pembobotan gaji
        if (intGaji >= 0 && intGaji <= 1000000){
            a = 4;
        }else if (intGaji >= 1000001 && intGaji <= 2000000){
            a = 5;
        }else if (intGaji >= 2000001 && intGaji <= 3000000){
            a = 6;
        }else if (intGaji >= 3000001 && intGaji <= 4000000){
            a = 7;
        }else if (intGaji >= 4000001 && intGaji <= 5000000){
            a = 8;
        }else if (intGaji >= 5000001 && intGaji <= 10000000){
            a = 9;
        }else if (intGaji >= 10000001) {
            a = 10;
        }

        //pembobotan pengeluaran
        if (intPeng >= 0 && intPeng <= 1000000){
            b = 10;
        }else if (intPeng >= 1000001 && intPeng <= 2000000){
            b = 9;
        }else if (intPeng >= 2000001 && intPeng <= 3000000){
            b = 8;
        }else if (intPeng >= 3000001 && intPeng <= 4000000){
            b = 7;
        }else if (intPeng >= 4000001 && intPeng <= 5000000){
            b = 6;
        }else if (intPeng >= 5000001 && intPeng <= 10000000){
            b = 5;
        }else if (intPeng >= 10000001) {
            b = 4;
        }

        //pembobotan bpkb
        if (intBpkb >= 2014 && intBpkb <= 2018){
            c = 10;
        }else if (intBpkb >= 2008 && intBpkb <= 2013){
            c = 5;
        }else if (intBpkb <= 2007) {
            c = c;
        }

        //perhitungan total bobot
        bobotGaji = a * 0.5;
        bobotPeng = b * 0.3;
        bobotBpkb = c * 0.2;
        totalBobot = bobotGaji + bobotPeng + bobotBpkb;

        @SuppressLint("StaticFieldLeak")
        class CreateDataTask extends AsyncTask<String, String, String>{
            private ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CreateNasabahActivity.this, "Menambahkan...", "Tunggu...", false, false);
            }

            @Override
            protected String doInBackground(String... strings) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA, Nama);
                params.put(Konfigurasi.KEY_TEMPAT_LAHIR, Tmpt);
                params.put(Konfigurasi.KEY_TANGGAL_LAHIR, Tgl);
                params.put(Konfigurasi.KEY_ALAMAT, Alamat);
                params.put(Konfigurasi.KEY_NO_HP, No_Hp);
                params.put(Konfigurasi.KEY_GAJI, Gaji);
                params.put(Konfigurasi.KEY_PENGELUAEAN, Peng);
                params.put(Konfigurasi.KEY_BPKB, Bpkb);
                params.put(Konfigurasi.KEY_BOBOT_GAJI, String.valueOf(bobotGaji));
                params.put(Konfigurasi.KEY_BOBOT_PENG, String.valueOf(bobotPeng));
                params.put(Konfigurasi.KEY_BOBOT_BPKB, String.valueOf(bobotBpkb));
                params.put(Konfigurasi.KEY_TOTAL_BOBOT, String.valueOf(totalBobot));

                RequestHandler rh = new RequestHandler();
                return rh.sendPostRequest(Konfigurasi.URL_INSERT, params);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                Toast.makeText(CreateNasabahActivity.this, s, Toast.LENGTH_LONG).show();
                System.out.println("No HP = " + No_Hp);
            }
        }
        CreateDataTask cd = new CreateDataTask();
        cd.execute();
    }

    private void confirmAddData(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Data Yang akan kamu submit tidak akan bisa dirubah lagi.\nApakah kamu yakin ingin menambahkan data tersebut?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        addData();
                        startActivity(new Intent(CreateNasabahActivity.this, ReadNasabahActivity.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
