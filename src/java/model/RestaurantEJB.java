/*
 * Se encarga de la lógica del modelo
 */
package model;

import entities.Cocinero;
import exceptions.ExceptionRestaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author mfontana
 */
@Stateless
public class RestaurantEJB {

    // Para trabajar con la persistencia JPA
    @PersistenceUnit EntityManagerFactory emf;
    
    public void altaCocinero(Cocinero c) throws ExceptionRestaurant {
        EntityManager em = emf.createEntityManager();
        // Comprobamos si ya existe un cocinero 
        Cocinero aux = em.find(Cocinero.class, c.getNombre());
        if (aux != null) {
            em.close();
            throw new ExceptionRestaurant("Ya existe un cocinero con ese nombre");
        }
        em.persist(c);
        em.close();
    }
    
    public List<Cocinero> listadoCocineros() {
        return emf.createEntityManager().createNamedQuery("Cocinero.findAll").getResultList();
    }
}
