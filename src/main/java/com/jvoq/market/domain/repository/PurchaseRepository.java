package com.jvoq.market.domain.repository;

import com.jvoq.market.domain.Purchase;
import com.jvoq.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    //aca implemetamos optional porque derrepente no existe ese cliente a consultar
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
