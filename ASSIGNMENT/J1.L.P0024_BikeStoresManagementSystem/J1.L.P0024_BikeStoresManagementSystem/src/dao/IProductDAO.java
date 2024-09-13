package dao;

import dto.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface IProductDAO {
    void saveFile(ArrayList<Product> products) throws IOException;
    void updateFile(ArrayList<Product> products) throws IOException;
    ArrayList<Product> loadData () throws IOException;
}
