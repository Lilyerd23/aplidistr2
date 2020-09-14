package web;

import ejb.EjbSessionManagerBean;
import ejb.EmpleadoEntidad;
import ejb.EmpleadoEntidadFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ListEmpleado", urlPatterns = {"/ListEmpleado"})
public class ListEmpleado extends HttpServlet {

    @EJB
    private EjbSessionManagerBean ejbSessionManagerBean;

    @EJB
    private EmpleadoEntidadFacade EmpleadoEntidadFacade;
    
    
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
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link rel='shortcut icon' href='img/logo.png'>");
            out.println("<title>SIDECOM</title>");
            out.println("<link rel='stylesheet' type='text/css' href='vendor/bootstrap/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='fonts/font-awesome-4.7.0/css/font-awesome.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='vendor/animate/animate.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='vendor/select2/select2.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='vendor/perfect-scrollbar/perfect-scrollbar.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='css/util.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='css/main.css'>");
            out.println("</head>");
          

            out.println("<body>");
            out.println("<div class='limiter'>");
            out.println("<div class='container-table100'>");
            out.println("<div class='wrap-table100'>");
            out.println("<div class='table100'>");
            out.println("<table>");

            out.println("<thead>");
            out.println("<tr class='table100-head'>");
            out.println("<th class='column1'>DNI</th>");
            out.println("<th class='column1'>Nombre</th>");
            out.println("<th class='column1'>Apellido</th>");
            out.println("<th class='column1'>Direccion</th>");
            out.println("<th class='column1'>Telefono</th>");
            out.println("<th class='column1'>Email</th>"); 
            out.println("<th class='column1'>Cargo</th>");
            out.println("</tr>");
            out.println("</thead>");

            out.println("<tbody>");
            out.println("<tr>");
            List emp=EmpleadoEntidadFacade.findAll();
            for (Iterator it = emp.iterator(); it.hasNext();){
                    EmpleadoEntidad elem= (EmpleadoEntidad) it.next();           
                    out.println("<td class='column1'>"+elem.getDni()+"</td>");
                    out.println("<td class='column1'>"+elem.getNombres()+"</td>");
                    out.println("<td class='column1'>"+elem.getApellidos()+"</td>");  
                    out.println("<td class='column1'>"+elem.getDireccion()+"</td>");
                    out.println("<td class='column1'>"+elem.getTelefono()+"</td>");
                    out.println("<td class='column1'>"+elem.getEmail()+"</td>");
                    out.println("<td class='column1'>"+elem.getCargo()+"</td>");
                    out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<script src='vendor/jquery/jquery-3.2.1.min.js'></script>");
            out.println("<script src='vendor/bootstrap/js/popper.js'></script>");
            out.println("<script src='vendor/bootstrap/js/bootstrap.min.js'></script>");
            out.println("<script src='vendor/select2/select2.min.js'></script>");
            out.println("<script src='js/main.js'></script>");
            
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
