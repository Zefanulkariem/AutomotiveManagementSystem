package src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<String, SparePart> parts;
    private ArrayList<Supplier> suppliers;

    public Inventory() {
        this.parts = new HashMap<>();
        this.suppliers = new ArrayList<>();
    }

    public void addPart(SparePart a) {
        this.parts.put(a.getPartId(), a);

        // System.out.println("Successfully Added Part!...");
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
        if(parts.containsKey(partId)) {
            parts.get(partId).setQuantity(quantity);
            
            System.out.println("Part with ID: "+ partId +" was Successfully Updated!...");

            System.out.println(parts.get(partId));
            
        } else {
            System.out.println("Part with ID: "+ partId +" Not Found!...");
        }
    }

    public List<SparePart> searchByName(String partName) {
        ArrayList<SparePart> searchResult = new ArrayList<>();  

        for (SparePart partsLoop : parts.values()) {
            if(partsLoop.getPartName().toLowerCase().contains(partName.toLowerCase())){
                searchResult.add(partsLoop);
            }
        }
        
        if(!searchResult.isEmpty()) {
            System.out.println("Parts with Name \"" + partName + "\" found Successfully!...");

            int number = 1;
            for (SparePart found : searchResult) {
                System.out.println(number + ". " + found.getPartId() + " " + found.getPartName());
                number++;
            }
            
        } else {
            System.out.println("Parts with Name \"" + partName + "\" is not found!...");
        }
        
        return searchResult;
    }

    public List<SparePart> searchByCategory(String category) {
        ArrayList<SparePart> searchResult = new ArrayList<>();  

        for (SparePart partsLoop : parts.values()) {
            if(partsLoop.getCategory().equalsIgnoreCase(category)){
                searchResult.add(partsLoop);
            }
        }
        
        if(!searchResult.isEmpty()) {
            System.out.println("Part with Category \"" + category + "\" found Successfully!...");

            int number = 1;
            for (SparePart found : searchResult) {
                System.out.println(number + ". " + found.getPartId() + " " + found.getPartName());
                number++;
            }
            
        } else {
            System.out.println("Parts with Category \"" + category + "\" is not found!...");
        }
        
        return searchResult;
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

    public void addSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
        
        System.out.println("Successfully Added Supplier!...");
    }

    public ArrayList<Supplier> getAllSuppliers() {
        ArrayList<Supplier> allSuppliers = new ArrayList<>();

        allSuppliers.addAll(suppliers); 

        return allSuppliers;
    }

    public Supplier getSupplierInfo(String supplierId) {
        for (Supplier check : suppliers) {
            if(check.getSupplierId().equalsIgnoreCase(supplierId)){
                return check;
            }
        }
        return null;
    }

    public void removeSupplier(String supplierId) {
        boolean removed = suppliers.removeIf(s -> s.getSupplierId().equalsIgnoreCase(supplierId));
        
        if (removed) {
            System.out.println("Supplier with ID: \"" + supplierId + "\" was Successfully Deleted!...");
        } else {
            System.out.println("Supplier with ID: \"" + supplierId + "\" Not Found!...");
        }
    }
}
