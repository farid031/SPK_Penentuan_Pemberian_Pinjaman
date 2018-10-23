package com.farid.spk.login;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.farid.spk.R;
import com.farid.spk.helper.JSONParser;
import com.farid.spk.helper.Konfigurasi;
import com.farid.spk.nasabah.perangkingan.ReadRangkingActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    Button ButtonDaftar, ButtonLogin, ButtonCancel;
    EditText EditUser, EditPass;
    String url, success;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButtonLogin = findViewById(R.id.buttonLogin);
        ButtonCancel = findViewById(R.id.buttonCancel);
        EditUser = findViewById(R.id.editUser);
        EditPass = findViewById(R.id.editPass);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String username = EditUser.getText().toString().trim();
                String password = EditPass.getText().toString().trim();
                url = Konfigurasi.URL_LOGIN + "username=" + username + "&password=" + password;

                if (username.length() > 0 && password.length() > 0) {
                    new Masuk().execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Username/password masih kosong gan.!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        ButtonCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @SuppressLint("StaticFieldLeak")
    public class Masuk extends AsyncTask<String, String, String> {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Tunggu Bentar ya...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            JSONParser jParser = new JSONParser();
            JSONObject json = jParser.getJSONFromUrl(url);
            try {
                success = json.getString("success");
                Log.e("error", "nilai sukses=" + success);
                JSONArray hasil = json.getJSONArray("login");
                if (success.equals("1")) {
                    for (int i = 0; i < hasil.length(); i++) {
                        JSONObject c = hasil.getJSONObject(i);
                        String username = c.getString("username").trim();
                        String password = c.getString("password").trim();
                        Toast.makeText(LoginActivity.this, "username" + username + "_" + password, Toast.LENGTH_LONG).show();
                        session.createLoginSession(username, password);
                        Log.e("ok", " ambil data");
                    }
                } else {
                    Log.e("error", "tidak bisa ambil data 0");

                }
            } catch (Exception e) {
                // TODO: handle exception
                Log.e("error", "tidak bisa ambil data 1");

            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            pDialog.dismiss();
            if (success.equals("1")) {
                startActivity(new Intent(LoginActivity.this, ReadRangkingActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Username/password salah gan.!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
