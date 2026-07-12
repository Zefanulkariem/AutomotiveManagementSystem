package src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<String, SparePart> parts;

    public Inventory() {
        this.parts = new HashMap<>();
    }

    public void addPart(SparePart a) {
        this.parts.put(a.getPartId(), a);

        System.out.println("Successfully Added Part!...");
    }

    public void removePart(String partId) {
        if(parts.containsKey(partId)){
            parts.remove(partId);

            System.out.println("Part with ID: "+ partId +" was Successfully Deleted!...");
        } else {
            System.out.println("Part with ID: "+ partId +" Not Found!...");
        }
    }

    public void updateStock(String partId, int quantity) {
        
    }

    public List<SparePart> searchByName(String partId) {
        return null;
    }

    public List<SparePart> searchByCategory(String partId) {
        return null;
    }

    public ArrayList<SparePart> getAllParts() {
        // return new ArrayList<>(parts.values());
        ArrayList<SparePart> allPart = new ArrayList<>();

        allPart.addAll(parts.values());

        return allPart;
    }

    public double getTotalInventoryValue() {
        double total = 0; 
        return total;
    }

    public List<SparePart> getLowStockItems(int threshold) {
        return null;
    }
}
