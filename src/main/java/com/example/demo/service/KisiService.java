package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Kisi;



public interface KisiService {
	public void kisiEkle(Kisi kisi);

	public void kisiSil(int id);

	public void kisiGuncelle(Kisi kisi);

	public List<Kisi> kisiListe();

	public Kisi kisiGoster(int id);

	public List<Kisi> kisiBul(String ad);

	public boolean kayitKontrol(String ad, String soyad, String adres);

}
