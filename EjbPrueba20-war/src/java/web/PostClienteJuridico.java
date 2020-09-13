/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.ClienteJuridicoEntidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author lily
 */
@WebServlet(name = "PostClienteJuridico", urlPatterns = {"/PostClienteJuridico"})
public class PostClienteJuridico extends HttpServlet {
@Resource(mappedName="jms/NewMessageFactory")
private ConnectionFactory connectionFactory;
@Resource(mappedName="jms/ClienteJuridicoMessageBean")
private Queue queque;
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
        /////////
        
        String razon_social=         request.getParameter("razon_social");
        String ruc=      request.getParameter("ruc");
        String correo=   request.getParameter("correo");
        String fecha=request.getParameter("fecha");
        String telefono=request.getParameter("telefono");
        
        if(razon_social !=null && (ruc!= null)){
            try{
                Connection connection =connectionFactory.createConnection();
                Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer=session.createProducer(queque);
                ObjectMessage message= session.createObjectMessage();
                ///aqui trabajsmo u seteamos lov valors de ClienteJuridicoEntidad
                ClienteJuridicoEntidad e= new ClienteJuridicoEntidad();
                e.setRazon_social(razon_social);
                e.setRuc(ruc);
                e.setCorreo(correo);
                
                ////////
                Calendar fechaCal= Calendar.getInstance();
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                Date fechaIn = sdf.parse(fecha);
                fechaCal.setTime(fechaIn);
                e.setFecha(fechaCal);
                /////////
                e.setTelefono(telefono);
                
                message.setObject(e);
                messageProducer.send(message);
                messageProducer.close();
                connection.close();
                response.sendRedirect("ListClienteJuridico");
                   
            }catch(JMSException ex){
                ex.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(PostClienteJuridico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /////
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostClienteJuridico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostClienteJuridico at " + request.getContextPath() + "</h1>");
           //////////////////////
           out.println("<form action='PostClienteJuridico' method= 'post'>");
           out.println("<table>");
          
           out.println("<tr>");
            out.println("<td> <b>razon_social: </td>");
           out.println("<td><input type='text' name='razon_social'/></td>");
           out.println("</tr>");
           
           out.println("<tr>");
           out.println("<td><b>correo:</td>");
           out.println("<td><input type='text' name='correo'></td>");
           out.println("</tr>");
           
           out.println("<tr>");
           out.println("<td><b>rucs:</td>");
           out.println("<td><input type='text' name='ruc'></td>");
           out.println("</tr>");
        
           out.println("<tr>");
           out.println("<td><b>fecha:</td>");
           out.println("<td><input type='date' name='fecha'></td>");
           out.println("</tr>");
           
           out.println("<tr>");
           out.println("<td><b>Departamento: </td>");
           out.println("<td><input type='text' name='telefono'></td>");
           out.println("</tr>");
           out.print("</table>");
           
            out.println("<input type ='submit' value=' Enviar ClienteJuridico '>");
            out.println("</form>");
            
            /////////////////eeeeeeeeeeeeeeeeeeeeeeeeeeeeee
            out.println("</body>");
            out.println("</html>");
        }finally{
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
    //cuando queremos enviar datos
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
