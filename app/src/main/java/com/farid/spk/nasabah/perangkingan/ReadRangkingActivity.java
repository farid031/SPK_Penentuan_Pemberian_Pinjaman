package com.farid.spk.nasabah.perangkingan;

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
import com.farid.spk.login.SessionManager;
import com.farid.spk.nasabah.Nasabah;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReadRangkingActivity extends AppCompatActivity {

    SessionManager session;
    ListView list;

    JSONParser jParser = new JSONParser();
    ArrayList<Nasabah> daftar_rangking = new ArrayList<Nasabah>();
    JSONArray daftarRangking = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_rangking);

        list = (ListView) findViewById(R.id.listview_rangking);

        //jalankan ReadDataTask
        ReadDataTask m= (ReadDataTask) new ReadDataTask().execute();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int urutan, long id) {
                //dapatkan data id, nama, nim mahasiswa dan simpan dalam variable string
                String rangking = ((TextView) view.findViewById(R.id.no)).getText().toString();
                String nama = ((TextView) view.findViewById(R.id.nama)).getText().toString();
                String tmpt = ((TextView) view.findViewById(R.id.tmpt_lahir)).getText().toString();
                String tgl = ((TextView) view.findViewById(R.id.tgl_lahir)).getText().toString();
                String alamat = ((TextView) view.findViewById(R.id.alamat)).getText().toString();
                String no_hp= ((TextView) view.findViewById(R.id.no_hp)).getText().toString();
                String gaji = ((TextView) view.findViewById(R.id.gaji)).getText().toString();
                String peng= ((TextView) view.findViewById(R.id.peng)).getText().toString();
                String bpkb= ((TextView) view.findViewById(R.id.bpkb)).getText().toString();
                String b_gaji = ((TextView) view.findViewById(R.id.bobot_gaji)).getText().toString();
                String b_peng= ((TextView) view.findViewById(R.id.bobot_peng)).getText().toString();
                String b_bpkb= ((TextView) view.findViewById(R.id.bobot_bpkb)).getText().toString();
                String b_total= ((TextView) view.findViewById(R.id.bobot_total)).getText().toString();

                //varible string tadi kita simpan dalam suatu Bundle, dan kita parse bundle tersebut bersama intent menuju kelas ViewDataActivity
                Intent i = null;
                i = new Intent(ReadRangkingActivity.this, DetailRangkingActivity.class);
                Bundle b = new Bundle();
                //b.putString("id", id_m);
                b.putString("rangking", rangking);
                b.putString("nama", nama);
                b.putString("tempat", tmpt);
                b.putString("tgl", tgl);
                b.putString("alamat", alamat);
                b.putString("no_hp", no_hp);
                b.putString("gaji", gaji);
                b.putString("peng", peng);
                b.putString("bpkb", bpkb);
                b.putString("b_gaji", b_gaji);
                b.putString("b_peng", b_peng);
                b.putString("b_bpkb", b_bpkb);
                b.putString("b_total", b_total);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    class ReadDataTask extends AsyncTask<String, String, String> {
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ReadRangkingActivity.this);
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
                Toast.makeText(ReadRangkingActivity.this, "Unable to connect to server,please check your internet connection!", Toast.LENGTH_LONG).show();
            }
            if(result.equalsIgnoreCase("no results")){
                Toast.makeText(ReadRangkingActivity.this, "Data empty", Toast.LENGTH_LONG).show();
            }else {
                list.setAdapter(new RangkingAdapter(ReadRangkingActivity.this,daftar_rangking)); //Adapter menampilkan data mahasiswa ke dalam listView
            }
        }

        //method untuk memperoleh daftar mahasiswa dari JSON
        String getDataList(){
            Nasabah tempRangking = new Nasabah();
            List<NameValuePair> parameter = new ArrayList<NameValuePair>();
            try {
                JSONObject json = jParser.makeHttpRequest(Konfigurasi.URL_RANGKING,"POST", parameter);

                int success = json.getInt(Konfigurasi.TAG_SUCCESS);
                if (success == 1) { //Ada record Data (SUCCESS = 1)
                    //Getting Array of daftar_mhs
                    daftarRangking = json.getJSONArray(Konfigurasi.TAG_RANGKING);
                    // looping through All daftar_mhs
                    for (int i = 0; i < daftarRangking.length() ; i++){
                        JSONObject c = daftarRangking.getJSONObject(i);
                        tempRangking = new Nasabah();
                        tempRangking.setNo(c.getString(Konfigurasi.TAG_NO));
                        tempRangking.setId(c.getString(Konfigurasi.TAG_ID));
                        tempRangking.setNama(c.getString(Konfigurasi.TAG_NAMA));
                        tempRangking.setTmpt(c.getString(Konfigurasi.TAG_TEMPAT_LAHIR));
                        tempRangking.setTgl(c.getString(Konfigurasi.TAG_TANGGAL_LAHIR));
                        tempRangking.setAlamat(c.getString(Konfigurasi.TAG_ALAMAT));
                        tempRangking.setNo_hp(c.getString(Konfigurasi.TAG_NO_HP));
                        tempRangking.setGaji(c.getString(Konfigurasi.TAG_GAJI));
                        tempRangking.setPeng(c.getString(Konfigurasi.TAG_PENGELUAEAN));
                        tempRangking.setBpkb(c.getString(Konfigurasi.TAG_BPKB));
                        tempRangking.setB_gaji(c.getString(Konfigurasi.TAG_BOBOT_GAJI));
                        tempRangking.setB_peng(c.getString(Konfigurasi.TAG_BOBOT_PENG));
                        tempRangking.setB_bpkb(c.getString(Konfigurasi.TAG_BOBOT_BPKB));
                        tempRangking.setTotal_b(c.getString(Konfigurasi.TAG_TOTAL_BOBOT));
                        daftar_rangking.add(tempRangking);
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
