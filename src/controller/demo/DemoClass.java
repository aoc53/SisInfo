package controller.demo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.demo.dao.DemoDAO;
import model.demo.vo.DemoVO;

public class DemoClass  extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        // Llamada al metodo post
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        try {
            List<DemoVO> lista = new DemoDAO().findAll();
            System.out.println(lista.get(1).getName());
            request.setAttribute("listaDemo", lista);
            request.getRequestDispatcher("listaDemo.jsp").forward(request, response);
        }catch(Throwable theException) {
        }
    }
}
