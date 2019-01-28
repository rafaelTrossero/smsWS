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
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByIdagenda", query = "SELECT a FROM Agenda a WHERE a.idagenda = :idagenda")
    , @NamedQuery(name = "Agenda.findByNombre", query = "SELECT a FROM Agenda a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Agenda.findByDescripcion", query = "SELECT a FROM Agenda a WHERE a.descripcion = :descripcion")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagenda")
    private Integer idagenda;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "destinatarios_has_agenda", joinColumns = {
        @JoinColumn(name = "agenda_idagenda", referencedColumnName = "idagenda")}, inverseJoinColumns = {
        @JoinColumn(name = "destinatarios_iddestinatarios", referencedColumnName = "iddestinatarios")})
    @ManyToMany
    private Collection<Destinatarios> destinatariosCollection;
    @JoinTable(name = "campania_has_agenda", joinColumns = {
        @JoinColumn(name = "agenda_idagenda", referencedColumnName = "idagenda")}, inverseJoinColumns = {
        @JoinColumn(name = "campania_idcampania", referencedColumnName = "idcampania")})
    @ManyToMany
    private Collection<Campania> campaniaCollection;

    public Agenda() {
    }

    public Agenda(Integer idagenda) {
        this.idagenda = idagenda;
    }

    public Integer getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(Integer idagenda) {
        this.idagenda = idagenda;
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
        hash += (idagenda != null ? idagenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idagenda == null && other.idagenda != null) || (this.idagenda != null && !this.idagenda.equals(other.idagenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Agenda[ idagenda=" + idagenda + " ]";
    }
    
}
