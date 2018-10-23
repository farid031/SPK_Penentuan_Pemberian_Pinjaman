package com.farid.spk.nasabah;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.farid.spk.R;
import com.farid.spk.helper.JSONParser;
import com.farid.spk.helper.Konfigurasi;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReadNasabahActivity extends AppCompatActivity {

    ListView list;

    JSONParser jParser = new JSONParser();
    ArrayList<Nasabah> daftar_nasabah = new ArrayList<Nasabah>();
    JSONArray daftarNasabah = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_nasabah);

        list = (ListView) findViewById(R.id.listview_nasabah);

        //jalankan ReadDataTask
        ReadDataTask m= (ReadDataTask) new ReadDataTask().execute();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int urutan, long id) {
                //dapatkan data id, nama, nim mahasiswa dan simpan dalam variable string
                //String id_m = ((TextView) view.findViewById(R.id.id)).getText().toString();
                String nama = ((TextView) view.findViewById(R.id.nama)).getText().toString();
                String tmpt = ((TextView) view.findViewById(R.id.tmpt_lahir)).getText().toString();
                String tgl = ((TextView) view.findViewById(R.id.tgl_lahir)).getText().toString();
                String alamat = ((TextView) view.findViewById(R.id.alamat)).getText().toString();
                String no_hp= ((TextView) view.findViewById(R.id.no_hp)).getText().toString();
                String gaji = ((TextView) view.findViewById(R.id.gaji)).getText().toString();
                String peng= ((TextView) view.findViewById(R.id.peng)).getText().toString();
                String bpkb= ((TextView) view.findViewById(R.id.bpkb)).getText().toString();

                //varible string tadi kita simpan dalam suatu Bundle, dan kita parse bundle tersebut bersama intent menuju kelas ViewDataActivity
//                Intent i = null;
//                i = new Intent(ReadInActivity.this, ViewdataInActivity.class);
//                Bundle b = new Bundle();
//                //b.putString("id", id_m);
//                b.putString("tanggal", tanggal);
//                b.putString("jam", jam);
//                b.putString("latitude", latitude);
//                b.putString("longitude", longitude);
//                b.putString("kodetoko", kodetoko);
//                b.putString("kodestatus", kodestatus);
//                b.putString("kodeasm", kodeasm);
//                i.putExtras(b);
//                startActivity(i);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    class ReadDataTask extends AsyncTask<String, String, String> {
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ReadNasabahActivity.this);
            pDialog.setMessage("Mohon Tunggu..");
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... sText) {
            return getDataList();

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDialog.dismiss();
            if(result.equalsIgnoreCase("Exception Caught")){
                Toast.makeText(ReadNasabahActivity.this, "Unable to connect to server,please check your internet connection!", Toast.LENGTH_LONG).show();
            }
            if(result.equalsIgnoreCase("no results")){
                Toast.makeText(ReadNasabahActivity.this, "Data empty", Toast.LENGTH_LONG).show();
            }else {
                list.setAdapter(new NasabahAdapter(ReadNasabahActivity.this,daftar_nasabah)); //Adapter menampilkan data mahasiswa ke dalam listView
            }
        }

        //method untuk memperoleh daftar mahasiswa dari JSON
        String getDataList(){
            Nasabah tempNasabah = new Nasabah();
            List<NameValuePair> parameter = new ArrayList<NameValuePair>();
            try {
                JSONObject json = jParser.makeHttpRequest(Konfigurasi.URL_READ,"POST", parameter);

                int success = json.getInt(Konfigurasi.TAG_SUCCESS);
                if (success == 1) { //Ada record Data (SUCCESS = 1)
                    //Getting Array of daftar_mhs
                    daftarNasabah = json.getJSONArray(Konfigurasi.TAG_NASABAH);
                    // looping through All daftar_mhs
                    for (int i = 0; i < daftarNasabah.length() ; i++){
                        JSONObject c = daftarNasabah.getJSONObject(i);
                        tempNasabah = new Nasabah();
                        tempNasabah.setNo(c.getString(Konfigurasi.TAG_NO));
                        tempNasabah.setId(c.getString(Konfigurasi.TAG_ID));
                        tempNasabah.setNama(c.getString(Konfigurasi.TAG_NAMA));
                        tempNasabah.setTmpt(c.getString(Konfigurasi.TAG_TEMPAT_LAHIR));
                        tempNasabah.setTgl(c.getString(Konfigurasi.TAG_TANGGAL_LAHIR));
                        tempNasabah.setAlamat(c.getString(Konfigurasi.TAG_ALAMAT));
                        tempNasabah.setNo_hp(c.getString(Konfigurasi.TAG_NO_HP));
                        tempNasabah.setGaji(c.getString(Konfigurasi.TAG_GAJI));
                        tempNasabah.setPeng(c.getString(Konfigurasi.TAG_PENGELUAEAN));
                        tempNasabah.setBpkb(c.getString(Konfigurasi.TAG_BPKB));
                        daftar_nasabah.add(tempNasabah);
                    }
                    return "OK";
                }else{
                    //Tidak Ada Record Data (SUCCESS = 0)
                    return "no results";
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception Caught";
            }
        }
    }
}
