//Skapa en ny klass i mappen src/ och kalla den klassen för MyShop

import com.sun.source.util.SourcePositions;

import java.util.ArrayList;
import java.util.Scanner;

public class MyShop {
    static ArrayList<Product> productList = new ArrayList<Product>();
    static ArrayList<String> shopingCart = new ArrayList<String>();



    public static void start(){
//        shopingCart.add("any product");
//        shopingCart.add("any product 2");
//        shopingCart.add("and product 3");

        //En meny där användaren får lista alla saker som finns i affären - det som ska skrivas ut är namnet på saken och vad den kostar
        //Create objects of Product and add the value of the different variables/attributes in the Product class
        Product product1 = new Product("Programming robot" , 7999, "A robot that read your mind and write the code for you!");
        Product product2 = new Product("Time machine" , 5099, "A machine that allows you to travel through time!");
        Product product3 = new Product("Season changer" , 9999, "A device that let you change between seasons!");
        Product product4 = new Product("Life-long battery" , 2999, "A battery that never need to be charged!!");
      //to add the product Name,price.description to the productList type arrayList<Product>
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        boolean programmRunning = true;
        while (programmRunning){

            //Run printMenu method to show the productList and the options for the customer
            printMenu();

            //integer to get the user input on which option he has selected , 1 = add , 2 = remove ....
            int menu = getUserInt();

            switch (menu) {
                case 1 -> addProduct();//Användaren ska kunna lägga saker i sin kundkorg
                case 2 -> removeProduct();// Användaren ska kunna ta bort saker från kundkorgen
                case 3 -> currentCostOfCart();// Användaren ska kunna fråga hur mycket alla saker i kundkorgen kostar
                case 4 -> productDescription();//Användaren ska kunna fråga butiksägaren om beskrivning av en specifik produkt
                case 5 -> programmRunning = false;
                default -> System.out.println("wrong choice!" +"\n" + "> ");

            }

        }
    }


    private static void addProduct() {
        //Create string and get the user entry using the getUserString (which take one argument "question"
        String productToAdd = getUserString("What product do you want to add to the cart ?");

        /*this int need to be here so it can be used outside the for loop, however the "if statement" after the for loop
        will take the last value of "i" */
        int i = 0;
        for ( i = 0 ; i < productList.size(); i++) {
            //compare the name of productToAdd against the each of the product names in the productList, if equal, add the product to the shopping cart
            if (productToAdd.equals(productList.get(i).productName)){
                shopingCart.add(productToAdd);//we use add to add the product anywhere in the shopping cart list, first added to place 0 in the list
                //if you don't use break, the i will continue to increase then the next "if statement" will be always printed i = 3 will be equal to the size of the array
                break;
            }
        }
        //if the product is not in the list of product in the shop, for example if the "i" reach 3 (which is the size of the productList array)
        // and didn't find the name that the user entered, means that the name is not on the product list
        if(i == productList.size()){
            System.out.println("The product you want to add ( " + productToAdd + " ) is not in our shop" +"\n");
        }
        //if the shoping cart is not empty , print the product/s in it.
        if(shopingCart.size() != 0){
            System.out.println("Current product/s in the shoping cart: " + shopingCart +"\n");
        }
    }
    private static void removeProduct() {
        String productToRemove = getUserString("What product do you want to remove from the cart ?");
        int i = 0;
        // search for the productToRemove int shopping cart , if you find it remove it
        for ( i = 0 ; i < shopingCart.size(); i++) {
            if (productToRemove.equals(shopingCart.get(i))){
                shopingCart.remove(productToRemove);
                System.out.println("You successfully removed: " + productToRemove);
                break;
            }
        }
//        //if the product to remove is not in the list of product in the shopping cart , print
//        if(i == shopingCart.size()){
//            System.out.println("The product you want to remove ( " + productToRemove + " ) is not in your cart" +"\n");
//        }

        // if there is something in the cart, the size of the list will not be 0, print the list
        // if there is nothing then the size of the list will be 0, print the shopping cart is empty
        if(shopingCart.size() != 0) {
            System.out.println("Current product/s in the shopping cart: " + shopingCart +"\n");
        } else {
            System.out.println( "Your shopping cart is currently empty!" + "\n");
        }

    }

    private static void currentCostOfCart() {
        double totalCartCost = 0;
        for ( int i = 0 ; i < shopingCart.size(); i++) {
            for (int j = 0; j <productList.size();j++)
            {
                if (shopingCart.get(i).equals(productList.get(j).productName)){
//                    System.out.println("product in cart " + shopingCart.get(i) + "product " + productList.get(j).productName + " it cost " + productList.get(j).productPrice );
                    totalCartCost += productList.get(j).productPrice;
                    break;

                }
            }

        }
        System.out.println("Cost of products in the shoping cart: " + totalCartCost);

        // if there is something in the cart, the size of the list will not be 0, print the list
        // if there is nothing then the size of the list will be 0, print the shopping cart is empty
        if(shopingCart.size() != 0) {
            System.out.println("Current product/s in the shoping cart: " + shopingCart +"\n");
        } else {
            System.out.println( "Your shopping cart is currently empty!" + "\n");
        }
    }
    private static void productDescription() {
        String productDescription = getUserString("Write the product's name to see the product's description");
        int i = 0;
        for (i = 0; i < productList.size(); i++) {
            if (productDescription.equals(productList.get(i).productName)) {
                System.out.println(productDescription + " : " + productList.get(i).productDescription + "\n");
                break;
            }
        }
        /*if the user entered product that is not exist in the productList , "i" will loop until it reaches the maximum size of
        the productList which in our example is 3 , so if 3 = 3 , then it will print "the product not exist..", and will show the product
        tha we have in the shop
         */
        if (i == productList.size()) {
            System.out.println("The product you entered do not exist ");
            System.out.println("The available product in the shop are: " + productList +"\n");

        }
    }



    public static void printMenu(){
        //Print the list of products and prices using toString() method from Product class
        System.out.println("Product List >>>>>>>>>>>>>>>>>> ");
        System.out.println(productList);
//        System.out.println(shopingCart);
//        System.out.println(productList.get(0).getProductName());
//        System.out.println(productList.get(0).productPrice);
//        System.out.println(productList.get(0).productDescription);
//        System.out.println(productList.get(1).productName);
//        System.out.println(productList.get(1).productPrice);
//        System.out.println(productList.get(1).productDescription);

        //En meny där användaren får skapa en lista över sina favoritstader
        System.out.println(" 1. Add Product Shopping Cart");//Användaren ska kunna lägga saker i sin kundkorg
        System.out.println(" 2. Remove a product from the shopping cart");  // Användaren ska kunna ta bort saker från kundkorgen
        System.out.println(" 3. Know the total cost of products in the shopping cart? "); // Användaren ska kunna fråga hur mycket alla saker i kundkorgen kostar
        System.out.println(" 4. Know the description of a product");//Användaren ska kunna fråga butiksägaren om beskrivning av en specifik produkt
        System.out.println(" 5. Leave the shop.");

    }


    private static int getUserInt() {
        System.out.print("> ");
        Scanner myScanner = new Scanner(System.in);
        int myInteger;
        while (true) {
            try {
                myInteger = Integer.parseInt(myScanner.nextLine());
                break;
            } catch (Exception e) {
                //System.out.println("Exception: " + e);
                System.out.println("Felaktig indata, try again!" +"\n" + "> ");
            }
        }


        return myInteger;


    }

    private static String getUserString(String question) {

        System.out.println(question);

        Scanner myScanner = new Scanner(System.in);
        String myString;
        myString = myScanner.nextLine();

        return myString;
    }

}
