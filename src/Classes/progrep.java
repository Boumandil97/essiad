package Classes;

import java.sql.Date;

public class progrep {
	
	private int id;
	private String nom;
	private String prenom;
	private int note1;
	private int note2;
	private int note3;
	private Date date;
	public progrep(int id, String nom, String prenom, int note1, int note2, int note3,Date date) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.date=date;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the note1
	 */
	public int getNote1() {
		return note1;
	}
	/**
	 * @param note1 the note1 to set
	 */
	public void setNote1(int note1) {
		this.note1 = note1;
	}
	/**
	 * @return the note2
	 */
	public int getNote2() {
		return note2;
	}
	/**
	 * @param note2 the note2 to set
	 */
	public void setNote2(int note2) {
		this.note2 = note2;
	}
	/**
	 * @return the note3
	 */
	public int getNote3() {
		return note3;
	}
	/**
	 * @param note3 the note3 to set
	 */
	public void setNote3(int note3) {
		this.note3 = note3;
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
