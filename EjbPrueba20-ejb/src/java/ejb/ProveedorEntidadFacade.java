package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lily
 */
@Stateless
public class ProveedorEntidadFacade extends AbstractFacade<ProveedorEntidad> {

    @PersistenceContext(unitName = "EjbPrueba20-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorEntidadFacade() {
        super(ProveedorEntidad.class);
    }
    
}
