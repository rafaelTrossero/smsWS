/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")
    , @NamedQuery(name = "Mensaje.findByIdmensaje", query = "SELECT m FROM Mensaje m WHERE m.idmensaje = :idmensaje")
    , @NamedQuery(name = "Mensaje.findByMsjTexto", query = "SELECT m FROM Mensaje m WHERE m.msjTexto = :msjTexto")
    , @NamedQuery(name = "Mensaje.findByFecha", query = "SELECT m FROM Mensaje m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mensaje.findByTipo", query = "SELECT m FROM Mensaje m WHERE m.tipo = :tipo")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmensaje")
    private Integer idmensaje;
    @Size(max = 160)
    @Column(name = "msj_texto")
    private String msjTexto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "tipo")
    private Short tipo;
    @ManyToMany(mappedBy = "mensajeCollection")
    private Collection<Destinatarios> destinatariosCollection;
    @ManyToMany(mappedBy = "mensajeCollection")
    private Collection<Campania> campaniaCollection;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getMsjTexto() {
        return msjTexto;
    }

    public void setMsjTexto(String msjTexto) {
        this.msjTexto = msjTexto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Destinatarios> getDestinatariosCollection() {
        return destinatariosCollection;
    }

    public void setDestinatariosCollection(Collection<Destinatarios> destinatariosCollection) {
        this.destinatariosCollection = destinatariosCollection;
    }

    @XmlTransient
    public Collection<Campania> getCampaniaCollection() {
        return campaniaCollection;
    }

    public void setCampaniaCollection(Collection<Campania> campaniaCollection) {
        this.campaniaCollection = campaniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idmensaje == null && other.idmensaje != null) || (this.idmensaje != null && !this.idmensaje.equals(other.idmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mensaje[ idmensaje=" + idmensaje + " ]";
    }
    
}
