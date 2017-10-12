/*
 * [Copyrights by Calvin Mampioper alias CM25 - Bali 2016]
 * [Telp/HP : 081353000852]
 * [visit : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.servletMotoGP;

import calvin.mpr.motogp2017.bean.KategoriTeam;
import calvin.mpr.motogp2017.connection.ConnectionDB;
import calvin.mpr.motogp2017.dao.KategoriTeamDao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calvin Mampioper
 */
@SuppressWarnings("serial")
public class ServletProsesKategoriTeam extends HttpServlet {
    private static final String EditTeam = "editTeam.jsp";
    private static final String ListTeam = "/k_team.jsp";
    private final KategoriTeamDao kategoriTeamDao;
     private final Connection connection;
     
    public ServletProsesKategoriTeam(){
        super();
        connection = ConnectionDB.getConnectionDB();
        kategoriTeamDao = new KategoriTeamDao();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void prosesDataTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        @SuppressWarnings("UnusedAssignment")
        String redirectUrl = "";
        String id = request.getParameter("id");
        System.out.println("kteam = " + id);
        String action = request.getParameter("action");
        //start insert
        if (id != null && action.equalsIgnoreCase("insert_kategori_team")) {
            KategoriTeam kategoriTeam = new KategoriTeam();
            kategoriTeam.setTeam(request.getParameter("kteam"));
            kategoriTeamDao.addTeams(kategoriTeam);
            redirectUrl = ListTeam;
            request.setAttribute("id", kategoriTeamDao.getAllTeam());
            System.out.println("Record Added Successfully");
        }
        //end insert
        else if (action.equalsIgnoreCase("getAll")) {
            redirectUrl = ListTeam;
            request.setAttribute("kteam", kategoriTeamDao.getAllTeam());
        }
        else if (action.equalsIgnoreCase("editform")) {
            redirectUrl = EditTeam;
        }
        else if (action.equalsIgnoreCase("update_kategori")) {
            System.out.println("Im Here" + id);
            int idteam = Integer.parseInt(id);
            KategoriTeam kategoriTeam = new KategoriTeam();
            kategoriTeam.setId(idteam);
            kategoriTeam.setTeam(request.getParameter("kteam"));

            kategoriTeamDao.editKategoriTeam(kategoriTeam);
            request.setAttribute("kteam", kategoriTeam);
            redirectUrl = ListTeam;
            System.out.println("Record updated Successfully");

        }
        else if (action.equalsIgnoreCase("delete_k_team")) {
            int idx = Integer.parseInt(id);
            kategoriTeamDao.deleteDataRidersId(idx);
            redirectUrl = ListTeam;
            request.setAttribute("id", kategoriTeamDao.getAllTeam());
            System.out.println("Record Deleted Successfully");
        }
        else {
            redirectUrl = ListTeam;
        }
        RequestDispatcher rd = request.getRequestDispatcher(redirectUrl);
        rd.forward(request, response);
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
        prosesDataTeam(request, response);
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
        prosesDataTeam(request, response);
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
