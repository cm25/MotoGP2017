<%-- 
    Document   : k_team
    Created on : Oct 9, 2017, 11:04:21 AM
    Author     : Calvin Mampioper
--%>

<%@page import="java.util.List"%>
<%@page import="calvin.mpr.motogp2017.dao.KategoriTeamDao"%>
<%@page import="calvin.mpr.motogp2017.bean.KategoriTeam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MotoGP 2017</title>
    </head>
    <body>
        <%
            KategoriTeam ktg = new KategoriTeam();
            KategoriTeamDao kategoriTeamDao = new KategoriTeamDao();
            List<KategoriTeam> kategoriTeams = kategoriTeamDao.getAllTeam();
        %>
        <h1>Kategori</h1>
        <div id="ktgteam">
            <form method="POST" action="ServletProsesKategoriTeam" name="frmAddKteam">
                <table>
                    <input type="hidden" name="action" value="insert_kategori_team" />
                    <tr>
                        <td>Nama Team&nbsp;</td>
                        <td>
                            <input type="hidden" name="id" readonly=""/>
                            <input type="text" name="kteam">&nbsp;
                            <input type="submit" value="Simpan">
                        </td>
                    </tr>

                    <% for (KategoriTeam k : kategoriTeams) {%>
                    <tr>
                        <td></td>
                        <td><%=k.getTeam()%></td>
                        <td>
                            <a href="../ServletProsesKategoriTeam?action=editform&id=<%=k.getId()%>">Edit</a> || 
                            <a href="../ServletProsesKategoriTeam?action=delete_k_team&id=<%=k.getId()%>">Delete</a>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </form>
    </div>
</body>
</html>
<%--<%=k.getTeam()%>--%>