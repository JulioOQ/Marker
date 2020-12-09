package com.jvoq.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name="medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;


    //Haciendo la relacion en con clientes su atributo id_cliente
    @ManyToOne
    @JoinColumn(name ="id_cliente",insertable = false,updatable = false )
    private Cliente cliente;
    //Haciendo la relacion en con clientes su atributo id_cliente*/

    //cambiamos el mappedBy a compra
    //indicamos que se guarde los productos en cascada
    //Haciendo la relacion en con compras_productos con su instancia producto//lohizo raro aca
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<ComprasProducto>comprasProductoList;
    //Haciendo la relacion en con compras_productos  con su instancia producto//lohizo raro aca*/


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getComprasProductoList() {
        return comprasProductoList;
    }

    public void setComprasProductoList(List<ComprasProducto> comprasProductoList) {
        this.comprasProductoList = comprasProductoList;
    }
}
