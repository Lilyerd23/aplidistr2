package ejb;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author lily
 */
@Singleton
@LocalBean
//agregamos nueva notacion que tiene que ver con la pag web
@WebListener
public class EjbSessionManagerBean implements HttpSessionListener{
    private static int contador=0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       
        contador ++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        contador --;
    }
    public int getActiveSessionContador(){
        return contador;
    }
}
