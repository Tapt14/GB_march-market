package ru.geekbrains.march.market.utils;

import lombok.Data;
import ru.geekbrains.march.market.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {

    private List<CartItem> items;
    private BigDecimal totalPrice;
    private int totalQuantity;

    public void add(Product p) {
        for (CartItem item : items) {
            if (item.getProductId().equals(p.getId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();
    }

    public void clear() {
        items.clear();
        totalPrice = BigDecimal.ZERO;
        totalQuantity = 0;
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        totalQuantity = 0;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
        items.forEach(i -> totalQuantity += i.getQuantity());
    }

}
