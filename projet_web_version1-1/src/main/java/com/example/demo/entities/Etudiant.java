package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter

@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "T_ETUDIANT")
public class Etudiant implements Serializable {

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//generation de Id
	@Column(name = "ETUD_CIN")
	Long cin ;
	@Column(name = "ETUD_NOM")
	String nom;
	@Column(name = "ETUD_PRENOM")
	String prenom;
	@Embedded
	Adresse adresse;
	@Temporal(TemporalType.DATE)
	Date date_naissance;
	@Transient
	float age;
	@Enumerated(EnumType.STRING)
	Groupe groupe;
	@Column(name="ENS_EMAIL")
	String email ;
}
