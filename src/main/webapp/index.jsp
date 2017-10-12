<%-- 
    Document   : index2
    Created on : Oct 6, 2017, 5:00:43 PM
    Author     : Calvin Mampioper
--%>

<%@page import="calvin.mpr.motogp2017.dao.KategoriTeamDao"%>
<%@page import="calvin.mpr.motogp2017.bean.KategoriTeam"%>
<%@page import="calvin.mpr.motogp2017.bean.DataRider"%>
<%@page import="java.util.List"%>
<%@page import="calvin.mpr.motogp2017.dao.DataRiderDao"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>MotoGP 2017</title>
    </head>
    <body>
        <%
            DataRiderDao dataRiderDao = new DataRiderDao();
            List<DataRider> dataRiders = dataRiderDao.getAllRiders();
            KategoriTeamDao kategoriTeamDao = new KategoriTeamDao();
            List<KategoriTeam> kategoriTeams = kategoriTeamDao.getAllTeam();
        %>
        <div id="titeltop" align="center">
            <h1>MotoGP 2017 [Data Riders]</h1>
            <a href="includes/k_team.jsp">Add Kategori Team</a> || <a href="includes/k_sirkuit.jsp">Add Kategori Sirkuit</a>
            <br><br>
        </div>        
        <div id="data_tabel">
            <table width="100%" border="0" cellpadding="2">
                <tr>
                    <%
                        String[] data = {"Nama Lengkap", "Nomor", "Team", "Asal Negara", "Poin", "Control"};
                        for (int i = 0; i < data.length; i++) {
                            out.println("<th align=\"left\">" + data[i].toUpperCase() + "</th>");
                        }
                    %>
                </tr>
                <% for (DataRider dataRider : dataRiders) {%>
                <tr>
                    <td><%=dataRider.getNama()%></td>
                    <td><%=dataRider.getNomor()%></td>
                    <td><%=dataRider.getTeam()%></td>
                    <td><%=dataRider.getNegara()%></td>
                    <td><%=dataRider.getPoin()%></td>
                    <td>
                        <a href="ServletMotoGP?action=editform&idrider=<%=dataRider.getId()%>">Update</a> || 
                        <a href="ServletMotoGP?action=delete&idrider=<%=dataRider.getId()%>">Delete</a>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>
        <hr>
        <!--Form untuk menambahkan Rider-->

        <form method="POST" action='ServletMotoGP' name="frmAddRider">
            <input type="hidden" name="action" value="insert" />
            <p align="center"><b>Add New Record [Rider]</b></p>
            <table width="50%" align="center">
                <tr>
                    <td>Nama Rider</td>
                    <td><input type="text" name="nmrider" placeholder="Nama Rider"/></td>
                    <td colspan="2"><input type="hidden" name="idrider" readonly=""/></td>
                </tr>
                <tr>
                    <td>Nomor Rider</td>
                    <td><input type="number" name="norider" placeholder="Nomor Rider"/></td>
                    <td>Team Rider</td>
                    <td>
                        <select name="team">
                            <% for (KategoriTeam kategoriTeam : kategoriTeams) {%>
                            <option value="<%=kategoriTeam.getId()%>"><%=kategoriTeam.getTeam()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Asal Negara</td>
                    <td><input type="text" name="aslnegara" placeholder="Negara Rider"/></td>
                    <td>Poin Rider</td>
                    <td>
                        <input type="number" name="poin" placeholder="Poin Rider"/>&nbsp;
                        <input type="submit" value="Simpan" />
                    </td>
                </tr>
            </table>
        </form>
        <!--Jadwal Perlombaan-->
        <div id="titeltop">
            <%@include file="includes/jadwal.jsp"%>
        </div>
        <!--End Jadwal Perlombaan-->
    </body>
</html>
