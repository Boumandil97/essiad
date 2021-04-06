package Classes;

import java.util.Date;

public abstract class Utilisateur {

	protected int id;
	protected String login;
	protected String password;
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	protected long numSecSoc;
	protected String adresse;
	protected String personneRef;
	protected String username;
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the dateDeNaissance
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	/**
	 * @return the numSecSoc
	 */
	public long getNumSecSoc() {
		return numSecSoc;
	}
	/**
	 * @param numSecSoc the numSecSoc to set
	 */
	public void setNumSecSoc(long numSecSoc) {
		this.numSecSoc = numSecSoc;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the personneRef
	 */
	public String getPersonneRef() {
		return personneRef;
	}
	/**
	 * @param personneRef the personneRef to set
	 */
	public void setPersonneRef(String personneRef) {
		this.personneRef = personneRef;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	


	
	

}
