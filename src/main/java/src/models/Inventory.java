/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Rafly Aditya Ray
 */
public class Inventory {
    private HashMap<String, SparePart> parts;

    public void addPart(SparePart a) {
        System.out.println("");
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
        return null;
    }

    public double getTotalInventoryValue() {
        double total = 0; 
        return total;
    }

    public List<SparePart> getLowStockItems(int threshold) {
        return null;
    }
}
