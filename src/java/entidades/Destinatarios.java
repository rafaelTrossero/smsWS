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
@Table(name = "destinatarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinatarios.findAll", query = "SELECT d FROM Destinatarios d")
    , @NamedQuery(name = "Destinatarios.findByIddestinatarios", query = "SELECT d FROM Destinatarios d WHERE d.iddestinatarios = :iddestinatarios")
    , @NamedQuery(name = "Destinatarios.findByNumero", query = "SELECT d FROM Destinatarios d WHERE d.numero = :numero")})
public class Destinatarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestinatarios")
    private Integer iddestinatarios;
    @Size(max = 45)
    @Column(name = "numero")
    private String numero;
    @ManyToMany(mappedBy = "destinatariosCollection")
    private Collection<Agenda> agendaCollection;
    @JoinTable(name = "mensaje_has_destinatarios", joinColumns = {
        @JoinColumn(name = "destinatarios_iddestinatarios", referencedColumnName = "iddestinatarios")}, inverseJoinColumns = {
        @JoinColumn(name = "mensaje_idmensaje", referencedColumnName = "idmensaje")})
    @ManyToMany
    private Collection<Mensaje> mensajeCollection;

    public Destinatarios() {
    }

    public Destinatarios(Integer iddestinatarios) {
        this.iddestinatarios = iddestinatarios;
    }

    public Integer getIddestinatarios() {
        return iddestinatarios;
    }

    public void setIddestinatarios(Integer iddestinatarios) {
        this.iddestinatarios = iddestinatarios;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinatarios != null ? iddestinatarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinatarios)) {
            return false;
        }
        Destinatarios other = (Destinatarios) object;
        if ((this.iddestinatarios == null && other.iddestinatarios != null) || (this.iddestinatarios != null && !this.iddestinatarios.equals(other.iddestinatarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Destinatarios[ iddestinatarios=" + iddestinatarios + " ]";
    }
    
}
