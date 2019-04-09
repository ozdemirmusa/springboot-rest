package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Telefonlar;

public interface TelefonService {
	public void telefonEkle(Telefonlar telefon);

	public void telefonSil(int id);

	public void telefonGuncelle(Telefonlar telefon);

	public Telefonlar telefonGoster(int id);

	public List<Object> telefonBul(String telefon);

	public boolean kayitKontrol(String tur, String telefon);
	

}
