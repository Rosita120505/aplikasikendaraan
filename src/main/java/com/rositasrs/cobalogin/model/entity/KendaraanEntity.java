package com.rositasrs.cobalogin.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_kendaraan")
public class KendaraanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_kendaraan")
    @Column(name = "kendaraan_id")
    private Integer kendaraanId;

    public Integer getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(Integer kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    @Column(name = "no_registrasi")
    private String noRegistrasi;
    @Column(name = "nama_pemilik")
    private String namaPemilik;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "merk_kendaraan")
    private String merkKendaraan;
    @Column(name = "tahun_pembuatan")
    private Integer tahunPembuatan;
    @Column(name = "kapasitas_silinder")
    private String kapasitasSilinder;
    @Column(name = "warna")
    private String warna;
    @Column(name = "bahan_bakar")
    private String bahanBakar;

    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        this.noRegistrasi = noRegistrasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public Integer getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(Integer tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public String getKapasitasSilinder() {
        return kapasitasSilinder;
    }

    public void setKapasitasSilinder(String kapasitasSilinder) {
        this.kapasitasSilinder = kapasitasSilinder;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
}
