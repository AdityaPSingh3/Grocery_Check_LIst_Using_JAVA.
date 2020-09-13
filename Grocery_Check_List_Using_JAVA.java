import java.util.Scanner;
import java.util.ArrayList;

public class Main {
private static Scanner scanner = new Scanner(System.in);
private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0 ;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5 :
                    searchForItem();
                    break;
                case 6 :
                    quit = true ;
                    break;

            }
        }

    }
    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t0 - To print choice options.");
        System.out.println("\t1 - To print the list of grocery item.");
        System.out.println("\t2 - To add an item to a grocery list.");
        System.out.println("\t3 - To modify an item in the list.");
        System.out.println("\t4 - To remove an item from grocery list.");
        System.out.println("\t5 - To search an item in the grocery list.");
        System.out.println("\t6 - To quit the application.");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery item :");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Enter item numner :");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter replacement item :");
        String newitem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo -1 , newitem);
    }

    public static void removeItem(){
        System.out.print("Enter item number : ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo-1);
    }

    public static void searchForItem(){
        System.out.print("Item to search fot : ");
        String searchItem = scanner.nextLine();
        if(groceryList.findItem(searchItem) != null){
            System.out.println("Found " + searchItem + " in a grocery list.");
        }else{
            System.out.println(searchItem + " mot in the shopping list.");
        }
    }


}



public class GroceryList {

    private  ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0 ; i < groceryList.size() ; i++){
            System.out.println((i+1) + ". " + groceryList.get(1));
        }
    }

    public void modifyGroceryItem(int position , String newItem){
        groceryList.set(position , newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified");
    }

    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findItem(String searchedItem){
        boolean exists = groceryList.contains(searchedItem);
        int position = groceryList.indexOf(searchedItem);
        if(position >= 0){
            return groceryList.get(position);
        }
        return null;
    }
}
