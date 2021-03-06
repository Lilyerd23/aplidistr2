/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lily
 */
@Entity
@Table(name="CLIENTE")
public class ClienteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="IDCLIENTE")
    private Long id;

    @ManyToOne
    private ClienteNaturalEntidad cliente_natural;
    
    @ManyToOne
    private ClienteJuridicoEntidad cliente_juridico;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Calendar fecha;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteNaturalEntidad getCliente_natural() {
        return cliente_natural;
    }

    public void setCliente_natural(ClienteNaturalEntidad cliente_natural) {
        this.cliente_natural = cliente_natural;
    }

    public ClienteJuridicoEntidad getCliente_juridico() {
        return cliente_juridico;
    }

    public void setCliente_juridico(ClienteJuridicoEntidad cliente_juridico) {
        this.cliente_juridico = cliente_juridico;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof ClienteEntidad)) {
            return false;
        }
        ClienteEntidad other = (ClienteEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ClienteEntidad[ id=" + id + " ]";
    }
    
}
