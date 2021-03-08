package com.dymitrmisiejuk.kozliki.role.service;

import com.dymitrmisiejuk.kozliki.role.model.dao.AdminRole;
import com.dymitrmisiejuk.kozliki.role.model.dao.UserRole;
import com.dymitrmisiejuk.kozliki.role.model.dto.LoginInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelService {

    private final UserRole userRole;
    private final AdminRole adminRole;

    public String logIn(LoginInfo loginInfo) {
        if (loginInfo.getLogin().equals(userRole.getLogin())
                && userRole.getPassword().equals(loginInfo.getPassword())) {
            return "Zalogowałeś się jako użytkownik.";
        } else if (adminRole.getLogin().equals(loginInfo.getLogin()) && adminRole.getPassword().equals(loginInfo.getPassword())) {
            return "Zalogowałeś się jako admin.";
        }
        return "niepoprawny login lub hasło!";

    }
}
