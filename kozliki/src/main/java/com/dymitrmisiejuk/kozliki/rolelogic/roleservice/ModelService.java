package com.dymitrmisiejuk.kozliki.rolelogic.roleservice;

import com.dymitrmisiejuk.kozliki.rolelogic.rolemodel.AdminRole;
import com.dymitrmisiejuk.kozliki.rolelogic.rolemodel.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelService {
    private final UserRole userRole;
    private final AdminRole adminRole;

    public String logIn(String login, String password) {
        if (userRole.getLogin().equals(login)
                && userRole.getPassword().equals(password)) {
            return "Zalogowałeś się jako użytkownik.";
        } else if (adminRole.getLogin().equals(login) && adminRole.getPassword().equals(password)) {
            return "Zalogowałeś się jako admin.";
        } else {
            return "niepoprawny login lub hasło!";
        }
    }
}
