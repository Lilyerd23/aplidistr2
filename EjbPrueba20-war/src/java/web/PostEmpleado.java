/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import ejb.EmpleadoEntidad;
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
@WebServlet(name = "PostEmpleado", urlPatterns = {"/PostEmpleado"})
public class PostEmpleado extends HttpServlet {

    @Resource(mappedName = "jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/EmpleadoMessageBean")
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

        String dni = request.getParameter("dni");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");;

        if ((dni != null) && (nombres != null)) {
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                ObjectMessage message = session.createObjectMessage();
                EmpleadoEntidad e = new EmpleadoEntidad();
                e.setDni(dni);
                e.setNombres(nombres);
                e.setApellidos(apellidos);
                e.setDireccion(direccion);
                e.setTelefono(telefono);
                e.setEmail(email);
                e.setCargo(cargo);

                /////////
          
                //e.setFechaingreso(fechaingreso);
                ////////
                message.setObject(e);
                messageProducer.send(message);
                messageProducer.close();
                connection.close();
                //response.sendRedirect("ListEmpleado");

            } catch (JMSException ex) {
                ex.printStackTrace();
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
            out.println("<h1>EMPLEADO</h1>");
            out.println("<form action='PostEmpleado' method='post'>");

            out.println("<div class='form-group'>");
            out.println("<label for='username'>DNI:</label>");
            out.println("<input type='text' name='dni' class='form-control' placeholder='Ingresar DNI'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>APELLIDOS:</label>");
            out.println("<input type='text' name='apellidos' class='form-control' placeholder='Ingresar Apellidos'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>NOMBRES:</label>");
            out.println("<input type='text' name='nombres' class='form-control' placeholder='Ingresar Nombre'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>DIRECCION:</label>");
            out.println("<input type='text' name='direccion' class='form-control' placeholder='Ingresar Direccion'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>TELEFONO:</label>");
            out.println("<input type='txt' name='telefono' class='form-control' placeholder='Ingresar Telefono'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>EMAIL:</label>");
            out.println("<input type='txt' name='email' class='form-control' placeholder='Ingresar Email'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='username'>CARGO:</label>");
            out.println("<input type='txt' name='cargo' class='form-control' placeholder='Ingresar cargo'>");
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
