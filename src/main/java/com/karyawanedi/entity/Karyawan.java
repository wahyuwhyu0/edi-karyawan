package com.karyawanedi.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_karyawan", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nik")
})

public class Karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String nik;

    @Column(length = 128, nullable = true)
    private String posisi;

    @Column(length = 128, nullable = false)
    private String nama;

    @Column(length = 128, nullable = true)
    private String tempat_lahir;

    @Column(nullable = true)
    private LocalDate tgl_lahir;

    @Column(length = 10, nullable = true)
    private String jns_kelamin;

    @Column(length = 12, nullable = true)
    private String agama;

    @Column(length = 3, nullable = true)
    private String gol_darah;

    @Column(length = 12, nullable = true)
    private String stat_pernikahan;

    @Column(length = 256, nullable = true)
    private String alm_ktp;

    @Column(length = 256, nullable = true)
    private String alm_tinggal;

    @Column(length = 128, nullable = false)
    private String email;

    @Column(length = 16, nullable = true)
    private String no_telp;

    @Column(length = 64, nullable = true)
    private String kontak_darurat;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Karyawan(String nama, String email, String password, Collection<Role> roles) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Karyawan() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public LocalDate getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(LocalDate tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJns_kelamin() {
        return jns_kelamin;
    }

    public void setJns_kelamin(String jns_kelamin) {
        this.jns_kelamin = jns_kelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getGol_darah() {
        return gol_darah;
    }

    public void setGol_darah(String gol_darah) {
        this.gol_darah = gol_darah;
    }

    public String getStat_pernikahan() {
        return stat_pernikahan;
    }

    public void setStat_pernikahan(String stat_pernikahan) {
        this.stat_pernikahan = stat_pernikahan;
    }

    public String getAlm_ktp() {
        return alm_ktp;
    }

    public void setAlm_ktp(String alm_ktp) {
        this.alm_ktp = alm_ktp;
    }

    public String getAlm_tinggal() {
        return alm_tinggal;
    }

    public void setAlm_tinggal(String alm_tinggal) {
        this.alm_tinggal = alm_tinggal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getKontak_darurat() {
        return kontak_darurat;
    }

    public void setKontak_darurat(String kontak_darurat) {
        this.kontak_darurat = kontak_darurat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
