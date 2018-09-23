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
@WebServlet("/ControladorMazos")
public class ControladorMazos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String url = "";
		
		switch (op) {
		case "doAltaMazo":
			url = "AltaMazo";
			break;
		case "doRecuperarMazos":
			url = "RecuperarMazos";
			break;
		case "doEliminarMazo":
			url = "EliminarMazo";
			break;
		case "doToNuevoMazo":
			url = "ToNuevoMazo";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}