package src.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.services.InventoryService;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Automotive Inventory Management System ===\n");

        // System.out.println("test: data sampel");
        // initializeSampleData();

        // System.out.println("test: isi/data inventory");
        // testInventoryClass();

        // System.out.println("test: Search By Name \"Engine\"");
        System.out.println("test: cari dan memperbarui data");
        testInventoryService();
        
    }

    public static void initializeSampleData() {
        SparePart part1 = new SparePart("P001", "Engine Oil", "engine", 150000, 100, "Hasan Kasiem");
        SparePart part2 = new SparePart("P002", "Air Filter", "engine", 80000, 80, "Soesanto Tirtodidjojo");
        SparePart part3 = new SparePart("P003", "Break Pad", "break", 200000, 50, "Harie Budiman");

        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);
    }
    
    public static void testInventoryClass() {
        // Scanner in = new Scanner(System.in);
        Inventory test = new Inventory();
        
        SparePart part1 = new SparePart("P001", "Engine Oil", "engine", 150000, 50, "PT Supplier A");
        SparePart part2 = new SparePart("P002", "Air Filter", "engine", 80000, 30, "PT Supplier B");
        SparePart part3 = new SparePart("P003", "Brake Pad", "brake", 200000, 20, "PT Supplier C");
        SparePart part4 = new SparePart("P004", "Transmission Fluid", "transmission", 250000, 15, "PT Supplier D");
        SparePart part5 = new SparePart("P005", "Battery", "electrical", 500000, 10, "PT Supplier E");

        test.addPart(part1);
        test.addPart(part2);
        test.addPart(part3);
        test.addPart(part4);
        test.addPart(part5);
        
        ArrayList<SparePart> allParts = test.getAllParts();

        System.out.println("==================================");
        for (SparePart out : allParts) {
            System.out.println(out);
            System.out.println("==================================");
        }
        System.out.println("Total Parts: " + allParts.size() + " Parts");

        // System.out.println("Do want delete some parts?");
        // String deletePart = in.nextLine();
        // if(deletePart.equalsIgnoreCase("yes") || deletePart.equalsIgnoreCase("y")) {
        //     System.out.println("Pls input the Part ID:");
        //     String partInput = in.nextLine();
        //     if(partInput.isEmpty() || partInput.con) {
        //         System.out.println("Part ID is Not Found!");
        //     } else {
        //         test.removePart(partInput);
        //     }
        // }
        System.out.println("Test Delete part with ID P001.");
        test.removePart("P001");

        ArrayList<SparePart> remaining = test.getAllParts();

        System.out.println("==================================");
        for (SparePart out : remaining) {
            System.out.println(out);
            System.out.println("==================================");
        }
        System.out.println("Total Parts: " + remaining.size() + " Parts");
    }

    public static void testInventoryService() {
        Scanner in = new Scanner(System.in);
        Inventory inventory = new Inventory();
        InventoryService service = new InventoryService(inventory);
        
        SparePart part1 = new SparePart("P001", "Engine Oil", "engine", 150000, 50, "PT Supplier A");
        SparePart part2 = new SparePart("P002", "Air Filter", "engine", 80000, 30, "PT Supplier B");
        SparePart part3 = new SparePart("P003", "Brake Pad", "brake", 200000, 20, "PT Supplier C");
        SparePart part4 = new SparePart("P004", "Transmission Fluid", "transmission", 250000, 15, "PT Supplier D");
        SparePart part5 = new SparePart("P005", "Battery", "electrical", 500000, 10, "PT Supplier E");

        inventory.addPart(part1);
        inventory.addPart(part2);
        inventory.addPart(part3);
        inventory.addPart(part4);
        inventory.addPart(part5);


        System.out.println("\n=== Testing Supplier Management ===");

        // Add suppliers
        Supplier supplier1 = new Supplier("S001", "PT Supplier A", "021-1234567", "Jakarta");
        Supplier supplier2 = new Supplier("S002", "PT Supplier B", "031-7654321", "Surabaya");
        Supplier supplier3 = new Supplier("S003", "PT Supplier C", "0274-555666", "Yogyakarta");

        service.addSupplier(supplier1);
        service.addSupplier(supplier2);
        service.addSupplier(supplier3);

        // System.out.println("tes remove");
        // inventory.removeSupplier("S001");

        // test.searchByName("Engine");

        // test.searchByCategory("Engine");

        // System.out.println("\"Update QTY = 15 in PartID P001\"");
        // test.updateStock("P001", 15);

        System.out.println("--- Full Report ---");
        service.generateFullReport();
        
        System.out.println("\n--- Low Stock Report (threshold 20) ---");
        service.generateLowStockReport(50);

        System.out.println("\n--- Low Stock Report (threshold 50) ---");
        service.generateCategoryReport();

        while (true) {
            System.out.println("\n=== AUTOMOTIVE INVENTORY SYSTEM ===");
            System.out.println("1. Add Part");
            System.out.println("2. View All Parts");
            System.out.println("3. Search Part");
            System.out.println("4. Update Part Stock");
            System.out.println("5. Remove Part");
            System.out.println("6. View All Suppliers");
            System.out.println("7. Search Suppliers");
            System.out.println("8. Remove Supplier");
            System.out.println("9. Exit");
            System.out.print("Choose option (1-7): ");
            
            String choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--- Add Part ---");
                    System.out.print("Input Part ID: ");
                    String id = in.nextLine();

                    System.out.print("Input Part Name: ");
                    String name = in.nextLine();

                    System.out.print("Input Category: ");
                    String category = in.nextLine();

                    System.out.print("Input price: ");
                    int price = 0;
                    while (true) {
                        try {
                            price = in.nextInt();
                            in.nextLine(); 

                            if (price > 0) {
                                break;
                            } else {
                                System.out.println("Price must be greater than 0!");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            in.nextLine(); 
                        }
                    }

                    System.out.print("Input Quantity: ");
                    int qty = 0;
                    while (true) {
                        try {
                            qty = in.nextInt();
                            in.nextLine(); 

                            if (qty > 0) {
                                break;
                            } else {
                                System.out.println("Quantity must be greater than 0!");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            in.nextLine(); 
                        }
                    }

                    System.out.print("Input Supplier Name: ");
                    String supplier = in.nextLine();
                    
                    SparePart newPart = new SparePart(id, name, category, price, qty, supplier);
                    service.addNewPart(newPart);
                    break;

                case "2":
                    System.out.println("\n--- View All Parts ---");
                    service.viewAllPart();
                    break;

                case "3":
                    System.out.println("\n--- Search Part ---");
                    System.out.println("Enter search type ('name' or 'category'):");
                    String typeInput = in.nextLine(); 

                    System.out.print("Enter keyword to search: ");
                    String keyInput = in.nextLine();

                    service.searchPart(keyInput, typeInput);
                    break;

                case "4":
                    System.out.println("\n--- Update Part Stock ---");
                    System.out.print("Input Part ID to update: ");
                    String updateId = in.nextLine();
                    try {
                        System.out.print("Input New Stock Amount: ");
                        int newStock = in.nextInt();
                        in.nextLine();
                        
                        service.updatePartStock(updateId, newStock);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid stock amount!");
                        in.nextLine();
                    }
                    break;

                case "5":
                    System.out.println("\n---Remove Parts ---");
                    System.out.print("Input Part ID: ");
                    String partRemove = in.nextLine();
                    inventory.removePart(partRemove);
                    break;

                case "6":
                    System.out.println("\n--- View All Suppliers ---");
                    service.viewAllSuppliers();
                    break;

                case "7":
                    System.out.println("\n--- Search Supplier ---");
                    System.out.println("Enter search type Supplier ID:");
                    String inSup = in.nextLine(); 

                    service.searchSupplier(inSup);
                    break;

                case "8":
                    System.out.println("\n---Remove Supplier ---");
                    System.out.print("Input Supplier ID: ");
                    String supplierRemove = in.nextLine();
                    inventory.removeSupplier(supplierRemove);
                    break;

                case "9":
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
                    break;
            }
        }
    }

    
}
