package com.mailsign.service.inter;

import com.mailsign.entities.Email;
import com.mailsign.entities.Utilisateur;

public interface EmailService {
    void create(Email o, Utilisateur user);


}
