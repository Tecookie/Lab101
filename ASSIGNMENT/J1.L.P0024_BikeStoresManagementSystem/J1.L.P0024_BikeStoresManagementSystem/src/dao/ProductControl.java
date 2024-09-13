package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import dto.Product;
import dto.ProductList;

public class ProductControl implements IProductControl {
    Scanner sc = new Scanner(System.in);
    public IProductDAO pD = new ProductDAO();
    public ArrayList<Product> productList = new ProductList();
    public File Brand = new File("Information\\Brand.txt");
    public File Category = new File("Information\\Category.txt");
    public ProductControl() throws IOException {
        productList = pD.loadData();
    }
    @Override
    public void createProduct() throws IOException {
        Product product = new Product();
        product.setId();
        System.out.println("Enter Name:");
        product.setName(sc.nextLine());
        while(product.getName().contains(" ") || product.getName().isEmpty()){
            System.out.println("Ensure name is not empty or contain space.\n" + "Enter Name");
            product.setName(sc.nextLine());
        }
        System.out.println("Enter Brand ID");
        product.setBrandID(sc.nextLine());
        BufferedReader readerBrand = new BufferedReader(new FileReader(Brand));
            String line;
            while ((line = readerBrand.readLine()) != null) {
                String[] parts = line.split(",");
                while (parts[0].trim().equals(product.getBrandID())) {
                    System.out.println("Brand ID exist");
                    System.out.println("Enter Brand ID");
                    product.setBrandID(sc.nextLine());
                }
                while (product.getBrandID().isEmpty())
                {
                    product.setBrandID(sc.nextLine());
                }
            }
        System.out.println("Enter Category ID");
        product.setCategoryID(sc.nextLine());
        BufferedReader readerCategory = new BufferedReader(new FileReader(Category));
        String categoryline;
        while ((categoryline = readerCategory.readLine()) != null) {
            String[] parts = categoryline.split(",");
            while (parts[0].trim().equals(product.getCategoryID())) {
                System.out.println("Category ID exist");
                System.out.println("Enter Category ID");
                product.setCategoryID(sc.nextLine());
            }
            while (product.getCategoryID().isEmpty())
            {
                product.setCategoryID(sc.nextLine());
            }
        }
        product.setModelYear(2025);
        for(boolean test = false; test == false;){
            try {
                System.out.println("Enter Model Year");
                product.setModelYear(sc.nextInt());
                while (product.getModelYear() > 2024) {
                    System.out.println("Enter Model Year");
                    product.setModelYear(sc.nextInt());
                }
                test = true;
            }catch(InputMismatchException e){
                    System.out.println("Invalid input");
                }sc.nextLine();}
        product.setListPrice(-1);
        for(boolean test = false; test == false;){
            try{
                System.out.println("Enter List Price");
                product.setListPrice(sc.nextInt());
        while(product.getListPrice() < 0){
            System.out.println("Enter a positive number");
            System.out.println("Enter List Price");
            product.setListPrice(sc.nextInt());
        }
                test = true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
            }sc.nextLine();
        }
        productList.add(product);
    }
    @Override
    public void updateProduct()throws IOException  {
        System.out.println("Enter ID");
        String id = sc.nextLine();
        if (findByID(id) == null) System.out.println("Product does not exist");
        else {
            System.out.println(findByID(id));
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            while (!name.isEmpty()) {
                while (findByID(id).getName().contains(" ")) {
                    System.out.println(" Ensure name doesn't contain space.\n" + "Enter Name");
                    name = sc.nextLine();
                }
                if(!name.isEmpty())
                {findByID(id).setName(name);
                break;
                }
            }


            System.out.println("Enter Brand ID");
            String brandID = sc.nextLine();
            while (!brandID.isEmpty()) {
                BufferedReader readerBrand = new BufferedReader(new FileReader(Brand));
                String line;
                while ((line = readerBrand.readLine()) != null) {
                    String[] parts = line.split(",");
                    while (parts[0].trim().equals(brandID)) {
                        System.out.println("Brand ID exist");
                        System.out.println("Enter Brand ID");
                        brandID = sc.nextLine();
                    }
                }
                if(!brandID.isEmpty()) {
                    findByID(id).setBrandID(brandID);
                    break;
                }
            }


            System.out.println("Enter Category ID");
            String cateID = sc.nextLine();
            while (!cateID.isEmpty()) {
            BufferedReader readerCategory = new BufferedReader(new FileReader(Category));
            String categoryline;
                while ((categoryline = readerCategory.readLine()) != null) {
                    String[] parts = categoryline.split(",");
                        while (parts[0].trim().equals(cateID)) {
                            System.out.println("Category ID exist");
                            System.out.println("Enter Category ID");
                            cateID = sc.nextLine();
                        }

                    }
                if(!cateID.isEmpty()) {
                    findByID(id).setCategoryID(cateID);
                    break;
                }
            }


            for (boolean test = false; test == false; ) {
                try {
                    System.out.println("Enter Model Year");
                    String modelY = sc.nextLine();
                    while (!modelY.isEmpty()) {
                        while (Integer.parseInt(modelY) > 2024) {
                            System.out.println("Enter Model Year");
                            modelY = sc.nextLine();
                        }
                        if(!modelY.isEmpty()){
                            findByID(id).setModelYear(Integer.parseInt(modelY));
                            break;
                        }

                    }
                    test = true;
                }catch(NumberFormatException e) {
                    System.out.println("Invalid input");
                }
                }

            for (boolean test = false; test == false; ) {
                try {
                    System.out.println("Enter List Price");
                    String price = sc.nextLine();
                    while (!price.isEmpty()) {
                        while (Integer.parseInt(price) < 0) {
                            System.out.println("Enter a positive number");
                            System.out.println("Enter List Price");
                            price = sc.nextLine();
                        }
                        if(!price.isEmpty()){
                            findByID(id).setListPrice(Integer.parseInt(price));
                            break;
                        }

                    }
                    test = true;
                }catch(NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
            System.out.println(findByID(id));
        }
    }
    @Override
    public Product findByID(String id){
        for(Product product : this.productList)
        {
            if(product.getId().equals(id))
            {
                return product;
            }
        }
        System.out.println("ID not found");
        return null;
    }

    public static Comparator compareByYear = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product e1 = (Product) o1;
            Product e2 = (Product) o2;
            int d = Integer.compare(e1.getModelYear(), e2.getModelYear());
            if(d>0) return -1;
            if (d==0) return 0;
            return 1;
        }
    };
    public static Comparator compareByPrice = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product e1 = (Product) o1;
            Product e2 = (Product) o2;
            int d = Integer.compare(e1.getListPrice(), e2.getListPrice());
            int f = e1.getName().compareTo(e2.getName());
            if(d>0) return -1;
            if (d==0) {
                return Integer.compare(0, -f);
            }
            return 1;
        }
    };
    @Override
    public void searchByName(){
        Boolean found = false;
        System.out.println("Enter Product name");
        String name = sc.nextLine();
        ArrayList<Product> sorter = new ArrayList<>();
        for(Product p : this.productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                sorter.add(p);
                found = true;
            }
        }
            Collections.sort(sorter, compareByYear);
            for(Product s : sorter){
                System.out.println(s);
            }


        if(found == false) {
            System.out.println("Have no any Product");
        }
    }
    public void deleteEvent(){
        System.out.println("Enter ID to delete");
        String id = sc.nextLine();
        if(findByID(id) != null) {
            System.out.println(findByID(id));
            System.out.print("Confirm delete (y/n) :");
            String confirm = sc.nextLine();
            if(Objects.equals(confirm, "y")) {
                productList.remove(findByID(id));
                System.out.println("Delete ID successfully");
            }
            else if(Objects.equals(confirm, "n")) {
                System.out.println("Stop delete");
            }

        }
    }
    @Override
    public void saveToFile() throws IOException {
        ProductDAO pDao = new ProductDAO();
        pDao.saveFile(productList);
    }
    @Override
    public void updateToFile() throws IOException {
        ProductDAO pDao = new ProductDAO();
        pDao.updateFile(productList);
    }
    @Override
    public void returnList(){
        ArrayList<Product> sorter = new ArrayList<>(this.productList);
        sorter.sort(compareByPrice);

        for (Product pdList : sorter) {
            System.out.println(pdList);
        }
    }

}
