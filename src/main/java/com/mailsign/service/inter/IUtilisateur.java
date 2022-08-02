package com.mailsign.service.inter;


import com.mailsign.entities.Utilisateur;


public interface IUtilisateur {
	public String findOne(String name,String password);
	public int add(Utilisateur user);
}
