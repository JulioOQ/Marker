package com.jvoq.market.persistence;

import com.jvoq.market.domain.Product;
import com.jvoq.market.domain.repository.ProductRepository;
import com.jvoq.market.persistence.crud.ProductoCrudRepository;
import com.jvoq.market.persistence.entity.Producto;
import com.jvoq.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);

    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
       List<Producto>productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
       return Optional.of(productMapper.toProducts(productos));

    }


    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>>productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));

    }

    @Override
    public Product save(Product product) {
        Producto producto= productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
