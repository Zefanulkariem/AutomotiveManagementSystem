package src.services;

import java.util.ArrayList;

import src.models.Inventory;
import src.models.SparePart;
import src.models.Supplier;

public class InventoryService {
    private Inventory inventory;
    private ArrayList<Supplier> suppliers;

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
}
