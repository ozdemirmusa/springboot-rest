package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Kisi;
import com.example.demo.model.Telefonlar;
import com.example.demo.service.KisiServiceImp;
import com.example.demo.service.TelefonserviceImp;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Kontrol {
	@Autowired
	private KisiServiceImp kisiService;
	@Autowired
	private TelefonserviceImp telefonService;

	@PostMapping(path = "/kisiekle")
	public void kisiEkle(@RequestBody Kisi kisi) {
		if (kisiKontrol(kisi.getAd(), kisi.getSoyad(), kisi.getAdres())) {
			kisiService.kisiEkle(kisi);
		}

	}
	@DeleteMapping("/kisisil/{id}")
	public void kisiSil(@PathVariable(value = "id") int id) {
		kisiService.kisiSil(id);
	}

	@PutMapping("/kisiduzelt")
	public void kisiDuzelt(@RequestBody Kisi kisi) {
		if (kisiKontrol(kisi.getAd(), kisi.getSoyad(), kisi.getAdres())) {
			kisiService.kisiGuncelle(kisi);
		}
	}

	public boolean kisiKontrol(String ad, String soyad, String adres) {
		if (kisiService.kayitKontrol(ad, soyad, adres)) {
			return false;
		}
		return true;

	}

	@GetMapping(path = "/kisiliste")
	public List<Kisi> kisiListe() {
		return kisiService.kisiListe();

	}

	@GetMapping("/kisiarama/{ad}")
	public List<Kisi> kisiBul(@PathVariable(value = "ad") String ad) {
		return kisiService.kisiBul(ad);
	}

	@GetMapping("/kisigoster/{id}")
	public Kisi kisiGoster(@PathVariable(value = "id") int id) {
		return kisiService.kisiGoster(id);
	}

	@PostMapping(path = "/telefonekle/{id}")
	public void telefonEkle(@PathVariable(value = "id") int id, @RequestBody Telefonlar telefon) {
		if (telefonKontrol(telefon.getTur(), telefon.getTel())) {
			Kisi k = kisiService.kisiGoster(id);
			telefon.setKisi(k);
			telefonService.telefonEkle(telefon);
		}
	} 

	@DeleteMapping("/telefonsil/{id}")
	public void telefonSil(@PathVariable(value = "id") int id) {
		telefonService.telefonSil(id);
	}

	@PutMapping("/telefonduzelt/{id}")
	public void telefonDuzelt(@PathVariable(value = "id") int id,@RequestBody Telefonlar telefon) {
		if (telefonKontrol(telefon.getTur(), telefon.getTel())) {
			Kisi k = kisiService.kisiGoster(id);
			telefon.setKisi(k);
			telefonService.telefonGuncelle(telefon);
		}
	}

	@GetMapping("/telefongoster/{id}")
	public Telefonlar telefonGoster(@PathVariable(value = "id") int id) {
		return telefonService.telefonGoster(id);
	} 

	@GetMapping("/telefonarama/{tel}")
	public List<Object> telefonBul(@PathVariable(value = "tel") String tel) {
		return telefonService.telefonBul(tel);
	} 
 
	public boolean telefonKontrol(String tur, String telefon) {
		if (telefonService.kayitKontrol(tur, telefon)) {
			return false;
		}
		return true;
	}

}
