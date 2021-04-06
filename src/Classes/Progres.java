package Classes;

	import java.sql.Date;
public class Progres {

	
	

	    private int id_patient;
		private String nom_patient;
		private String Prenom_patient;
		private int note_physiologie;
		private int note_psychologie;
		private int note_socialogie;
		private java.sql.Date Date; 
		
		
		
		public Progres(int id,Date date2, String nom, String nString, int int1, int int2, int int3) {
			this.id_patient=id;
			this.Date=date2;
			this.nom_patient=nom;
			this.Prenom_patient=nString;
			this.note_physiologie=int1;
			this.note_psychologie=int2;
			this.note_socialogie=int3;
			
		}
		public String getNom_patient() {
			return nom_patient;
		}
		public void setNom_patient(String nom_patient) {
			this.nom_patient = nom_patient;
		}
		public String getPrenom_patient() {
			return Prenom_patient;
		}
		public void setPrenom_patient(String prenom_patient) {
			Prenom_patient = prenom_patient;
		}
		public int getNote_physiologie() {
			return note_physiologie;
		}
		public void setNote_physiologie(int note_physiologie) {
			this.note_physiologie = note_physiologie;
		}
		public int getNote_psychologie() {
			return note_psychologie;
		}
		public void setNote_psychologie(int note_psychologie) {
			this.note_psychologie = note_psychologie;
		}
		public int getNote_socialogie() {
			return note_socialogie;
		}
		public void setNote_socialogie(int note_socialogie) {
			this.note_socialogie = note_socialogie;
		}
		public java.sql.Date getDate() {
			return Date;
		}
		public void setDate(java.sql.Date date) {
			this.Date = date;
		}
		public int getId_patient() {
			return id_patient;
		}
		public void setId_patient(int id_patient) {
			this.id_patient = id_patient;
		}

		
		
		
		
		
	}

	
	
	
	

