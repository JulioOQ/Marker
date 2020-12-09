package com.jvoq.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categorias")
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    @Id
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;

    //Haciendo la relacion con productos de la instancia de categoria
    @OneToMany(mappedBy ="categoria" )
    private List<Producto>productoList;
    //Haciendo la relacion con productos de la instancia de categoria*/

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
