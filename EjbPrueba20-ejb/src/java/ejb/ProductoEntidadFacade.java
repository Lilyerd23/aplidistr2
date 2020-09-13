package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lily
 */
@Stateless
public class ProductoEntidadFacade extends AbstractFacade<ProductoEntidad> {

    @PersistenceContext(unitName = "EjbPrueba20-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoEntidadFacade() {
        super(ProductoEntidad.class);
    }
    
}
