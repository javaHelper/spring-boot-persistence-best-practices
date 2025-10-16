package com.bookstore.service;

import com.bookstore.dto.ShoppingCartDto;
import com.bookstore.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Transactional(readOnly = true)
    public List<ShoppingCartDto> allShoppingCart() {
        return shoppingCartRepository.fetchShoppingCart();
    }

    @Transactional(readOnly = true)
    public List<ShoppingCartDto> byPriceShoppingCart() {
        return shoppingCartRepository.fetchShoppingCartByPrice(40);
    }
}
