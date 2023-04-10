package com.example.demo.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	int num;
	String rue;
	String ville;
	int code_postale;
}
