package com.example.kmart.products;

public class Product {
    private final String barcode;
    private final String name;
    private final String description;
    private final String measuringUnit;
    private final int quantityAvailable;
    private final double supplierPrice;
    private final double sellPrice;

    public Product(String barcode, String name, String description, String measuringUnit, double supplierPrice, double sellPrice, int quantityAvailable) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.measuringUnit = measuringUnit;
        this.supplierPrice = supplierPrice;
        this.sellPrice = sellPrice;
        this.quantityAvailable = quantityAvailable;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}
