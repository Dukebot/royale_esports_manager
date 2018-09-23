package servlets.mazos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Carta;
import entities.Mazo;
import model.GestionCartas;
import model.GestionMazos;

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
		
		Mazo m = new Mazo();
		GestionCartas gc = new GestionCartas();
		GestionMazos gm = new GestionMazos();	
		
		//m.setNombre(request.getParameter("nombre"));
		
		List<Carta> lc = gc.recuperarCartas();
		int i = 0;
		for (Carta c : lc) {
			String marcada = request.getParameter(""+c.getId());
			if (marcada != null && marcada.equals("true")) {
				i++;
				if (i <= 8) {
					if 		(i == 1) m.setCarta1(c);
					else if (i == 2) m.setCarta2(c);
					else if (i == 3) m.setCarta3(c);
					else if (i == 4) m.setCarta4(c);
					else if (i == 5) m.setCarta5(c);
					else if (i == 6) m.setCarta6(c);
					else if (i == 7) m.setCarta7(c);
					else if (i == 8) m.setCarta8(c);
				}

			}
		}
		
		gm.altaMazo(m);
		List<Mazo> lm = gm.recuperarMazos();
		
		request.setAttribute("mazos", lm);
		request.getRequestDispatcher("mazos/ver_mazos.jsp").forward(request, response);
	}
}
