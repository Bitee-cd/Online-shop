package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.menu.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {
    private static final String SETTINGS = "1.Change Password " + System.lineSeparator()
            +"2. Change Email ";
    private ApplicationContext context;
    {
       context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        Menu menuToNavigate = null;
        mainLoop: while (true){
            printMenuHeader();
            if(context.getLoggedInUser()==null){
                System.out.println("Please log in or create new account to change settings");
                new MainMenu().start();
                return;
            }else{
                System.out.println(SETTINGS);
                System.out.println("Please enter option or type 'menu' to return back to main menu");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.next();

                if(userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)){
                    menuToNavigate = new MainMenu();
                    break mainLoop;
                }

                int userOption = Integer.parseInt(userInput);
                switch(userOption){
                    case 1:
                        menuToNavigate = new ChangePasswordMenu();
                        break mainLoop;
                    case 2:
                        menuToNavigate = new ChangeEmailMenu();
                        break mainLoop;

                    default:
                        System.out.println("Only 1, 2 is allowed. Try one more time");
                        continue;
                }
            }
        }
menuToNavigate.start();


    }

    @Override
    public void printMenuHeader() {
    System.out.println("***** SETTINGS *****");
    }
}
