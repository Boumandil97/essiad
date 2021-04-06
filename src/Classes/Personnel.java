package Classes;

import java.sql.Date;

public class Personnel extends Utilisateur {
	
	private String type_personnel;
	private String secteur_ratt;
	

	public Personnel(String type_personnel, String secteur_ratt) {
		super();
		this.type_personnel = type_personnel;
		this.secteur_ratt = secteur_ratt;
	}

	
	
	public Personnel(int int1,String username, String string, String string2, String string3, String string4, Date date, long long1,
			String string5, String string6, String string7, String string8) {
		this.username=username;
		this.id=int1;
		this.login=string;
		this.password=string2;
		this.nom=string3;
		this.prenom=string4;
		this.dateDeNaissance=date;
		this.numSecSoc=long1;
		this.adresse=string5;
		this.personneRef=string6;
		this.secteur_ratt=string7;
		this.type_personnel=string8;
		
		
	}



	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getType_personnel() {
		return type_personnel;
	}



	
	public void setType_personnel(String type_personnel) {
		this.type_personnel = type_personnel;
	}




	public String getSecteur_ratt() {
		return secteur_ratt;
	}



	public void setSecteur_ratt(String secteur_ratt) {
		this.secteur_ratt = secteur_ratt;
	}




}
