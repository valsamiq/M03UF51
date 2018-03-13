/*
 * Servlet para gestionar el alta de cocinero
 */
package controller;

import entities.Cocinero;
import exceptions.ExceptionRestaurant;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RestaurantEJB;

/**
 *
 * @author mfontana
 */
public class NewCocinero extends HttpServlet {
    
    @EJB RestaurantEJB miEjb;

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
        // Recogemos las variables del formulario 
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String sexo = request.getParameter("sexo");
        int edad = Integer.parseInt(request.getParameter("edad"));
        int experiencia = Integer.parseInt(request.getParameter("experiencia"));
        String especialidad = request.getParameter("especialidad");
        // Creamos el cocinero con los datos del formulario
        Cocinero c = new Cocinero(nombre, telefono, sexo, edad, experiencia, especialidad);
        try {
            miEjb.altaCocinero(c);
            // Si el alta ha ido bien devolvemos msg ok
            request.setAttribute("status", "Cocinero dado de alta");
        } catch (ExceptionRestaurant ex) {
            // Devolvemos mensaje de la excepción a la vista
            request.setAttribute("status", ex.getMessage());
        }
        // Redirigimos a la vista (final.jsp en este caso)
        request.getRequestDispatcher("/final.jsp").forward(request,response);
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
