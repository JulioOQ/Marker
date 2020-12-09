package com.jvoq.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    //indicamos la anotacion MapsID indicamos el nombre de la clave primaria a enlazar
    //Haciendo relaciones con la tabla compras en el atributo id_compra
    @MapsId("idCompra")
    @ManyToOne
    @JoinColumn(name ="id_compra",insertable = false,updatable = false )
    private Compra compra;
    //Haciendo relaciones con la tabla compras en el atributo id_compra*/

    //Haciendo relaciones con la tabla productos en el atributo id_producto
    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false, updatable = false)
    private Producto producto;
    //Haciendo relaciones con la tabla productos en el atributo id_producto*/


    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
