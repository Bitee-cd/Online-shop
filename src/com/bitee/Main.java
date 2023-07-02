package com.bitee;

import com.bitee.menu.Menu;
import com.bitee.menu.impl.MainMenu;

public class Main {
    public static final String EXIT_COMMAND ="exit";
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}