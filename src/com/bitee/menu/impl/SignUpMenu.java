package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.entities.User;
import com.bitee.entities.impl.DefaultUser;
import com.bitee.menu.Menu;
import com.bitee.services.UserManagementService;
import com.bitee.services.impl.DefaultOrderManagementService;
import com.bitee.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {
   private UserManagementService userManagementService;
   private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.print("Please, enter your first name: ");
        String firstName = sc.next();
        System.out.print("Please enter your last name: ");
        String lastName = sc.next();
        System.out.print("Please enter your password: ");
        String password = sc.next();
        System.out.print("Please enter your email address: ");
        sc = new Scanner(System.in);
        String email=sc.nextLine();

        User user = new DefaultUser(firstName,lastName,password,email);

        String errorMessage = userManagementService.registerUser(user);
        if(errorMessage==null || errorMessage.isEmpty()){
            context.setLoggedInUser(user);
            System.out.println("New user is created");
        }else{
            System.out.println(errorMessage);
        }
        context.getMainMenu().start();

    }

    @Override
    public void printMenuHeader() {
    System.out.println("***** SIGN UP *****");
    }
}
