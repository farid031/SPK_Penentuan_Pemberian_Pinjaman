package com.farid.spk.nasabah;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farid.spk.R;

import java.util.ArrayList;

public class NasabahAdapter extends BaseAdapter {
    private Activity activity;
    //private ArrayList<HashMap<String, String>> data;
    private ArrayList<Nasabah> data_nasabah = new ArrayList<Nasabah>();

    private static LayoutInflater inflater = null;

    public NasabahAdapter(android.app.Activity a, ArrayList<Nasabah> d) {
        activity = a;
        data_nasabah = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return data_nasabah.size();
    }
    public Object getItem(int position) {
        return data_nasabah.get(position);
    }
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null) {
            vi = inflater.inflate(R.layout.listview_nasabah, null);
        }
        TextView no = vi.findViewById(R.id.no);
        TextView id = vi.findViewById(R.id.id);
        TextView nama = vi.findViewById(R.id.nama);
        TextView tmpt = vi.findViewById(R.id.tmpt_lahir);
        TextView tgl = vi.findViewById(R.id.tgl_lahir);
        TextView alamat = vi.findViewById(R.id.alamat);
        TextView no_hp = vi.findViewById(R.id.no_hp);
        TextView gaji = vi.findViewById(R.id.gaji);
        TextView peng = vi.findViewById(R.id.peng);
        TextView bpkb = vi.findViewById(R.id.bpkb);

        Nasabah daftar_nasabah = data_nasabah.get(position);
        no.setText(daftar_nasabah.getNo());
        id.setText(daftar_nasabah.getId());
        nama.setText(daftar_nasabah.getNama());
        tmpt.setText(daftar_nasabah.getTmpt());
        tgl.setText(daftar_nasabah.getTgl());
        alamat.setText(daftar_nasabah.getAlamat());
        no_hp.setText(daftar_nasabah.getNo_hp());
        gaji.setText(daftar_nasabah.getGaji());
        peng.setText(daftar_nasabah.getPeng());
        bpkb.setText(daftar_nasabah.getBpkb());

        return vi;
    }
}
