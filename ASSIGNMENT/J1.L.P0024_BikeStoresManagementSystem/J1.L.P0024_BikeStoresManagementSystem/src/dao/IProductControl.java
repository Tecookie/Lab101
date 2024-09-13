package dao;

import dto.Product;

import java.io.IOException;

public interface IProductControl {
    void createProduct() throws IOException ;
    void updateProduct() throws IOException ;
    Product findByID(String id);
    void searchByName();
    void deleteEvent();
    void saveToFile() throws IOException;
    void updateToFile() throws IOException ;
    void returnList();
}

