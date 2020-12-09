package com.jvoq.market.persistence.mapper;

import com.jvoq.market.domain.PurchaseItem;
import com.jvoq.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    //cuando el source es igual al target, simplemente no se pone
    //@Mapping(source ="total" ,target = "total"),
    @Mappings({
            @Mapping(source ="id.idProducto" ,target = "productId"),
            @Mapping(source ="cantidad" ,target = "quantity"),
            @Mapping(source ="estado" ,target = "active")


    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);


    //esta anotacion es para que utilice lo inverso del mappings de arriba
    @InheritInverseConfiguration
    //ignoramos variables que no usamos
    @Mappings({
            @Mapping(target = "compra" ,ignore = true),
            @Mapping(target = "producto" ,ignore = true),
            @Mapping(target = "id.idCompra" ,ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);

}
