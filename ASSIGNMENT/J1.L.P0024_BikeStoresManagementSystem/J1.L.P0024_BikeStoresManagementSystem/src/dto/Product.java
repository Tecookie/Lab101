package dto;

import java.util.UUID;

public class Product {
    private String id;
    private String name,BrandID,CategoryID;
    private int ModelYear;
    private int ListPrice;

    public Product(String id, String name, String brandID, String categoryID, int modelYear, int listPrice) {
        this.id = id;
        this.name = name;
        BrandID = brandID;
        CategoryID = categoryID;
        ModelYear = modelYear;
        ListPrice = listPrice;
    }
    public Product(){
    }

    public String getId() {
        return id;
    }

    public void setId() {
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public int getModelYear() {
        return ModelYear;
    }

    public void setModelYear(int modelYear) {
        ModelYear = modelYear;
    }

    public int getListPrice() {
        return ListPrice;
    }

    public void setListPrice(int listPrice) {
        ListPrice = listPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d, %d", getId(), getName(), getBrandID(), getCategoryID(), getModelYear(), getListPrice());
    }
}
