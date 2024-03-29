package tn.iit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_enseignants")
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String prenom;
	private String mail;
	private int nbheure;
	@OneToMany(mappedBy = "ensignant" , cascade = CascadeType.ALL)
	private List<Autorisation> autorisations;
	
	public Enseignant() {
		this.name = name;
		this.prenom = prenom;
		this.mail = mail;
		this.nbheure = nbheure;
	}

	public Enseignant( String name, String prenom, String mail, int nbheure) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.mail = mail;
		this.nbheure = nbheure;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Enseignant) {
			Enseignant e = (Enseignant) obj;
			return e.name.equals(this.name) & e.prenom.equals(this.prenom);
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNbheure() {
		return nbheure;
	}

	public void setNbheure(int nbheure) {
		this.nbheure = nbheure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
