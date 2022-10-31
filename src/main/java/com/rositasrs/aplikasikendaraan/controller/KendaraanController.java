package com.rositasrs.aplikasikendaraan.controller;

import com.rositasrs.aplikasikendaraan.model.dto.*;
import com.rositasrs.aplikasikendaraan.model.entity.KendaraanEntity;
import com.rositasrs.aplikasikendaraan.repository.KendaraanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins="http://localhost:1111")
@RestController
@RequestMapping("/kendaraan")
public class KendaraanController {

        @Autowired
        private KendaraanRepository kendaraanRepository;

        @PostMapping("/save")
        public DefaultResponse saveData(@RequestBody KendaraanDto kendaraanDto){
            KendaraanEntity kendaraan = convertDtoToEntity(kendaraanDto);
            DefaultResponse response = new DefaultResponse();
            Optional<KendaraanEntity> optional = kendaraanRepository.findByNoRegistrasi(kendaraanDto.getNoRegistrasi());
            if(optional.isPresent()){
                response.setStatus(Boolean.FALSE);
                response.setMessage("Error, Data Username Sudah Tersedia");
            } else {
                kendaraanRepository.save(kendaraan);
                response.setStatus(Boolean.TRUE);
                response.setData(kendaraanDto);
                response.setMessage("Berhasil Simpan Data");
            }

            return response;
        }

    @GetMapping("/data") //menampilkan all author
    public List<KendaraanDto> getListKendaraan() {
        List<KendaraanDto> list = new ArrayList<>();
        for (KendaraanEntity a : kendaraanRepository.findAll()) {
            list.add(convertEntitytoDto(a));
        }
        return list;
    }


    private KendaraanDto convertEntitytoDto(KendaraanEntity k) {
        KendaraanDto dto = new KendaraanDto();
        dto.setKendaraanId(k.getKendaraanId());
        dto.setNoRegistrasi(k.getNoRegistrasi());
        dto.setAlamat(k.getAlamat());
        dto.setMerkKendaraan(k.getMerkKendaraan());
        dto.setBahanBakar(k.getBahanBakar());
        dto.setKapasitasSilinder(k.getKapasitasSilinder());
        dto.setNamaPemilik(k.getNamaPemilik());
        dto.setWarna(k.getWarna());
        dto.setTahunPembuatan(k.getTahunPembuatan());

        return dto;
    }
    @PutMapping("/update/{noRegistrasi}")
    public DefaultResponse updateById (@PathVariable String noRegistrasi, @RequestBody KendaraanDto kendaraanDto){
        DefaultResponse defaultResponse = new DefaultResponse();
        try{
            Optional<KendaraanEntity> optionalKendaraanEntity = kendaraanRepository.findByNoRegistrasi(noRegistrasi);
            KendaraanEntity kendaraan = optionalKendaraanEntity.get();
            if (optionalKendaraanEntity.isPresent()){
                kendaraan.setMerkKendaraan(kendaraanDto.getMerkKendaraan());
                kendaraan.setAlamat(kendaraanDto.getAlamat());
                kendaraan.setWarna(kendaraanDto.getWarna());
                kendaraan.setBahanBakar(kendaraanDto.getBahanBakar());
                kendaraan.setKapasitasSilinder(kendaraanDto.getKapasitasSilinder());
                kendaraan.setTahunPembuatan(kendaraanDto.getTahunPembuatan());
                kendaraan.setNamaPemilik(kendaraanDto.getNamaPemilik());
                kendaraan.setNoRegistrasi(kendaraanDto.getNoRegistrasi());
                kendaraanRepository.save(kendaraan);
                defaultResponse.setStatus(Boolean.TRUE);
                defaultResponse.setData(kendaraanDto);
                defaultResponse.setMessage("Succeeded update data");
            }
        }catch(Exception e){
            Optional<KendaraanEntity> optionalKendaraan1 = kendaraanRepository.findByNoRegistrasi(kendaraanDto.getNoRegistrasi());
            defaultResponse.setStatus(Boolean.FALSE);
            if (optionalKendaraan1.isPresent()){
                defaultResponse.setMessage("Error, Data Sudah Tersedia");
            } else {
                defaultResponse.setMessage("Failed to update data, Id was not found");
            }
        }
        return defaultResponse;
    }

    @GetMapping("/{noRegistrasi}")
    public List<KendaraanDto> getById(@PathVariable String noRegistrasi) {
        List<KendaraanDto> list = new ArrayList<>();
        Optional<KendaraanEntity> optionalKendaraan = kendaraanRepository.findByNoRegistrasi(noRegistrasi);
        list.add(convertEntitytoDto(optionalKendaraan.get()));

        return list;
    }

    @DeleteMapping("/delete/{noRegistrasi}")
        public DefaultResponse deleteByNoRegistrasi(@PathVariable String noRegistrasi) {
            DefaultResponse df = new DefaultResponse();
            Optional<KendaraanEntity> optionalKendaraanEntity = kendaraanRepository.findByNoRegistrasi(noRegistrasi);
            if (optionalKendaraanEntity.isPresent()) {
                kendaraanRepository.delete(optionalKendaraanEntity.get());
                df.setStatus(Boolean.TRUE);
                df.setMessage("Data Berhasil Dihapus");
            } else {
                df.setStatus(Boolean.FALSE);
                df.setMessage("Data Tidak Ditemukan");
            }
            return df;
        }

        public KendaraanEntity convertDtoToEntity(KendaraanDto dto){
            KendaraanEntity kendaraan = new KendaraanEntity();
            kendaraan.setKendaraanId(dto.getKendaraanId());
            kendaraan.setNoRegistrasi(dto.getNoRegistrasi());
            kendaraan.setNamaPemilik(dto.getNamaPemilik());
            kendaraan.setAlamat(dto.getAlamat());
            kendaraan.setMerkKendaraan(dto.getMerkKendaraan());
            kendaraan.setTahunPembuatan(dto.getTahunPembuatan());
            kendaraan.setKapasitasSilinder(dto.getKapasitasSilinder());
            kendaraan.setWarna(dto.getWarna());
            kendaraan.setBahanBakar(dto.getBahanBakar());


            return kendaraan;
        }
    }


