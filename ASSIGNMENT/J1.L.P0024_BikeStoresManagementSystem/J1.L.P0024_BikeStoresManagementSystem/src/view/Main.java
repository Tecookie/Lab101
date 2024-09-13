package view;

import dao.IProductControl;
import dao.ProductControl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        IProductControl pc = new ProductControl();
        int a;
        do {
            System.out.println("1. Add a product.\n" +
                    "2. Search product by product name, return a list of all products that same name.\n" +
                    "3. Update product.\n" +
                    "4. Delete product.\n" +
                    "5. Save products to file.\n" +
                    "6. Print list products from the file.\n" +
                    "Others - Quit.");
            a = sc.nextInt();
            int b = 1;
            switch (a) {
                case 1:
                    do{
                        pc.createProduct();
                        do{
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b ==1 || b== 2));
                    } while (b != 2);
                    b = 1;
                    break;
                case 2:
                    do{
                        pc.searchByName();
                        do{
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b ==1 || b== 2));
                    } while (b != 2);
                    b = 1;
                    break;
                case 3:
                    do{
                        pc.updateProduct();
                        pc.updateToFile();
                        do{
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b ==1 || b== 2));
                    } while (b != 2);
                    b = 1;
                    break;
                case 4:
                    do {
                        pc.deleteEvent();
                        pc.updateToFile();
                        do {
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b == 1 || b == 2));
                    }while (b != 2);
                        b = 1;
                    break;
                case 5:
                    do{
                        pc.saveToFile();
                            do{
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b ==1 || b== 2));
                    } while (b != 2);
                    b = 1;
                    break;

                case 6:
                    do{
                    pc.returnList();
                        do{
                            System.out.println("(1)Continue or (2)Return to Menu:");
                            b = sc.nextInt();
                        }
                        while (!(b ==1 || b== 2));
                    } while (b != 2);
                    b = 1;
                    break;
           }
} while(a != 7);
  }
}