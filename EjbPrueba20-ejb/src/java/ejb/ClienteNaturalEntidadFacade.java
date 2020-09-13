package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lily
 */
@Stateless
public class ClienteNaturalEntidadFacade extends AbstractFacade<ClienteNaturalEntidad> {

    @PersistenceContext(unitName = "EjbPrueba20-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteNaturalEntidadFacade() {
        super(ClienteNaturalEntidad.class);
    }
    
}
