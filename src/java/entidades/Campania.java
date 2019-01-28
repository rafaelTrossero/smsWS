/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "campania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campania.findAll", query = "SELECT c FROM Campania c")
    , @NamedQuery(name = "Campania.findByIdcampania", query = "SELECT c FROM Campania c WHERE c.idcampania = :idcampania")
    , @NamedQuery(name = "Campania.findByNombre", query = "SELECT c FROM Campania c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Campania.findByDescripcion", query = "SELECT c FROM Campania c WHERE c.descripcion = :descripcion")})
public class Campania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampania")
    private Integer idcampania;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "campania_has_mensaje", joinColumns = {
        @JoinColumn(name = "campania_idcampania", referencedColumnName = "idcampania")}, inverseJoinColumns = {
        @JoinColumn(name = "mensaje_idmensaje", referencedColumnName = "idmensaje")})
    @ManyToMany
    private Collection<Mensaje> mensajeCollection;
    @ManyToMany(mappedBy = "campaniaCollection")
    private Collection<Agenda> agendaCollection;

    public Campania() {
    }

    public Campania(Integer idcampania) {
        this.idcampania = idcampania;
    }

    public Integer getIdcampania() {
        return idcampania;
    }

    public void setIdcampania(Integer idcampania) {
        this.idcampania = idcampania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampania != null ? idcampania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campania)) {
            return false;
        }
        Campania other = (Campania) object;
        if ((this.idcampania == null && other.idcampania != null) || (this.idcampania != null && !this.idcampania.equals(other.idcampania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Campania[ idcampania=" + idcampania + " ]";
    }
    
}
