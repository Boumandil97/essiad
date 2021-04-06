package Classes;

import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Patient {
	private int id;
	private String Prénom;
	private String Nom;
	private String email;
	private Date birthday;
	private String password;
	private String confpassword;
	private long numSecSociale;
	private String personneRefe;
	private String adresse;
	private String adresseprop;
	private String nomMed;
	private String addMed;
	private Integer telMed;
	private String nomPharm;
	private Integer telPharm;
	private String nomLab;
	private Integer telLab;
	private String gender;
	private String situation;
	private String zone;              
	private String nom_acteur;
	private String fonctionalite_acteur;
	private String adresse_acteur;
	private int tel_acteur;
	private String username;
	public Patient() {
		
	}
	
	public String getPrénom() {
		return Prénom;
	}
	
	public void setPrénom(String prénom) {
		Prénom = prénom;
	}
	
	public String getNom() {
		return Nom; 
	}
	
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	public long getNumSecSociale() {
		return numSecSociale;
	}
	public void setNumSecSociale(Integer numSecSociale) {
		this.numSecSociale = numSecSociale;
	}
	public String getPersonneRefe() {
		return personneRefe;
	}
	public void setPersonneRefe(String personneRefe) {
		this.personneRefe = personneRefe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresseprop() {
		return adresseprop;
	}
	public void setAdresseprop(String adresseprop) {
		this.adresseprop = adresseprop;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}
	public String getAddMed() {
		return addMed;
	}
	public void setAddMed(String addMed) {
		this.addMed = addMed;
	}
	public Integer getTelMed() {
		return telMed;
	}
	public void setTelMed(Integer telMed) {
		this.telMed = telMed;
	}
	public String getNomPharm() {
		return nomPharm;
	}
	public void setNomPharm(String nomPharm) {
		this.nomPharm = nomPharm;
	}
	public Integer getTelPharm() {
		return telPharm;
	}
	public void setTelPharm(Integer telPharm) {
		this.telPharm = telPharm;
	}
	public String getNomLab() {
		return nomLab;
	}
	public void setNomLab(String nomLab) {
		this.nomLab = nomLab;
	}
	public Integer getTelLab() {
		return telLab;
	}
	public void setTelLab(Integer telLab) {
		this.telLab = telLab;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Patient(String username, int id,String name,String pr,String mail,Date bday,String pwd,String confpwd,long nsec,String ref,String loc,String locprop
			,String nmm,String locmed,int telmed,String nompharm,int telphm, String nomlab,int tellab,String gender,String situ,String zone,String nom_acteur,String fonctionalite_acteur,String adresse_acteur,int tel_acteur )
	{
	this.username=username;	
	this.id=id;
	this.Nom= name;	
	this.Prénom= pr;	
	this.email= mail;	
	this.birthday= bday;
	this.password= pwd;
	this.confpassword= confpwd;
	this.numSecSociale= nsec;
	this.personneRefe=ref;	
	this.adresse= loc;	
	this.adresseprop= locprop;
	this.nomMed= nmm;	
	this.addMed= locmed;	
	this.telMed= telmed;
	this.nomPharm= nompharm;
	this.telPharm= telphm;
	this.nomLab= nomlab;
	this.telLab= tellab;
	this.gender= gender;
	this.situation= situ;
    this.zone=zone;
    this.nom_acteur=nom_acteur;
    this.fonctionalite_acteur=fonctionalite_acteur;
    this.adresse_acteur=adresse_acteur;
    this.tel_acteur=tel_acteur;
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
	 * @param numSecSociale the numSecSociale to set
	 */
	public void setNumSecSociale(long numSecSociale) {
		this.numSecSociale = numSecSociale;
	}
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getNom_acteur() {
		return nom_acteur;
	}

	public void setNom_acteur(String nom_acteur) {
		this.nom_acteur = nom_acteur;
	}

	public String getFonctionalite_acteur() {
		return fonctionalite_acteur;
	}

	public void setFonctionalite_acteur(String fonctionalite_acteur) {
		this.fonctionalite_acteur = fonctionalite_acteur;
	}

	public String getAdresse_acteur() {
		return adresse_acteur;
	}

	public void setAdresse_acteur(String adresse_acteur) {
		this.adresse_acteur = adresse_acteur;
	}

	public int getTel_acteur() {
		return tel_acteur;
	}

	public void setTel_acteur(int tel_acteur) {
		this.tel_acteur = tel_acteur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	 
	

}