package servlets.cartas;

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
@WebServlet("/AltaCarta")
public class AltaCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		int coste = Integer.parseInt( request.getParameter("coste") );
		
		Carta c = new Carta();
		GestionCartas gCartas = new GestionCartas();
		
		c.setNombre(nombre);
		c.setCoste(coste);
		
		gCartas.altaCarta(c);
		
		request.setAttribute("cartas", gCartas.recuperarCartas());
		request.getRequestDispatcher("cartas/ver_cartas.jsp").forward(request, response);
	}
}
