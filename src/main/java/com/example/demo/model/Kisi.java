package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kisi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ad;
	private String soyad;
	private String adres;
	@OneToMany(mappedBy = "kisi",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = { "kisi" })
	private List<Telefonlar> telefon;

	public Kisi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kisi(String ad, String soyad, String adres) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
	}

	public int getId() {
		return id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Telefonlar> getTelefon() {
		return telefon;
	}

}
