package com.jvoq.market.persistence.mapper;
import com.jvoq.market.domain.Purchase;
import com.jvoq.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//con esto le decimos que es un componente de spring, y lo podemos injectar
//@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    //siempre la clase destino debe de tener todos los mapeos, y la clase base ignorar algunos atributos
    @Mappings({
            @Mapping(source ="idCompra" ,target = "purchaseId"),
            @Mapping(source ="idCliente" ,target = "clientId"),
            @Mapping(source ="fecha" ,target = "date"),
            @Mapping(source ="medioPago" ,target = "pymentMethod"),
            @Mapping(source ="comentario" ,target = "comment"),
            @Mapping(source ="estado" ,target = "state"),
            @Mapping(source ="comprasProductoList" ,target = "purchaseItemList")

    })
    Purchase toPurchase(Compra compras);
    List<Purchase> toPurchases(List<Compra>compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente",ignore = true)
    })
    Compra toCompra(Purchase purchase);

}
