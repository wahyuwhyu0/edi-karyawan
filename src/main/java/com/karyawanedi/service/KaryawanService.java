package com.karyawanedi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karyawanedi.entity.Karyawan;
import com.karyawanedi.repo.KaryawanRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class KaryawanService {

    @Autowired
    private KaryawanRepo repo;

    public Iterable<Karyawan> findAll() {
        return repo.findAll();
    }

    public void addKaryawan(Karyawan karyawan) {
        repo.save(karyawan);
    }

    public void deleteById(long nik) {
        repo.deleteById(nik);
    }

    public Optional<Karyawan> findById(long nik) {
        return repo.findById(nik);
    }

    public void updateKaryawan(Karyawan karyawan) {
        repo.save(karyawan);
    }
}
