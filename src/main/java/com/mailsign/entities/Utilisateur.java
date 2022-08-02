package com.mailsign.entities;


public class Utilisateur {
	private int id;
	private String name;
	private String prenom;
	private String email;
	private String password;
	
	public Utilisateur(String name,String prenom, String email, String password) {
		super();
		this.setName(name);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setPassword(password);
		
	}

	public Utilisateur(int id, String name,String prenom, String email, String password) {
		super();
		this.setId(id);
		this.setPrenom(name);
		this.setName(prenom);

		this.setEmail(email);
		this.setPassword(password);
		
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		//return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]";
	return "test";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}	
