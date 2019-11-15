package model.articulo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.ConnectionManager;
import model.articulo.vo.ArticuloVO;

/**
 * Clase DAO de gestión de objetos DEMO
 *
 * @author
 */
public class ArticuloDAO
{
    private static String findByIdQuery = "SELECT * FROM Articulo WHERE id = ?";
    private static String findAll = "SELECT * FROM Articulo";

    public ArticuloVO findById(int id) {
        ArticuloVO result = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findByIdQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            if (rs.first()) {
                result = new ArticuloVO(rs.getInt("idArticulo"),
                        rs.getString("contenido"),
                        rs.getString("titulo")
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
    public List<ArticuloVO> findAll() {
        List<ArticuloVO> result = new ArrayList<ArticuloVO>();
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArticuloVO tmp = new ArticuloVO(rs.getInt("idArticulo"),
                        rs.getString("contenido"),
                        rs.getString("titulo")
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