/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES_BD;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eclavijo
 */
@Entity
@Table(name = "CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByCodCar", query = "SELECT c FROM Carrera c WHERE c.codCar = :codCar"),
    @NamedQuery(name = "Carrera.findByNombreCar", query = "SELECT c FROM Carrera c WHERE c.nombreCar = :nombreCar")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "COD_CAR")
    private Integer codCar;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE_CAR")
    private String nombreCar;
    @JoinColumn(name = "SEDE", referencedColumnName = "NOMBRE_SEDE")
    @ManyToOne(optional = false)
    private Sede sede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreCar")
    private Collection<Estudiante> estudianteCollection;

    public Carrera() {
    }

    public Carrera(String nombreCar) {
        this.nombreCar = nombreCar;
    }

    public Integer getCodCar() {
        return codCar;
    }

    public void setCodCar(Integer codCar) {
        this.codCar = codCar;
    }

    public String getNombreCar() {
        return nombreCar;
    }

    public void setNombreCar(String nombreCar) {
        this.nombreCar = nombreCar;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreCar != null ? nombreCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.nombreCar == null && other.nombreCar != null) || (this.nombreCar != null && !this.nombreCar.equals(other.nombreCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CLASES_BD.Carrera[ nombreCar=" + nombreCar + " ]";
    }
    
}
