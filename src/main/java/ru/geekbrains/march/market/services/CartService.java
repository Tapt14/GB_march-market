package ru.geekbrains.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.entities.Product;
import ru.geekbrains.march.market.utils.Cart;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
        cart.setProductsList(new ArrayList<>());
    }

    public Cart getCart() {
        return cart;
    }

    public void addProductToCart(Long productId) {
        Product product = productService.findById(productId).orElseThrow(ClassCastException::new);
        cart.addProductToCart(product);
    }

}
