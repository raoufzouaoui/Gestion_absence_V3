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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "T_ABSENCES")
public class Absence implements Serializable{

	public Absence() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ABS_ID")
	Long id ;
	
	@Temporal(TemporalType.TIME)
	Date heure;
	@Temporal(TemporalType.DATE)
	Date date;
	
	@OneToOne
	Matiere matiere;
	@ManyToOne(cascade=CascadeType.ALL)
	Etudiant etudiant ;
	@ManyToMany(cascade= CascadeType.ALL)
	Set<Justification> justification;
	
}
