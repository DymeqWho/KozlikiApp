package com.dymitrmisiejuk.kozliki.rolelogic.rolecontroller;

import com.dymitrmisiejuk.kozliki.rolelogic.rolemodel.dto.LoginInfo;
import com.dymitrmisiejuk.kozliki.rolelogic.roleservice.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class RoleController {

    private final ModelService modelService;

    @PostMapping(path = "/api/login")
    public String logIn(@RequestBody LoginInfo loginInfo){
      return modelService.logIn(loginInfo);
    }
}
