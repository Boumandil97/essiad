package Classes;

import java.sql.Date;

public class Conge {
	
	
	private String typeConge;
	private Date dateDebutConge;
	private Date dateFinConge;
	private int idPersonnel;
	private String reponse;
	
	public Conge(int idPersonnel,String typeConge, Date dateDebutConge, Date dateFinConge,String reponse ) {
		super();
		this.typeConge = typeConge;
		this.dateDebutConge = dateDebutConge;
		this.dateFinConge = dateFinConge;
		this.idPersonnel = idPersonnel;
		this.reponse=reponse;
	}
	
	public int getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(int idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public String getTypeConge() {
		return typeConge;
	}
	public void setTypeConge(String typeConge) {
		this.typeConge = typeConge;
	}
	public Date getDateDebutConge() {
		return dateDebutConge;
	}
	public void setDateDebutConge(Date dateDebutConge) {
		this.dateDebutConge = dateDebutConge;
	}
	public Date getDateFinConge() {
		return dateFinConge;
	}
	public void setDateFinConge(Date dateFinConge) {
		this.dateFinConge = dateFinConge;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	
	

}
