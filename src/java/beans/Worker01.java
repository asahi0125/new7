package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Worker01 {

    @PersistenceContext
    private EntityManager em;

    public void register(BookEntity01 be) {
        em.persist(be);
    }
}
