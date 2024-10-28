package com.karyawanedi.repo;

import org.springframework.data.repository.CrudRepository;

import com.karyawanedi.entity.Karyawan;

public interface KaryawanRepo extends CrudRepository<Karyawan, Long> {

}
