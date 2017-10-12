/*
 * [Copyrights by Calvin Mampioper - Tangerang Selatan, Ciputat 2017]
 * [Telp/HP : 081353000852, 081322631783]
 * [visit   : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.dao;

import calvin.mpr.motogp2017.bean.DataRider;
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
public class DataRiderDao {
    private final Connection connection;
    
    public DataRiderDao() {
        connection = ConnectionDB.getConnectionDB();
    }
    public void addRider(DataRider dataRider) {
        try {
            String insertQuery = "INSERT INTO t_data_riders(nmrider, norider, fk_team, aslnegara, poin)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement prSt = connection.prepareStatement(insertQuery);
            prSt.setString(1, dataRider.getNama());
            prSt.setInt(2, dataRider.getNomor());
            prSt.setString(3, dataRider.getTeam());
            prSt.setString(4, dataRider.getNegara());
            prSt.setInt(5, dataRider.getPoin());
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteDataRidersId(int riderID) {
        try {
            String deleteQuery = "delete from t_data_riders where idrider=?";
            PreparedStatement prSt = connection.prepareStatement(deleteQuery);
            prSt.setInt(1, riderID);
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DataRider findRidersById(int riderID) {
        DataRider dataRiders = new DataRider();
        try {
            String deleteQuery = "SELECT nmrider, norider, fk_team, aslnegara, poin "
                    + "FROM t_data_riders where idrider=?";
            PreparedStatement prSt = connection.prepareStatement(deleteQuery);
            prSt.setInt(1, riderID);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                dataRiders.setId(riderID);
                dataRiders.setNama(rs.getString("nmrider"));
                dataRiders.setNomor(rs.getInt("norider"));
                dataRiders.setTeam(rs.getString("fk_team"));
                dataRiders.setNegara(rs.getString("aslnegara"));
                dataRiders.setPoin(rs.getInt("poin"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dataRiders;
    }

    public void editDataRiders(DataRider dataRiders) {
        try {
            String editQuery = "UPDATE t_data_riders set nmrider=?, norider=?, fk_team=?, aslnegara=?, poin=?"
                    + " WHERE idrider=?";
            PreparedStatement prSt = connection.prepareStatement(editQuery);
            prSt.setString(1, dataRiders.getNama());
            prSt.setInt(2, dataRiders.getNomor());
            prSt.setString(3, dataRiders.getTeam());
            prSt.setString(4, dataRiders.getNegara());
            prSt.setInt(5, dataRiders.getPoin());
            prSt.setInt(6, dataRiders.getId());
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List getAllRiders() {
        List riders = new ArrayList();
        try {
            String query = "SELECT idrider, nmrider, norider, k_team.team, aslnegara, poin "
                    + "FROM t_data_riders, k_team WHERE fk_team=k_team.id ORDER BY nmrider ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DataRider dataRiders = new DataRider();
                dataRiders.setId(rs.getInt("idrider"));
                dataRiders.setNama(rs.getString("nmrider"));
                dataRiders.setNomor(rs.getInt("norider"));
                dataRiders.setTeam(rs.getString("k_team.team"));
                dataRiders.setNegara(rs.getString("aslnegara"));
                dataRiders.setPoin(rs.getInt("poin"));
                riders.add(dataRiders);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataRiderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return riders;
    }
}
