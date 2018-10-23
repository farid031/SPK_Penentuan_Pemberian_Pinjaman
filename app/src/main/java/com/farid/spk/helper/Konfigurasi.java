package com.farid.spk.helper;

public class Konfigurasi {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    //Base URL
    private static final String BASE_URL            = "http://192.168.8.101/android/spk/";

    // SPK
    public static final String URL_READ     = BASE_URL + "read.php";
    public static final String URL_INSERT   = BASE_URL + "create.php";
    public static final String URL_RANGKING = BASE_URL + "rangking.php";
    public static final String URL_LOGIN    = BASE_URL + "rangking.php?";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_ID               = "id_nas";
    public static final String KEY_NAMA             = "nama_nas";
    public static final String KEY_TEMPAT_LAHIR     = "tmpt_lahir";
    public static final String KEY_TANGGAL_LAHIR    = "tgl_lahir";
    public static final String KEY_ALAMAT           = "alamat";
    public static final String KEY_NO_HP            = "no_hp";
    public static final String KEY_GAJI             = "gaji";
    public static final String KEY_PENGELUAEAN      = "pengeluaran";
    public static final String KEY_BPKB             = "bpkb";
    public static final String KEY_BOBOT_GAJI       = "bobot_gaji";
    public static final String KEY_BOBOT_PENG       = "bobot_peng";
    public static final String KEY_BOBOT_BPKB       = "bobot_bpkb";
    public static final String KEY_TOTAL_BOBOT      = "total_bobot";
    public static final String KEY_USERNAME       = "username";
    public static final String KEY_PASSWORD       = "password";
    public static final String KEY_NAMA_USER      = "nama";

    //JSON Tags
    public static final String TAG_SUCCESS          = "success";
    public static final String TAG_NASABAH         = "nasabah";
    public static final String TAG_LOGIN           = "login";
    public static final String TAG_RANGKING        = "rangking";
    public static final String TAG_NO               = "no";
    public static final String TAG_ID               = "id_nas";
    public static final String TAG_NAMA             = "nama_nas";
    public static final String TAG_TEMPAT_LAHIR     = "tmpt_lahir";
    public static final String TAG_TANGGAL_LAHIR    = "tgl_lahir";
    public static final String TAG_ALAMAT           = "alamat";
    public static final String TAG_NO_HP            = "no_hp";
    public static final String TAG_GAJI             = "gaji";
    public static final String TAG_PENGELUAEAN      = "pengeluaran";
    public static final String TAG_BPKB             = "bpkb";
    public static final String TAG_BOBOT_GAJI       = "bobot_gaji";
    public static final String TAG_BOBOT_PENG       = "bobot_peng";
    public static final String TAG_BOBOT_BPKB       = "bobot_bpkb";
    public static final String TAG_TOTAL_BOBOT      = "total_bobot";
    public static final String TAG_USERNAME       = "username";
    public static final String TAG_PASSWORD       = "password";
    public static final String TAG_NAMA_USER      = "nama";
}
