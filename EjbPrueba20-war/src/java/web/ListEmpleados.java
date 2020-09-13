package web;

import ejb.EjbSessionManagerBean;
import ejb.EmpleadosEntidad;
import ejb.EmpleadosEntidadFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lily
 */
@WebServlet(name = "ListEmpleados", urlPatterns = {"/ListEmpleados"})
public class ListEmpleados extends HttpServlet {

    @EJB
    private EjbSessionManagerBean ejbSessionManagerBean;

    @EJB
    private EmpleadosEntidadFacade empleadosEntidadFacade;
    
    
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
        request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>::Servlet ListEmpleados</title>::");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListEmpleados at " + request.getContextPath() + "</h1>");
            List emp=empleadosEntidadFacade.findAll();
                for (Iterator it = emp.iterator(); it.hasNext();){
                    EmpleadosEntidad elem= (EmpleadosEntidad) it.next();
                    out.println("<br><b>"+elem.getDni()+"</b><br>");
                    out.println(elem.getApellidos()+"<br>");
                    out.println(elem.getNombre()+"<br>");
                    ////////
                    Calendar cal =elem.getFechaingreso();
                    Date fechaIn = cal.getTime();
                    DateFormat formatoFecha=DateFormat.getDateInstance(java.text.DateFormat.FULL);
                    out.println(formatoFecha.format(fechaIn) +"<br>");
                    
                    ///////////
                    out.println(elem.getEmail()+"<br>");
                    out.println(elem.getDepartamentoId()+"<br>");
                }
            
            out.println("<a href='PostEmpleado'> Agregar un nuevo empleado </a>");
            out.println("<br><br>");
            out.println(ejbSessionManagerBean.getActiveSessionContador()+" Usuarios que están usando la aplicación");
            out.println("</body>");

            out.println("</html>");
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
