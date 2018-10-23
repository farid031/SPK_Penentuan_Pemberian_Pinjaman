package com.farid.spk.nasabah;

public class Nasabah {
    private String no;
    private String id;
    private String nama;
    private String tmpt;
    private String tgl;
    private String alamat;
    private String no_hp;
    private String gaji;
    private String peng;
    private String bpkb;
    private String b_gaji;
    private String b_peng;
    private String b_bpkb;
    private String total_b;

    public void setNo(String no){
        this.no = no;
    }
    public String getNo(){
        return no;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public void setTmpt(String tmpt){
        this.tmpt = tmpt;
    }
    public String getTmpt(){
        return tmpt;
    }

    public String getTgl(){
        return tgl;
    }
    public void setTgl(String tgl){
        this.tgl = tgl;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getAlamat(){
        return alamat;
    }

    public String getNo_hp(){
        return no_hp;
    }
    public void setNo_hp(String no_hp){
        this.no_hp = no_hp;
    }

    public void setGaji(String gaji){
        this.gaji = gaji;
    }
    public String getGaji(){
        return gaji;
    }

    public String getPeng(){
        return peng;
    }
    public void setPeng(String peng){
        this.peng = peng;
    }

    public String getBpkb(){
        return bpkb;
    }
    public void setBpkb(String bpkb){
        this.bpkb = bpkb;
    }

    public void setB_gaji(String b_gaji){
        this.b_gaji = b_gaji;
    }
    public String getB_gaji(){
        return b_gaji;
    }

    public String getB_peng(){
        return b_peng;
    }
    public void setB_peng(String b_peng){
        this.b_peng = b_peng;
    }

    public String getB_bpkb(){
        return b_bpkb;
    }
    public void setB_bpkb(String b_bpkb){
        this.b_bpkb = b_bpkb;
    }

    public String getTotal_b(){
        return total_b;
    }
    public void setTotal_b(String total_b){
        this.total_b = total_b;
    }
}
