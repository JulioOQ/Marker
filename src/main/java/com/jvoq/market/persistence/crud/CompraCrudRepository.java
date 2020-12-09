package com.jvoq.market.persistence.crud;

import com.jvoq.market.domain.Purchase;
import com.jvoq.market.persistence.entity.Compra;
import com.jvoq.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository  extends CrudRepository<Compra,Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
