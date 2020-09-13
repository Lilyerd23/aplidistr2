package jms;

import ejb.ClienteJuridicoEntidad;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lily
 */
@JMSDestinationDefinition(name = "java:app/jms/ClienteJuridicoMessageBean", 
        interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "ClienteJuridicoMessageBean")


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/ClienteJuridicoMessageBean"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ClienteJuridicoMessageBean implements MessageListener {
    // manejo de retorno de mensaje, este recurso
    @Resource
    private MessageDrivenContext mdc;
    //agregaremos la entidad con la que deseamos trabajar,click derecho y generar codigo y unit entity manager
    @PersistenceContext(unitName = "EjbPrueba20-ejbPU")
    private EntityManager em;
     
    public ClienteJuridicoMessageBean() {
    }   
    @Override
    public void onMessage(Message message) {
        ObjectMessage msg=null;
        try{
            if(message instanceof ObjectMessage){
                msg = (ObjectMessage)message;
                ClienteJuridicoEntidad e= (ClienteJuridicoEntidad)msg.getObject ();
                save(e);
            }
        }catch (JMSException e){    
            e.printStackTrace();
            mdc.setRollbackOnly();
        }catch (Throwable te){
            te.printStackTrace();
        }
    }
    
    // cambiamos de nombre a save, estaba public void persist (Object object)
    public void save(Object object) {
        em.persist(object);
    }

    
}
