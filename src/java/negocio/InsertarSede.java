/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import CLASES_BD.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eclavijo
 */
public class InsertarSede {
    public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNIVERSIDADPU");
EntityManager em = emf.createEntityManager();

em.getTransaction().begin();
Sede p1 = new Sede();
p1.setNombreSede("MEDELLIN");
p1.setNombreSede("CALI");
p1.setNombreSede("CAMPUS");
em.getTransaction().commit();
em.close();
emf.close();



}
  
   
}
