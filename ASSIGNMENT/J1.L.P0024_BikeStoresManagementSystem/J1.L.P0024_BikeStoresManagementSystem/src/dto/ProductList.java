package dto;

import java.util.ArrayList;

public class ProductList extends ArrayList<Product> {

    public void addEvent(Product product)
    {
        this.add(product);
    }

}
