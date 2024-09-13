package dao;
import dto.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductDAO implements IProductDAO{
    String filePath = "Product.txt";
    File file = new File("Information\\Product.txt");
    @Override
    public void saveFile(ArrayList<Product> products) throws IOException {
        if (products.size() == loadData().size()) {
            System.out.println("There's nothing to save");
        } else {
            try {

                BufferedReader in = new BufferedReader(new FileReader(file));
                PrintWriter out = new PrintWriter(file);
                for (Product pl : products) {
                    out.write(pl.toString() + "\n");
                }
                out.close();
            } catch (IOException e) {
                file.createNewFile();
            }
        }
    }
    @Override
    public void updateFile(ArrayList<Product> products) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            PrintWriter out = new PrintWriter(file);
            for (Product pl : products) {
                out.write(pl.toString() + "\n");
            }
            out.close();
        } catch (IOException e) {
            file.createNewFile();
        }
    }
    @Override
    public ArrayList<Product> loadData () throws IOException {
            ArrayList<Product> list = new ArrayList<>();
            Product product = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(parts.length == 6 ) {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        String brandID = parts[2].trim();
                        String categoryID = parts[3].trim();
                        int modelYear = Integer.parseInt(parts[4].trim());
                        int listPrice = Integer.parseInt(parts[5].trim());
                        Product product1 = new Product(id, name, brandID, categoryID, modelYear, listPrice);
                        list.add(product1);
                    }
                }
            } catch (IOException e) {
                file.createNewFile();
            }
            return list;
        }
    }

