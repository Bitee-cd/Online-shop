package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.entities.User;
import com.bitee.menu.Menu;
import com.bitee.services.UserManagementService;
import com.bitee.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance().getInstance();
        userManagementService= DefaultUserManagementService.getInstance();

    }
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.print("PLease Enter your email address: ");
        String userEmail = sc.next();

        System.out.print("Please Enter your password: ");
        String userPassword = sc.next();

        User user = userManagementService.getUserByEmail(userEmail);

        if(user != null && user.getPassword().equals(userPassword)){
            System.out.printf("Glad to see you back %s %s ",user.getFirstName(),user.getLastName() + System.lineSeparator());
            context.setLoggedInUser(user);
        }else{
            System.out.println("Unfortunately such login and password doesn't exist");
        }
        context.getMainMenu().start();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");

    }
}
