package com.bitee.context;

import com.bitee.entities.Cart;
import com.bitee.entities.User;
import com.bitee.entities.impl.DefaultCart;
import com.bitee.menu.Menu;

public class ApplicationContext {
    private static ApplicationContext instance;

    private Menu mainMenu;
    private User loggedInUser;
    private Cart sessionCart;

    private ApplicationContext(){

    }

    public void setLoggedInUser(User user){
        if(this.sessionCart != null){
            this.sessionCart.clear(); //clear the session cart when user is logged in
        }
        this.loggedInUser = user;
    }
    public User getLoggedInUser(){
        return this.loggedInUser;
    }

    public void setMainMenu(Menu menu){
        this.mainMenu = menu;
    }

    public Menu getMainMenu(){
        return this.mainMenu;
    }

    public static ApplicationContext getInstance(){
        if(instance == null){
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Cart getSessionCart(){
        if (this.sessionCart==null){
            this.sessionCart= new DefaultCart();
        }
        return this.sessionCart;
    }

}
