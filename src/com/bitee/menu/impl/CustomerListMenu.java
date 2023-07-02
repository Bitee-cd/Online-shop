package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.entities.User;
import com.bitee.menu.Menu;
import com.bitee.services.UserManagementService;
import com.bitee.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        User[]  users = userManagementService.getUsers();

        if(users.length ==0){
            System.out.println("Unfortunately, there are no customers. ");
        }else{
            for (User user:users){
                System.out.println(user);
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }
}
