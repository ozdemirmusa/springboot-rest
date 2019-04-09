package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Kisi;

@Repository
public interface KisiRepository extends JpaRepository<Kisi, Integer> {

	@Query(value = "SELECT id,ad,soyad,adres FROM kisi  WHERE ad like %?1%", nativeQuery = true)
	List<Kisi> arama(String ad); 

	@Query(value = "select count(*) from Kisi  where ad =:ad AND soyad=:soyad AND adres=:adres")
	int kontrol(@Param("ad") String ad,@Param("soyad") String soyad,@Param("adres") String adres);

}
 