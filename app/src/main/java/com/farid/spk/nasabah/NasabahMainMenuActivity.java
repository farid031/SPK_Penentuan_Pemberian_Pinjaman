package com.farid.spk.nasabah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farid.spk.R;

public class NasabahMainMenuActivity extends AppCompatActivity implements View.OnClickListener{
    Button BtnAddNas, BtnViewNas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasabah_main_menu);

        BtnAddNas = findViewById(R.id.btnAddNasabah);
        BtnViewNas = findViewById(R.id.btnViewNas);

        BtnAddNas.setOnClickListener(this);
        BtnViewNas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == BtnAddNas){
            startActivity(new Intent(this, CreateNasabahActivity.class));
        }
        if (v == BtnViewNas){
            startActivity(new Intent(this, ReadNasabahActivity.class));
        }
    }
}
