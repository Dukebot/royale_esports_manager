package servlets.cartas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ControladorCartas")
public class ControladorCartas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String url = "";
		
		switch (op) {
		case "doAltaCarta":
			url = "AltaCarta";
			break;
		case "doRecuperarCartas":
			url = "RecuperarCartas";
			break;
		case "doEliminarCarta":
			url = "EliminarCarta";
			break;
		case "toNuevaCarta":
			url = "cartas/nueva_carta.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}