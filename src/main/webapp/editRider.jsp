<%-- 
    Document   : index2
    Created on : Oct 6, 2017, 5:00:43 PM
    Author     : Calvin Mampioper
--%>

<%@page import="calvin.mpr.motogp2017.dao.KategoriTeamDao"%>
<%@page import="calvin.mpr.motogp2017.bean.KategoriTeam"%>
<%@page import="calvin.mpr.motogp2017.bean.KategoriTeam"%>
<%@page import="calvin.mpr.motogp2017.bean.DataRider"%>
<%@page import="java.util.List"%>
<%@page import="calvin.mpr.motogp2017.dao.DataRiderDao"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%
    DataRider dtrider = new DataRider();
    DataRiderDao dataRiderDao = new DataRiderDao();
    KategoriTeamDao kategoriTeamDao = new KategoriTeamDao();
    List<KategoriTeam> kategoriTeams = kategoriTeamDao.getAllTeam();
%>


<hr>
<!--Form untuk menambahkan Rider-->

<form method="POST" action='ServletMotoGP' name="frmEditBuku">
    <input type="hidden" name="action" value="update" />
    <%
        String id_rider = request.getParameter("idrider");
        if (!((id_rider) == null)) {
            int id = Integer.parseInt(id_rider);
            dtrider = dataRiderDao.findRidersById(id);
    %>
    <p align="center"><b>Edit Record</b></p>
    <table width="50%" align="center">
        <tr>
            <td>Nama Rider</td>
            <td><input type="text" name="nmrider" value="<%=dtrider.getNama()%>"/></td>
            <td colspan="2"><input type="hidden" name="idrider" readonly="" value="<%=dtrider.getId()%>"/></td>
        </tr>
        <tr>
            <td>Nomor Rider</td>
            <td><input type="number" name="norider" value="<%=dtrider.getNomor()%>"/></td>
            <td>Team Rider</td>
            <td>
                <select name="team">
                    <% for (KategoriTeam kategoriTeam : kategoriTeams) {%>
                    <option value="<%=kategoriTeam.getId()%>" selected=""><%=kategoriTeam.getTeam()%></option>
                    <%}%>
                </select>
            </td>
        </tr>

        <tr>
            <td>Asal Negara</td>
            <td><input type="text" name="aslnegara" value="<%=dtrider.getNegara()%>"/></td>
            <td>Poin Rider</td>
            <td><input type="number" name="poin" value="<%=dtrider.getPoin()%>"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <div style="margin-top: 10px;text-align: center;">
                    <input type="submit" value="Update" />
                </div>
            </td>
        </tr>
    </table>
</form>
<%
    } else
        out.println("ID Not Found");
%>
<p align="center"><a href="/MotoGP2017">View-All-Records</a></p>