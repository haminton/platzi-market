package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
@Data
public class ComprasProducto {

    @EmbeddedId
    private ComprasproductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
