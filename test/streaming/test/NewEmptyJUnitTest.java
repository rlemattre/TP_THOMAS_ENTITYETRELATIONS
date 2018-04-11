/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author romua
 */
public class NewEmptyJUnitTest {
    
    @Test
    public void demarreJPA() {
    
        EntityManagerFactory f = Persistence.createEntityManagerFactory("PU");

        //EntityManager em = f.createEntityManager();
        
        //em.getTransaction().begin();
        
        //Film film = new Film();
        //film.setTitre("trainspotting");
        //film.setAnneeDeProduction(2000);
        
        //em.persist(film);
        
        //em.getTransaction().commit();
    }
    
}
