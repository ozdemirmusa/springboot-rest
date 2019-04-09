package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Telefonlar;

@Repository
public interface TelefonRepository extends JpaRepository<Telefonlar, Integer> {
	@Query(value = "SELECT id,tur,tel FROM telefonlar  WHERE tel like %?1%", nativeQuery = true)
	List<Object> arama(String telefon);

	@Query(value = "SELECT count(*) FROM telefonlar  where tur =?1 AND tel=?2", nativeQuery = true)
	int kontrolTel(String tur, String tel);
	
	
	

}
