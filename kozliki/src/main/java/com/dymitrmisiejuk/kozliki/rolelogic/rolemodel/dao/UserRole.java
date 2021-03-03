package com.dymitrmisiejuk.kozliki.rolelogic.rolemodel.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UserRole {
    private final String login = "user";
    private final String password = "password";
}
