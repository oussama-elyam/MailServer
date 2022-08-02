package com.mailsign.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.mailsign.dao.inter.IEmailDao;
import com.mailsign.entities.Email;

public class EmailDaoImp implements IEmailDao {
    private PreparedStatement statement;
    @Override
    public void save(Email o) {
        try {
			Connection conn = Singleton.getInstance().getConnection();

            statement = conn.prepareStatement("INSERT INTO inbox(`from`,`to`,subject,message,created_at) VALUES(?,?,?,?,?)");
            
            statement.setString(1,o.getFrom());
            statement.setString(2,o.getTo());
            statement.setString(3,o.getSubject());
            statement.setString(4,o.getMessage());
            statement.setDate(5,new Date(o.getCreatedAt().getTime()));
            
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
