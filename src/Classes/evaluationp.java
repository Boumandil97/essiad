package Classes;

import java.sql.Date;

public class evaluationp {
	
	private int id;
	private String nom;
	private String prenom;
	private String obsQualite;
	private String obsEffort;
	private String obsComportement;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getObsQualite() {
		return obsQualite;
	}
	public void setObsQualite(String obsQualite) {
		this.obsQualite = obsQualite;
	}
	public String getObsEffort() {
		return obsEffort;
	}
	public void setObsEffort(String obsEffort) {
		this.obsEffort = obsEffort;
	}
	public String getObsComportement() {
		return obsComportement;
	}
	public void setObsComportement(String obsComportement) {
		this.obsComportement = obsComportement;
	}
	public Date getDate() {
		return date;
	}
	public evaluationp(int id, String nom, String prenom, String obsQualite, String obsEffort, String obsComportement,
			Date date) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.obsQualite = obsQualite;
		this.obsEffort = obsEffort;
		this.obsComportement = obsComportement;
		this.date = date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	



	
	
	

}
