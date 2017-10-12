<%-- 
    Document   : jadwal
    Created on : Oct 9, 2017, 1:17:05 PM
    Author     : Calvin Mampioper
--%>
<hr>
<p align="center"><strong>Add New Record [Jadwal]</strong></p>
<%
    String[] titel = {"Tanggal", "Sirkuit", "Negara", "Control"};
%>
<div align="center">
    <form>
        <input type="text" placeholder="Tanggal" name="tgl">&nbsp;&nbsp;
        <select name="sirkuit">
            <option>Silver Stone</option>
        </select>&nbsp;&nbsp;
        <input type="text" placeholder="Negara" name="tgl">&nbsp;&nbsp;
        <input type="submit" value="Simpan">
    </form>
</div>
<table align="center">
    <tr>
        <% for (int i = 0; i < titel.length; i++) {
                out.println("<th align=\"left\" width=\"20%\"><br>" + titel[i] + "</th>");
            }
        %>
    </tr>
</table>
