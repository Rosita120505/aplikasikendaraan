package com.rositasrs.aplikasikendaraan.repository;

import com.rositasrs.aplikasikendaraan.model.entity.KendaraanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KendaraanRepository extends JpaRepository<KendaraanEntity, String> {

    Optional<KendaraanEntity> findByNoRegistrasi(String noRegistrasi);

    Optional<KendaraanEntity> findByKendaraanId(Integer id);
}
