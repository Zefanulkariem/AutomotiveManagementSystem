/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.models;

/**
 *
 * @author Rafly Aditya Ray
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Automotive Inventory Management System ===\n");

        initializeSampleData();
    }

    public static void initializeSampleData() {
        SparePart part1 = new SparePart("P001", "Engine Oil", "engine", 150000, 100, "Hasan Kasiem");
        SparePart part2 = new SparePart("P002", "Air Filter", "engine", 80000, 80, "Soesanto Tirtodidjojo");
        SparePart part3 = new SparePart("P003", "Break Pad", "break", 200000, 50, "Harie Budiman");

        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);
    }
    
}
