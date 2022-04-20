package ru.geekbrains.march.market.utils;

import lombok.Data;
import ru.geekbrains.march.market.entities.Product;
import java.util.List;

@Data
public class Cart {

    private List<Product> productsList;

    public void addProductToCart(Product p) {
        productsList.add(p);
    }

}
