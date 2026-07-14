package src.models;

import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Automotive Inventory Management System ===\n");

        // System.out.println("test: data sampel");
        // initializeSampleData();

        // System.out.println("test: isi/data inventory");
        // testInventoryClass();

        // System.out.println("test: Search By Name \"Engine\"");
        System.out.println("test: cari dan memperbarui data");
        testSearchAndUpdateFunctions();
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

    public static void testSearchAndUpdateFunctions() {
        Inventory searchTest = new Inventory();
        
        SparePart part1 = new SparePart("P001", "Engine Oil", "engine", 150000, 50, "PT Supplier A");
        SparePart part2 = new SparePart("P002", "Air Filter", "engine", 80000, 30, "PT Supplier B");
        SparePart part3 = new SparePart("P003", "Brake Pad", "brake", 200000, 20, "PT Supplier C");
        SparePart part4 = new SparePart("P004", "Transmission Fluid", "transmission", 250000, 15, "PT Supplier D");
        SparePart part5 = new SparePart("P005", "Battery", "electrical", 500000, 10, "PT Supplier E");

        searchTest.addPart(part1);
        searchTest.addPart(part2);
        searchTest.addPart(part3);
        searchTest.addPart(part4);
        searchTest.addPart(part5);

        searchTest.searchByName("Engine");

        searchTest.searchByCategory("Engine");

        System.out.println("\"Update QTY = 15 in PartID P001\"");
        searchTest.updateStock("P001", 15);
    }
}
