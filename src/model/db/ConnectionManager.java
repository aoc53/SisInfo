package model.db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
    // Devuelve la conexion, para no tener que abrirla y cerrarla siempre.
    public final static Connection getConnection() throws SQLException {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            System.out.println(envCtx.toString());
            DataSource ds = (DataSource)envCtx.lookup("jdbc/sisinfDB");
            System.out.println(ds.toString());
            Connection conn = ds.getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Libera la conexion, devolviendola al pool
    public final static void releaseConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
