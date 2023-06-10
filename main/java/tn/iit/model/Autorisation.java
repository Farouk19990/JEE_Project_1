package tn.iit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_autorisation")
public class Autorisation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String date;
	private int nbheure;
	@ManyToOne
	@JoinColumn(name="ensignant_id")
	private Enseignant ensignant;
	public Autorisation(String date, int nbheure, Enseignant ensignant) {
		super();
		this.date = date;
		this.nbheure = nbheure;
		this.ensignant = ensignant;
	}
	public Autorisation() {
		super();
		this.date = date;
		this.nbheure = nbheure;
		this.ensignant = ensignant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNbheure() {
		return nbheure;
	}
	public void setNbheure(int nbheure) {
		this.nbheure = nbheure;
	}
	public Enseignant getEnsignant() {
		return ensignant;
	}
	public void setEnsignant(Enseignant ensignant) {
		this.ensignant = ensignant;
	}
}
