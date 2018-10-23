package com.farid.spk.nasabah.perangkingan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.farid.spk.R;

import org.w3c.dom.Text;

public class DetailRangkingActivity extends AppCompatActivity {
    Double nilai_bobot_gaji = 0.5;
    Double nilai_bobot_peng = 0.3;
    Double nilai_bobot_bpkb = 0.2;

    Double gaji_empat    = 4.0;
    Double gaji_lima     = 5.0;
    Double gaji_enam     = 6.0;
    Double gaji_tujuh    = 7.0;
    Double gaji_delapan  = 8.0;
    Double gaji_sembilan = 9.0;
    Double gaji_sepuluh  = 10.0;

    Double peng_empat    = 4.0;
    Double peng_lima     = 5.0;
    Double peng_enam     = 6.0;
    Double peng_tujuh    = 7.0;
    Double peng_delapan  = 8.0;
    Double peng_sembilan = 9.0;
    Double peng_sepuluh  = 10.0;

    Double bpkb_nol     = 0.0;
    Double bpkb_lima    = 5.0;
    Double bpkb_sepuluh = 10.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rangking);

        TextView TxtRangking = findViewById(R.id.no);
        TextView TxtNama     = findViewById(R.id.nama);
        TextView TxtTmpt     = findViewById(R.id.tmpt_lahir);
        TextView TxtTgl      = findViewById(R.id.tgl_lahir);
        TextView TxtAlamat   = findViewById(R.id.alamat);
        TextView TxtNo_hp    = findViewById(R.id.no_hp);
        TextView TxtGaji     = findViewById(R.id.gaji);
        TextView TxtPeng     = findViewById(R.id.peng);
        TextView TxtBpkb     = findViewById(R.id.bpkb);
        TextView TxtB_gaji   = findViewById(R.id.bobot_gaji);
        TextView TxtB_peng   = findViewById(R.id.bobot_peng);
        TextView TxtB_bpkb   = findViewById(R.id.bobot_bpkb);
        TextView TxtB_total  = findViewById(R.id.bobot_total);

        TextView TxtBobotGaji = findViewById(R.id.nilai_bobot_gaji);
        TextView TxtBobotPeng = findViewById(R.id.nilai_bobot_peng);
        TextView TxtBobotBpkb = findViewById(R.id.nilai_bobot_bpkb);

        TextView TxtGajiEmpat    = findViewById(R.id.gaji_empat);
        TextView TxtGajiLima     = findViewById(R.id.gaji_lima);
        TextView TxtGajiEnam     = findViewById(R.id.gaji_enam);
        TextView TxtGajiTujuh    = findViewById(R.id.gaji_tujuh);
        TextView TxtGajiDelapan  = findViewById(R.id.gaji_delapan);
        TextView TxtGajiSembilan = findViewById(R.id.gaji_sembilan);
        TextView TxtGajiSepuluh  = findViewById(R.id.gaji_sepuluh);

        TextView TxtPengEmpat    = findViewById(R.id.peng_empat);
        TextView TxtPengLima     = findViewById(R.id.peng_lima);
        TextView TxtPengEnam     = findViewById(R.id.peng_enam);
        TextView TxtPengTujuh    = findViewById(R.id.peng_tujuh);
        TextView TxtPengDelapan  = findViewById(R.id.peng_delapan);
        TextView TxtPengSembilan = findViewById(R.id.peng_sembilan);
        TextView TxtPengSepuluh  = findViewById(R.id.peng_sepuluh);

        TextView TxtBpkbNol      = findViewById(R.id.bpkb_nol);
        TextView TxtBpkbLima     = findViewById(R.id.bpkb_lima);
        TextView TxtBpkbSepuluh  = findViewById(R.id.bpkb_sepuluh);

        TextView TxtNilaiGaji = findViewById(R.id.nilai_gaji);
        TextView TxtNilaiPeng = findViewById(R.id.nilai_peng);
        TextView TxtNilaiBpkb = findViewById(R.id.nilai_bpkb);

        TextView TxtPembobotanGaji = findViewById(R.id.pembobotan_gaji);
        TextView TxtPembobotanPeng = findViewById(R.id.pembobotan_peng);
        TextView TxtPembobotanBpkb = findViewById(R.id.pembobotan_bpkb);

        TextView TxtTotalBobot = findViewById(R.id.total_bobot);

        Bundle b = getIntent().getExtras();
        assert b != null;
        String isi_rangking = b.getString("rangking");
        String isi_nama     = b.getString("nama");
        String isi_tmpt     = b.getString("tempat");
        String isi_tgl      = b.getString("tgl");
        String isi_alamat   = b.getString("alamat");
        String isi_no_hp    = b.getString("no_hp");
        String isi_gaji     = b.getString("gaji");
        String isi_peng     = b.getString("peng");
        String isi_bpkb     = b.getString("bpkb");
        String isi_b_gaji   = b.getString("b_gaji");
        String isi_b_peng   = b.getString("b_peng");
        String isi_b_bpkb   = b.getString("b_bpkb");
        String isi_b_total  = b.getString("b_total");

        //meng-set bundle tersebut
        TxtRangking.setText(isi_rangking);
        TxtNama.setText(isi_nama);
        TxtTmpt.setText(isi_tmpt);
        TxtTgl.setText(isi_tgl);
        TxtAlamat.setText(isi_alamat);
        TxtNo_hp.setText(isi_no_hp);
        TxtGaji.setText(isi_gaji);
        TxtPeng.setText(isi_peng);
        TxtBpkb.setText(isi_bpkb);
        TxtB_gaji.setText(isi_b_gaji);
        TxtB_peng.setText(isi_b_peng);
        TxtB_bpkb.setText(isi_b_bpkb);
        TxtB_total.setText(isi_b_total);

        TxtBobotGaji.setText(String.valueOf(nilai_bobot_gaji));
        TxtBobotPeng.setText(String.valueOf(nilai_bobot_peng));
        TxtBobotBpkb.setText(String.valueOf(nilai_bobot_bpkb));

        TxtGajiEmpat.setText(String.valueOf(gaji_empat));
        TxtGajiLima.setText(String.valueOf(gaji_lima));
        TxtGajiEnam.setText(String.valueOf(gaji_enam));
        TxtGajiTujuh.setText(String.valueOf(gaji_tujuh));
        TxtGajiDelapan.setText(String.valueOf(gaji_delapan));
        TxtGajiSembilan.setText(String.valueOf(gaji_sembilan));
        TxtGajiSepuluh.setText(String.valueOf(gaji_sepuluh));

        TxtPengEmpat.setText(String.valueOf(peng_empat));
        TxtPengLima.setText(String.valueOf(peng_lima));
        TxtPengEnam.setText(String.valueOf(peng_enam));
        TxtPengTujuh.setText(String.valueOf(peng_tujuh));
        TxtPengDelapan.setText(String.valueOf(peng_delapan));
        TxtPengSembilan.setText(String.valueOf(peng_sembilan));
        TxtPengSepuluh.setText(String.valueOf(peng_sepuluh));

        TxtBpkbNol.setText(String.valueOf(bpkb_nol));
        TxtBpkbLima.setText(String.valueOf(bpkb_lima));
        TxtBpkbSepuluh.setText(String.valueOf(bpkb_sepuluh));

        TxtNilaiGaji.setText(isi_gaji);
        TxtNilaiPeng.setText(isi_peng);
        TxtNilaiBpkb.setText(isi_bpkb);


//        int a = 0;
//        int c = 0;
//        int d= 0;
//        //pembobotan gaji
//        if (int_gaji >= 0 && int_gaji <= 1000000){
//            a = 4;
//        }else if (int_gaji >= 1000001 && int_gaji <= 2000000){
//            a = 5;
//        }else if (int_gaji >= 2000001 && int_gaji <= 3000000){
//            a = 6;
//        }else if (int_gaji >= 3000001 && int_gaji <= 4000000){
//            a = 7;
//        }else if (int_gaji >= 4000001 && int_gaji <= 5000000){
//            a = 8;
//        }else if (int_gaji >= 5000001 && int_gaji <= 10000000){
//            a = 9;
//        }else if (int_gaji >= 10000001) {
//            a = 10;
//        }
//
//        //pembobotan pengeluaran
//        if (int_peng >= 0 && int_peng <= 1000000){
//            c = 10;
//        }else if (int_peng >= 1000001 && int_peng <= 2000000){
//            c = 9;
//        }else if (int_peng >= 2000001 && int_peng <= 3000000){
//            c = 8;
//        }else if (int_peng >= 3000001 && int_peng <= 4000000){
//            c = 7;
//        }else if (int_peng >= 4000001 && int_peng <= 5000000){
//            c = 6;
//        }else if (int_peng >= 5000001 && int_peng <= 10000000){
//            c = 5;
//        }else if (int_peng >= 10000001) {
//            c = 4;
//        }
//
//        //pembobotan bpkb
//        if (int_bpkb >= 2014 && int_bpkb <= 2018){
//            d = 10;
//        }else if (int_bpkb >= 2008 && int_bpkb <= 2013){
//            d = 5;
//        }else if (int_bpkb <= 2007) {
//            d = c;
//        }

        TxtPembobotanGaji.setText(isi_b_gaji);
        TxtPembobotanPeng.setText(isi_b_peng);
        TxtPembobotanBpkb.setText(isi_b_bpkb);

        TxtTotalBobot.setText(isi_b_total);
    }
}
