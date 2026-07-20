package src.models;

public class Supplier {
    private String supplierId;
    private String supplierName;
    private String contact; //phone atau email
    private String address;
    
    public Supplier(String supplierId, String supplierName, String contact, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contact = contact;
        this.address = address;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "\nSupplier ID: " + supplierId +
                "\nSupplier Name: " + supplierName +
                "\nContact: " + contact +
                "\nAddress: " + address 
        ;
    }
}
