package com.bitee.menu.impl;

import com.bitee.context.ApplicationContext;
import com.bitee.entities.Product;
import com.bitee.menu.Menu;
import com.bitee.services.ProductManagementService;
import com.bitee.services.impl.DefaultProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }


    @Override
    public void start() {
        Menu menuToNavigate = null;
        while(true){
            printMenuHeader();
            printProductsToConsole();
        }

    }


    @Override
    public void printMenuHeader() {
    System.out.println("**** PRODUCT CATALOG *****");
    System.out.println("Enter product id to add it to cart or 'menu' if you want to navigate back to the main menu ");
    }
    private void printProductsToConsole(){
        Product[] products=productManagementService.getProducts();
        for(Product product:products){
            System.out.println(product);
        }
    }
    private String readUserInput(){
        System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
        Scanner sc= new Scanner(System.in);
        String userInput = sc.next();
        return userInput;
    }

    private Product fetchProduct(String userInput){
        int productIdToAddToCart = Integer.parseInt(userInput);
        Product productToAddToCart = productManagementService.getProductById(productIdToAddToCart);
        return productToAddToCart;
    }
    private void processAddToCart(Product productToAddToCart){
        context.getSessionCart().addProduct(productToAddToCart);
        System.out.printf("Product %s has been added to your cart. " +
                "If you want to add a new product - enter the product id. " +
                "If you want to proceed with checkout - enter word. "+
                "'checkout' to console %n", productToAddToCart.getProductName()+
                "");
    }
}
