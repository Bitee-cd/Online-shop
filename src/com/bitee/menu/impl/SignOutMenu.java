package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.menu.Menu;

public class SignOutMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        context.getMainMenu().start();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Out *****");
        System.out.println("Have a nice day! Look forward to welcoming back!");

    }
}