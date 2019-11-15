package model.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.ConnectionManager;
import model.user.vo.UserVO;

/**
 * Clase DAO de gestión de objetos DEMO
 *
 * @author
 */
public class UserDAO
{
    private static String findByIdQuery = "SELECT * FROM Usuario WHERE id = ?";
    private static String findAll = "SELECT * FROM Usuario";

    public UserVO findById(int id) {
        UserVO result = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findByIdQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            if (rs.first()) {
                result = new UserVO(rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fechaNacimiento"),
                        rs.getString("contrasenya")
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
    public List<UserVO> findAll() {
        List<UserVO> result = new ArrayList<UserVO>();
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserVO tmp = new UserVO(rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fechaNacimiento"),
                        rs.getString("contrasenya")
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