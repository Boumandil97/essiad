package Classes;

import java.sql.Date;

public class abscence {
	private String nom;
	private String prenom;
	private String abscence;
	private Date date;
	
	
	public abscence(String nom,String prenom,String abs,Date date) {
		this.nom=nom;
		this.prenom=prenom;
		this.abscence=abs;
		this.date=date;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the abscence
	 */
	public String getAbscence() {
		return abscence;
	}


	/**
	 * @param abscence the abscence to set
	 */
	public void setAbscence(String abscence) {
		this.abscence = abscence;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	

}
