/*
 * [Copyrights by Calvin Mampioper alias CM25 - Bali 2016]
 * [Telp/HP : 081353000852]
 * [visit : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.dao;

import calvin.mpr.motogp2017.bean.KategoriTeam;
import calvin.mpr.motogp2017.connection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Calvin Mampioper
 */
public class KategoriTeamDao {
    private final Connection connection;
    
    public KategoriTeamDao(){
        connection = ConnectionDB.getConnectionDB();
    }
    public List getAllTeam() {
        List teams = new ArrayList();
        try {
            String query = "SELECT id,team FROM k_team";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KategoriTeam kategoriTeam = new KategoriTeam();
                kategoriTeam.setId(rs.getInt("id"));
                kategoriTeam.setTeam(rs.getString("team"));
                teams.add(kategoriTeam);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KategoriTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }
    public KategoriTeam getTeamById(int id) {
        KategoriTeam kategoriTeam = new KategoriTeam();
        try {
            String deleteQuery = "SELECT team FROM k_team WHERE id=?";
            PreparedStatement prSt = connection.prepareStatement(deleteQuery);
            prSt.setInt(1, id);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                kategoriTeam.setId(id);
                kategoriTeam.setTeam(rs.getString("team"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kategoriTeam;
    }
    public void addTeams(KategoriTeam kategoriTeam) {
        try {
            String insertQuery = "INSERT INTO k_team(team) VALUES(?)";
            PreparedStatement prSt = connection.prepareStatement(insertQuery);
            prSt.setString(1, kategoriTeam.getTeam());
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void editKategoriTeam(KategoriTeam kategoriTeam) {
        try {
            String editQuery = "UPDATE k_team SET team=? WHERE id=?";
            PreparedStatement prSt = connection.prepareStatement(editQuery);
            prSt.setString(1, kategoriTeam.getTeam());
            prSt.setInt(2, kategoriTeam.getId());
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void deleteDataRidersId(int riderID) {
        try {
            String deleteQuery = "delete from k_team where id=?";
            PreparedStatement prSt = connection.prepareStatement(deleteQuery);
            prSt.setInt(1, riderID);
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
