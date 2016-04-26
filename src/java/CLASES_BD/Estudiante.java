/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES_BD;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eclavijo
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCodEst", query = "SELECT e FROM Estudiante e WHERE e.codEst = :codEst"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiante.findByEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :edad"),
    @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EST")
    private Integer codEst;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "EDAD")
    private Integer edad;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @JoinColumn(name = "NOMBRE_CAR", referencedColumnName = "NOMBRE_CAR")
    @ManyToOne(optional = false)
    private Carrera nombreCar;
    @JoinColumn(name = "SEDE", referencedColumnName = "NOMBRE_SEDE")
    @ManyToOne(optional = false)
    private Sede sede;

    public Estudiante() {
    }

    public Estudiante(Integer codEst) {
        this.codEst = codEst;
    }

    public Integer getCodEst() {
        return codEst;
    }

    public void setCodEst(Integer codEst) {
        this.codEst = codEst;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Carrera getNombreCar() {
        return nombreCar;
    }

    public void setNombreCar(Carrera nombreCar) {
        this.nombreCar = nombreCar;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEst != null ? codEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CLASES_BD.Estudiante[ codEst=" + codEst + " ]";
    }
    
}
