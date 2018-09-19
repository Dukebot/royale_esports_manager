package servlets.mazos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Carta;
import model.GestionCartas;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaMazo")
public class AltaMazo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int coste = Integer.parseInt( request.getParameter("coste") );
		
		Carta c = new Carta(nombre, coste);
		GestionCartas gCartas = new GestionCartas();
		
		gCartas.altaCarta(c);
		request.getRequestDispatcher("menu_principal.html").forward(request, response);
	}
}
