/*
 * [Copyrights by Calvin Mampioper alias CM25 - Bali 2016]
 * [Telp/HP : 081353000852]
 * [visit : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.servletMotoGP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calvin Mampioper
 */
@SuppressWarnings("serial")
public class ServletMotoGP extends HttpServlet {
    private ServletProsesDataRider servletProsesDataRider;
    
    public ServletMotoGP() {
        super();
        servletProsesDataRider = new ServletProsesDataRider();
    }
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        servletProsesDataRider.prosesDataRider(request, response);
    }
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        servletProsesDataRider.prosesDataRider(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}