/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.models;

/**
 *
 * @author Rafly Aditya Ray
 */
public class SparePart {
    private String partId;
    private String partName;
    private String category;
    private int price;
    private int quantity;
    private String supplier;

    public SparePart(String partId, String partName, String category, int price, int quantity, String supplier) {
        this.partId = partId;
        this.partName = partName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.supplier = supplier;
    }

    public String getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public String toString(){
        return "Part ID: " + partId + "\nPart Name: " + partName 
        + "\nCategory: " + category + "\nPrice: " + price 
        + "\nQty: " + quantity + "\nSupplier Name: " + supplier;
    }


}
