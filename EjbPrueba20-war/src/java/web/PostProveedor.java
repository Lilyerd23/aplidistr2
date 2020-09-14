/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import ejb.ProveedorEntidad;
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
@WebServlet(name = "PostProveedor", urlPatterns = {"/PostProveedor"})
public class PostProveedor extends HttpServlet {

    @Resource(mappedName = "jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ProveedorMessageBean")
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

        String proveedor = request.getParameter("proveedor");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String cargo = request.getParameter("cargo");
        String fecha = request.getParameter("fecha");

        if ((proveedor != null) && (telefono != null)) {
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                ObjectMessage message = session.createObjectMessage();
                ProveedorEntidad e = new ProveedorEntidad();
                e.setProveedor(proveedor);
                e.setTelefono(telefono);
                e.setDireccion(direccion);
                e.setCorreo(correo);

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
                //response.sendRedirect("ListProveedor");

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
            out.println("<h1>Proveedor</h1>");
            out.println("<form action='PostProveedor' method='post'>");

            out.println("<div class='form-group'>");
            out.println("<label for='username'>PROVEEDOR:</label>");
            out.println("<input type='text' name='proveedor' class='form-control' placeholder='Ingresar proveedor'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>TELEFONO:</label>");
            out.println("<input type='text' name='telefono' class='form-control' placeholder='Ingresar Nombre'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>DIRECCION:</label>");
            out.println("<input type='text' name='direccion' class='form-control' placeholder='Ingresar Direccion'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>CORREO:</label>");
            out.println("<input type='txt' name='correo' class='form-control' placeholder='Ingresar correo'>");
            out.println("</div>");
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
