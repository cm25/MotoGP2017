/*
 * [Copyrights by Calvin Mampioper alias CM25 - Bali 2016]
 * [Telp/HP : 081353000852]
 * [visit : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.servletMotoGP;

import calvin.mpr.motogp2017.bean.DataRider;
import calvin.mpr.motogp2017.dao.DataRiderDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calvin Mampioper
 */
@SuppressWarnings("serial")
public class ServletProsesDataRider  {
    private static final String EditRider = "/editRider.jsp";
    private static final String ListRider = "/index.jsp";
    private final DataRiderDao dataRiderDao;
    
    public ServletProsesDataRider(){
        super();
        dataRiderDao = new DataRiderDao();
    }
    protected void prosesDataRider(HttpServletRequest request, HttpServletResponse respon)
            throws ServletException, IOException {
        @SuppressWarnings("UnusedAssignment")
        String redirectUrl = "";
        String idRider = request.getParameter("idrider");
        System.out.println("Id. Rider = " + idRider);
        String action = request.getParameter("action");
        if (idRider != null && action.equalsIgnoreCase("insert")) {
//            int id = Integer.parseInt(idRider);
            DataRider dataRider = new DataRider();
//            dataRider.setIdrider(id);
            dataRider.setNama(request.getParameter("nmrider"));
            dataRider.setNomor(Integer.parseInt(request.getParameter("norider")));
            dataRider.setTeam(request.getParameter("team"));
            dataRider.setNegara(request.getParameter("aslnegara"));
            dataRider.setPoin(Integer.parseInt(request.getParameter("poin")));

            dataRiderDao.addRider(dataRider);
            redirectUrl = ListRider;
            request.setAttribute("idrider", dataRiderDao.getAllRiders());
            System.out.println("Record Added Successfully");
        }
        else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(idRider);
            dataRiderDao.deleteDataRidersId(id);
            redirectUrl = ListRider;
            request.setAttribute("idrider", dataRiderDao.getAllRiders());
            System.out.println("Record Deleted Successfully");
        } else if (action.equalsIgnoreCase("getAll")) {
            redirectUrl = ListRider;
            request.setAttribute("idrider", dataRiderDao.getAllRiders());
        } else if (action.equalsIgnoreCase("editform")) {
            redirectUrl = EditRider;
        } else if (action.equalsIgnoreCase("update")) {
            System.out.println("Im Here" + idRider);
            int id = Integer.parseInt(idRider);
            DataRider dataRider = new DataRider();
            dataRider.setId(id);
            dataRider.setNama(request.getParameter("nmrider"));
            dataRider.setNomor(Integer.parseInt(request.getParameter("norider")));
            dataRider.setTeam(request.getParameter("team"));
            dataRider.setNegara(request.getParameter("aslnegara"));
            dataRider.setPoin(Integer.parseInt(request.getParameter("poin")));

            dataRiderDao.editDataRiders(dataRider);
            request.setAttribute("nmrider", dataRider);
            redirectUrl = ListRider;
            System.out.println("Record updated Successfully");

        } else {
            redirectUrl = ListRider;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirectUrl);
        rd.forward(request, respon);
    }
}
