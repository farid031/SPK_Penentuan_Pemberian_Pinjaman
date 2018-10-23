package com.farid.spk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farid.spk.login.LoginActivity;
import com.farid.spk.nasabah.NasabahMainMenuActivity;
import com.farid.spk.nasabah.perangkingan.ReadRangkingActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button BtnNas, BtnRangking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        BtnNas = findViewById(R.id.btnMenuNas);
        BtnRangking = findViewById(R.id.btnMenuRangking);

        BtnNas.setOnClickListener(this);
        BtnRangking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == BtnNas){
            startActivity(new Intent(this, NasabahMainMenuActivity.class));
        }
        if (v == BtnRangking){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
