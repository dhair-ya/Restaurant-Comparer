package com.mycompany.restaurant;
/**
 *
 * @author Dhairya Pal N01576099
 */

import java.util.Scanner;

public class FoodApp {
    static String[] defaultMenuItems = {"Crepe", "Poutine", "Pizza", "Burger", "Dessert"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        String item;
        double rating;
        //Making two restaurants with default menu items
        Restaurant restaurant1 = new Restaurant(defaultMenuItems);
        Restaurant restaurant2 = new Restaurant(defaultMenuItems);
        
        while (true) {
            //Main menu
            System.out.println("\n\nWelcome to restaurant comparer!\nType 1 for displaying restaurant1's menu,");
            System.out.println("1a to add a menu item to restaurant1's menu,");
            System.out.println("1d to delete a menu item from restaurant1's menu,");
            System.out.println("1r to add a rating to an existing restaurant1's menu item");
            System.out.println("2 for displaying restaurant2's menu,");
            System.out.println("2a to add a menu item to restaurant2's menu,");
            System.out.println("2d to delete a menu item from restaurant2's menu,");
            System.out.println("2r to add a rating to an existing restaurant2's menu item");
            System.out.println("c to compare two items in the two restaurants");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    restaurant1.displayMenu();
                    break;
                    
                case "2":
                    restaurant2.displayMenu();
                    break;
                    
                case "1a":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    restaurant1.addMenuItem(item);
                    System.out.printf("%s successfully added to restaurant1's menu!\n", item);
                    break;
                    
                case "2a":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    restaurant2.addMenuItem(item);
                    System.out.printf("%s successfully added to restaurant2's menu!\n", item);
                    break;
                
                case "1d":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    if (restaurant1.menuItems.contains(item)) {
                        restaurant1.removeMenuItem(item);
                        System.out.printf("%s successfully deleted from restaurant1's menu!\n", item);
                        break;
                    }
                    else {
                        System.out.printf("%s not found in restaurant1's menu!\n", item);
                        break;
                    }

                    
                case "2d":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    if (restaurant2.menuItems.contains(item)) {
                        restaurant2.removeMenuItem(item);
                        System.out.printf("%s successfully deleted from restaurant2's menu!\n", item);
                        break;
                    }
                    else {
                        System.out.printf("%s not found in restaurant2's menu!\n", item);
                        break;
                    }
                    
                case "1r":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    
                    if (restaurant1.menuItems.contains(item)) {
                        System.out.printf("Please enter the rating for %s: ", item);
                        rating = scanner.nextDouble();
                        scanner.nextLine();
                        restaurant1.addRating(item, rating);
                        System.out.printf("Rating successfully added for %s in restaurant1's menu!\n", item);
                        break;
                    }
                    else {
                        System.out.printf("%s not found in restaurant1's menu!\n", item);
                        break;
                    }
                    
                case "2r":
                    System.out.print("Please enter the name of menu item: ");
                    item = scanner.nextLine();
                    
                    if (restaurant2.menuItems.contains(item)) {
                        System.out.printf("Please enter the rating for %s: ", item);
                        rating = scanner.nextDouble();
                        scanner.nextLine();
                        restaurant2.addRating(item, rating);
                        System.out.printf("Rating successfully added for %s in restaurant2's menu!\n", item);
                        break;
                    }
                    else {
                        System.out.printf("%s not found in restaurant2's menu!\n", item);
                        break;
                    }
                
                case "c":
                    System.out.print("Enter the menu item you want to compare: ");
                    item = scanner.nextLine();
                    if (restaurant1.menuItems.contains(item) && restaurant2.menuItems.contains(item)) {
                    System.out.printf("In Restaurant1, %s @ $%.2f, rated %.1f\n", item, restaurant1.prices.get(item), restaurant1.averageRating(item));                        
                    System.out.printf("In Restaurant2, %s @ $%.2f, rated %.1f\n", item, restaurant2.prices.get(item), restaurant2.averageRating(item));                        
                    }
                    else if (restaurant1.menuItems.contains(item) && !restaurant2.menuItems.contains(item)){
                        System.out.printf("Restaurant 2 doesn't have %s!\n", item);
                    }
                    else if (restaurant2.menuItems.contains(item) && !restaurant1.menuItems.contains(item)){
                        System.out.printf("Restaurant 1 doesn't have %s!\n", item);
                    }
                    else {
                        System.out.printf("Neither of the restaurants have %s!\n", item);
                    }
                    break;
            }
        }
    }
    
}
