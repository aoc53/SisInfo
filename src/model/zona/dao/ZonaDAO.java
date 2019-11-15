package model.zona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.ConnectionManager;
import model.zona.vo.ZonaVO;

/**
 * Clase DAO de gestión de objetos DEMO
 *
 * @author
 */
public class ZonaDAO
{
    private static String findByIdQuery = "SELECT * FROM Zona WHERE id = ?";
    private static String findAll = "SELECT * FROM Zona";

    public ZonaVO findById(int id) {
        ZonaVO result = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findByIdQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            if (rs.first()) {
                result = new ZonaVO(rs.getInt("idZona"),
                        rs.getString("ciudad")
                );
                        //(rs.getInt("id"), rs.getString("name"));
            } else {
                result = null;
            }
            ConnectionManager.releaseConnection(conn);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Devuelve todos los registros de la tabla DEMO
     *
     * @return Lista de todos los registros de la tabla DEMO
     */
    public List<ZonaVO> findAll() {
        List<ZonaVO> result = new ArrayList<ZonaVO>();
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ZonaVO tmp = new ZonaVO(rs.getInt("idZona"),
                        rs.getString("ciudad")
                );
                result.add(tmp);
            }
            ConnectionManager.releaseConnection(conn);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }
}