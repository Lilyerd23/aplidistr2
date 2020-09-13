package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 
 * @author lily
 */
@Stateless
public class ClienteEntidadFacade extends AbstractFacade<ClienteEntidad> {

    @PersistenceContext(unitName = "EjbPrueba20-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteEntidadFacade() {
        super(ClienteEntidad.class);
    }
    
}
