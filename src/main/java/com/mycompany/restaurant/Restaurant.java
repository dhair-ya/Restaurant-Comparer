package com.mycompany.restaurant;
/**
 *
 * @author Dhairya Pal N01576099
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Random;

public class Restaurant {
    ArrayList<String> menuItems = new ArrayList<>();
    HashMap<String, Double> prices = new HashMap<>();
    HashMap<String, ArrayList<Double>> itemRatings = new HashMap<>();
    Random random = new Random();
    
    
    //Constructor
    Restaurant(String[] menuItems) {
        //Initializing menuItems
        this.menuItems.addAll(Arrays.asList(menuItems));
        
        for (String item: menuItems) {
            //Intializing prices by generating randomly
            this.prices.put(item, random.nextDouble(10.00, 89.00));
            
            //Initializing ratings by generating randomly
            ArrayList<Double> ratings = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                ratings.add(random.nextDouble(0.1, 9.9)); //Generate 3 randomly generated ratings
            }
            this.itemRatings.put(item, ratings);
        }
    }
    
    //Add menu item
    void addMenuItem(String menuItem) {
        ArrayList<Double> ratings = new ArrayList<>();
        menuItems.add(menuItem);
        prices.put(menuItem, random.nextDouble(10.00, 89.00));
        for (int i = 0; i < 3; i++) {
                ratings.add(random.nextDouble(0.1, 9.9)); //Generate 3 randomly generated ratings
            }
        itemRatings.put(menuItem, ratings);
    }
    
    //Remove menu item
    void removeMenuItem(String menuItem) {
        menuItems.remove(menuItem);
        prices.remove(menuItem);
        itemRatings.remove(menuItem);
    }
    
    //Add ratings
    void addRating(String menuItem, double rating) {
        itemRatings.get(menuItem).add(rating);
    }
    
    //Calculate average rating
    double averageRating(String menuItem) {
        double sum = 0;
        double avgRating;
        int numberOfRatings = 0;
        //int index = menuItems.indexOf(menuItem);
        for (Double itemRating : itemRatings.get(menuItem)) {
            sum += itemRating;
            numberOfRatings++;
        }
        avgRating = sum/numberOfRatings;
        return avgRating;
    }
    
    //Display menu
    void displayMenu() {
        for (String viewItem : menuItems) {
            System.out.printf("%s @ $%.2f, rated %.2f\n", viewItem, prices.get(viewItem), averageRating(viewItem));
        }
    }
}
