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
@WebServlet("/ControladorJugadores")
public class ControladorJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estoy dentro del Controlador de Jugadores");
		
		String op = request.getParameter("op");
		System.out.println("La operación a realizar es " + op);
		
		String url = "";
		
		switch (op) {
		case "doAltaJugador":
			url = "AltaJugador";
			break;
		case "doRecuperarJugadores":
			url = "RecuperarJugadores";
			break;
		case "doEliminarJugador":
			url = "EliminarJugador";
			break;
		case "doToNuevoJugador":
			url = "ToNuevoJugador";
			break;
		}
		
		System.out.println("La url es " + url);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
