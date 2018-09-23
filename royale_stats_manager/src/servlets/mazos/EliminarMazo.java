package servlets.mazos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GestionMazos;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarMazo")
public class EliminarMazo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idMazo = Integer.parseInt(request.getParameter("idMazo"));
		GestionMazos gm = new GestionMazos();
		try {
			gm.eliminarMazo(idMazo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("RecuperarMazos").forward(request, response);
	}

}