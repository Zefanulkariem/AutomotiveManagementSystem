package src.services;

import java.util.ArrayList;

import src.models.Inventory;
import src.models.SparePart;
import src.models.Supplier;

public class InventoryService {
    private Inventory inventory;

    public InventoryService(Inventory inventoryInjection) {
        this.inventory = inventoryInjection;  //inject
    }

    public void addNewPart(SparePart part) {
        
        if (inventory.getAllParts().stream().anyMatch(p -> p.getPartId().equals(part.getPartId()))) {
            System.out.println("Part ID already exists!");
        } else if (part == null || part.getPartId().isBlank() || part.getPartName().isBlank()) {
            System.out.println("Part not Valid!");
        } else {
            System.out.println("Part was Successfully Added!");
            inventory.addPart(part); //delegasi
        }

        //tambah validasi jika data duplicate.
    }

    public void viewAllPart() {
        ArrayList<SparePart> allParts = inventory.getAllParts();

        if (allParts.isEmpty()) {
            System.out.println("Inventory is Empty..");
        } else {
            System.out.println("====== ALL SPARE PARTS ======");

            int number = 1;
            for (SparePart partOut : allParts) {
                System.out.println(number + ". " + partOut.getPartId() + " " + partOut.getPartName() + " (" + partOut.getCategory() + ") - Stock: " + partOut.getQuantity());
                number++;
            }

            System.out.println("================================");
            System.out.println("Total Parts: " + allParts.size());
        }
    }

    public void searchPart(String keyword, String searchType) {
        if (searchType.equalsIgnoreCase("name")) {
            inventory.searchByName(keyword);
        } else if (searchType.equalsIgnoreCase("category")) {
            inventory.searchByCategory(keyword);
        } else {
            System.out.println("Invalid search type! Use 'name' or 'category'");
        }
    }

    public void updatePartStock(String partId, int newQuantity) {
        inventory.updateStock(partId, newQuantity);
    }

    public String generateReport() {
        return null;
    }

    public void calculateTotalValue() {

    }

    public void addSupplier(Supplier supplier) {
        if (supplier == null || supplier.getSupplierName().isBlank()) {
            System.out.println("Supplier not valid!");
        } else {
            inventory.addSupplier(supplier);
            System.out.println("Supplier added successfully!");
        }
    }

    public void viewAllSuppliers() {
        ArrayList<Supplier> allSupliers = inventory.getAllSuppliers();

        if (allSupliers.isEmpty()) {
            System.out.println("Supplier is Empty..");
        } else {
            System.out.println("====== ALL SUPPLIERS ======");

            int number = 1;
            for (Supplier out : allSupliers) {
                System.out.println(number + ". " + out.getSupplierId() + " " + out.getSupplierName() + " " + out.getContact() + " " + out.getAddress());
                number++;
            }

            System.out.println("================================");
            System.out.println("Total Suppliers: " + allSupliers.size());
        }
    }

    public void searchSupplier(String supplierId) {
        ArrayList<Supplier> allSupliers = inventory.getAllSuppliers();

        for (Supplier find : allSupliers) {
            if(find.getSupplierId().equalsIgnoreCase(supplierId)){
                System.out.println("Supplier Found!...");
                System.out.println("Supplier ID: " + find.getSupplierId() + 
                                "\nSupplier Name: " + find.getSupplierName() + 
                                "\nContact: " + find.getContact() + 
                                "\nAddress: " + find.getAddress());
                return;
            }
        }
        System.out.println("Supplier Not Found!...");
        
    }

    public void generateFullReport() {
        ArrayList<SparePart> allParts = inventory.getAllParts();
                
        System.out.println("============== FULL INVENTORY REPORT =================");

        String format = "%-3s | %-7s | %-15s | %-15s | %-8s | %-3s | %-11s\n";
        System.out.printf(format, "NO", "Part ID", "Part Name", "Category", "Price", "Qty", "Stock Value");
        System.out.println("----+---------+-----------------+-----------------+----------+-----+------------");
        
        int number = 1;
        int totalQty = 0;
        int totalInventoryValue = 0;

        for (SparePart getAllPart : allParts) {
            int stockValue = getAllPart.getPrice() * getAllPart.getQuantity();

            System.out.printf(format, 
                number, 
                getAllPart.getPartId(), 
                getAllPart.getPartName(), 
                getAllPart.getCategory(), 
                getAllPart.getPrice(), 
                getAllPart.getQuantity(), 
                String.format("%,d", stockValue) 
            );
            
            totalQty += getAllPart.getQuantity();
            totalInventoryValue += stockValue;

            number++;
        }

        System.out.println("======================================================");
        System.out.println("Summary: "
            + "\nTotal Parts: " + allParts.size() 
            + "\nTotal Quantity: " + totalQty 
            + "\nTotal Inventory Value: " + totalInventoryValue
        );
        System.out.println("======================================================");
    }

    public void generateLowStockReport(int threshold) {
        
    }
}
