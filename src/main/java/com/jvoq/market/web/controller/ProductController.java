package com.jvoq.market.web.controller;

import com.jvoq.market.domain.Product;
import com.jvoq.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //esto es una anotacion de swagger
    @ApiOperation("Get all supermarket products")
    //Otra anotacion de swager para la respuesta Ok
    @ApiResponse(code= 200,message = "OK")
    @GetMapping("/all")
    //agregadmos responseentity para controlar las peticiones, cambiando los tipos de
    // datos de cada metodo por ResponseEntity<acaponemos la lista>
    public ResponseEntity<List<Product>> getAll(){
        //en el primero parametro mandamos el cuerpo, el segundo parametro la respuesta OK
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    //es una descripcion en swagger
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code= 200, message ="OK"),
            @ApiResponse(code= 404, message ="Product not found")


    })
    @GetMapping("/{id}")
    //agregamos el responseEntity pero quitamos el optional
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "11") @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("category/{categoryId}")
    //agregamos el responseEntity pero quitamos el optional
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId).map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        //aca ya no usamos httpOk sino httpCreated
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        //aca hacemos una condicion si borro o no
        if(productService.delete(productId)){
        return new ResponseEntity(HttpStatus.OK) ;
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }





}
