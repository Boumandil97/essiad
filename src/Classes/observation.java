package Classes;

import java.sql.Date;

import javafx.scene.text.Text;

public class observation {
	private int id_per;
	private int id_pat;
	private Date date;
	private String txt;
	public observation(int id_per, int id_pat, Date date, String txt) {
		super();
		this.id_per = id_per;
		this.id_pat = id_pat;
		this.date = date;
		this.txt = txt;
	}
	public int getId_per() {
		return id_per;
	}
	public void setId_per(int id_per) {
		this.id_per = id_per;
	}
	public int getId_pat() {
		return id_pat;
	}
	public void setId_pat(int id_pat) {
		this.id_pat = id_pat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}

}
