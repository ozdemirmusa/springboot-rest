package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefonlar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tur;
	private String tel;
	@ManyToOne
	private Kisi kisi;

	public Telefonlar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefonlar(String tur, String tel, Kisi kisi) {
		super();
		this.tur = tur;
		this.tel = tel;
		this.kisi = kisi;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	public int getId() {
		return id;
	}

}
