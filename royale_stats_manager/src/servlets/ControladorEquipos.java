package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ControladorEquipos")
public class ControladorEquipos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String url = "";
		
		switch (op) {
		case "doAltaEquipo":
			url = "AltaEquipo";
			break;
		case "doRecuperarEquipos":
			url = "RecuperarEquipos";
			break;
		case "doEliminarEquipo":
			url = "EliminarEquipo";
			break;
		case "toNuevoEquipo":
			url = "equipos/nuevo_equipo.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}