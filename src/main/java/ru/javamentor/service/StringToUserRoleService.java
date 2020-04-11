package ru.javamentor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.javamentor.model.UserRole;

@Service
public class StringToUserRoleService implements Converter<String, UserRole>{
    private UserRoleService userRoleService;

    public StringToUserRoleService() {
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    public UserRole convert(String role){
        return userRoleService.findByRole(role);
    }

}