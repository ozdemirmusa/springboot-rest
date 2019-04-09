package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TelefonRepository;
import com.example.demo.model.Telefonlar;

@Service
@Transactional
public class TelefonserviceImp implements TelefonService {
	@Autowired
	private TelefonRepository telefonRepository;

	@Override
	public void telefonEkle(Telefonlar telefon) {
		// TODO Auto-generated method stub
		telefonRepository.save(telefon);
	}

	@Override
	public void telefonSil(int id) {
		// TODO Auto-generated method stub

		telefonRepository.delete(id);
	}

	@Override
	public void telefonGuncelle(Telefonlar telefon) {
		// TODO Auto-generated method stub
		Telefonlar t = telefonRepository.getOne(telefon.getId());
		t.setTur(telefon.getTur());
		t.setTel(telefon.getTel());
		telefonRepository.save(t);

	}

	@Override
	public Telefonlar telefonGoster(int id) {
		// TODO Auto-generated method stub
		return telefonRepository.findOne(id);
	}

	@Override
	public List<Object> telefonBul(String telefon) {
		// TODO Auto-generated method stub
		return telefonRepository.arama(telefon);
	}

	@Override
	public boolean kayitKontrol(String tur, String telefon) {
		// TODO Auto-generated method stub
		if (telefonRepository.kontrolTel(tur, telefon) > 0) {
			return true;
		}
		return false;
	}

	

}
