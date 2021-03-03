package com.dymitrmisiejuk.kozliki.rolelogic.rolemodel.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminRole extends UserRole {
    private final String login = "admin";
    private final String password = "password";
}
