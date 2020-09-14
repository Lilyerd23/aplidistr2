/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import ejb.ProductoEntidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexandro
 */
@WebServlet(name = "PostProducto", urlPatterns = {"/PostProducto"})
public class PostProducto extends HttpServlet {

    @Resource(mappedName = "jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ProductoMessageBean")
    private Queue queue;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ////////////////////////////

        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String precio_compra = request.getParameter("precio_compra");
        String precio_venta = request.getParameter("precio_venta");
        String fecha = request.getParameter("fecha");
        
        if ((nombre != null) && (cantidad != null)) {
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                ObjectMessage message = session.createObjectMessage();
                ProductoEntidad e = new ProductoEntidad();
                e.setNombre(nombre);
                e.setCantidad(Integer.parseInt(cantidad));
                e.setPrecio_compra(Double.parseDouble(precio_compra));
                e.setPrecio_venta(Double.parseDouble(precio_venta));
                
                Calendar fechaCal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaIn = sdf.parse(fecha);
                fechaCal.setTime(fechaIn);
                e.setFecha(fechaCal);
          
                //e.setFechaingreso(fechaingreso);
                ////////
                message.setObject(e);
                messageProducer.send(message);
                messageProducer.close();
                connection.close();
                //response.sendRedirect("ListProducto");

            } catch (JMSException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(PostEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

        ///////////////////////////
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<link rel='shortcut icon' href='img/logo.png'>");
            out.println("<title>SIDECOM</title>");
            out.println("<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>");
            out.println("<link rel='stylesheet' href='css/bootstrap.css'>");
            out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='css/estilos.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='img/styles.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container' id='registration-form'>");
            out.println("<div class='image'></div>");
            out.println("<div class='frm'>");
            out.println("<h1>Producto</h1>");
            out.println("<form action='PostProducto' method='post'>");

            out.println("<div class='form-group'>");
            out.println("<label for='username'>NOMBRE:</label>");
            out.println("<input type='text' name='nombre' class='form-control' placeholder='Ingresar nombre'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>CANTIDAD:</label>");
            out.println("<input type='text' name='cantidad' class='form-control' placeholder='Ingresar Cantidad'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>PRECIO COMPRA:</label>");
            out.println("<input type='text' name='precio_compra' class='form-control' placeholder='Ingresar precio_compra'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>PRECIO VENTA:</label>");
            out.println("<input type='text' name='precio_venta' class='form-control' placeholder='Ingresar precio_venta'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>FECHA:</label>");
            out.println("<input type='date' name='fecha' class='form-control' >");
            out.println("</div>");
            
            
            out.println("<div class='form-group'>");
            out.println("<input type='submit' class='btn btn-success btn-lg' value='Guardar'>");
            out.println("</div>");
            out.println("</form>");
            //////

            out.println("</div>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
           
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
