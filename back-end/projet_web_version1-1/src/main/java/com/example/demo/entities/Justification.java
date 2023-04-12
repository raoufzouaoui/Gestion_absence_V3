package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "T_JUSTIFICATION")
public class Justification implements Serializable{

	public Justification() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JUST_ID")
	Long id ;
	
	@Temporal(TemporalType.DATE)
	Date Date_deb;
	
	@Temporal(TemporalType.DATE)
	Date date_fin;
	@Column(name="JUST_COM")
	String nom ;
	@ManyToMany(cascade=CascadeType.ALL , mappedBy="justification")
	Set<Absence> absence ;
}
