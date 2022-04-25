package ru.geekbrains.march.market.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.dtos.CartDto;
import ru.geekbrains.march.market.utils.Cart;

import java.util.stream.Collectors;

@Component
public class CartConverter {

    public CartDto cartToCartDto (Cart cart) {
        CartDto cartDto = new CartDto();
        CartItemConverter cartItemConverter = new CartItemConverter();
        cartDto.setItems(cart.getItems().stream().map(cartItemConverter::cartItemToCartItemDto).collect(Collectors.toList()));
        cartDto.setTotalQuantity(cart.getTotalQuantity());
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }


}
