package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.KisiRepository;
import com.example.demo.model.Kisi;



@Service
@Transactional
public class KisiServiceImp implements KisiService {
	@Autowired
	private KisiRepository kisiRepository;

	@Override
	public void kisiEkle(Kisi kisi) {
		// TODO Auto-generated method stub
		kisiRepository.save(kisi);

	}

	@Override
	public void kisiSil(int id) {
		// TODO Auto-generated method stub
		kisiRepository.delete(id);

	}

	@Override
	public void kisiGuncelle(Kisi kisi) {
		// TODO Auto-generated method stub
		Kisi k = kisiRepository.getOne(kisi.getId());
		k.setAd(kisi.getAd());
		k.setSoyad(kisi.getSoyad());
		k.setAdres(kisi.getAdres());
		kisiRepository.save(k);

	}

	@Override
	public List<Kisi> kisiListe() {
		// TODO Auto-generated method stub
		return kisiRepository.findAll();
	}

	

	@Override
	public boolean kayitKontrol(String ad, String soyad, String adres) {
		// TODO Auto-generated method stub
		 if (kisiRepository.kontrol(ad, soyad, adres)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Kisi kisiGoster(int id) {
		// TODO Auto-generated method stub
		return kisiRepository.findOne(id);
	}

	@Override
	public List<Kisi> kisiBul(String ad) {
		// TODO Auto-generated method stub
		//return kisiRepository.arama(ad);
		return kisiRepository.arama(ad);
	}

}
