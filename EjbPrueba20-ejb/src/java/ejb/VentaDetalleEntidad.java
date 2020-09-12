/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lily
 */
@Entity
public class VentaDetalleEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @ManyToOne
    private VentaEntidad venta;
    
    @ManyToOne
    private ProductoEntidad producto;
    
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    
    @NotNull
    @Column(name = "PRECIO")
    private Double precio;
    
    @NotNull
    @Column(name = "SUBTOTAL")
    private Double sub_total;
    
    @NotNull
    @Column(name = "TOTAL")
    private Double total;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VentaEntidad getVenta() {
        return venta;
    }

    public void setVenta(VentaEntidad venta) {
        this.venta = venta;
    }

    public ProductoEntidad getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntidad producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalleEntidad)) {
            return false;
        }
        VentaDetalleEntidad other = (VentaDetalleEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.VentaDetalleEntidad[ id=" + id + " ]";
    }
    
}
