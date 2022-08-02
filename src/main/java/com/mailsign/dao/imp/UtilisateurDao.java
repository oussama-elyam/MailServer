package com.mailsign.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import com.mailsign.entities.Utilisateur;
import com.mailsign.service.inter.IUtilisateur;

public class UtilisateurDao implements IUtilisateur {

	@Override
	public String findOne(String email ,String password) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT Password FROM users WHERE Email = ? and Password =ENCRYPT(?,'dovecot')");

			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getString("Password");
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return null;
	}

	@Override
	public int add(Utilisateur user) {
		try {
			//System.out.print("add_userdao://"+"name"+user.getName()+"email"+user.getEmail()+"password"+user.getPassword());	
			Connection conn = Singleton.getInstance().getConnection();
        	PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(nom,prenom,email,password,active,domaine_id) VALUES (?,?,?,ENCRYPT(?,'dovecot'),1,1)");
			stmt.setString(1,user.getName());
        	stmt.setString(2,user.getPrenom());
        	stmt.setString(3,user.getEmail());
        	stmt.setString(4,user.getPassword());
			stmt.execute();
			return 1;
		} catch (SQLException ex) {
			
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return 0;
	}

}
