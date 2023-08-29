package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.entidade.Carros;
import br.edu.ifgoiano.repositorio.CarrosRepositorio;

@WebServlet("/alterarCarros")
public class AlterarCarrosServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Carros carros = new Carros();
		
		carros.setId(id);
		carros.setCor(req.getParameter("corAtualizar"));
		carros.setPlaca(req.getParameter("placaAtualizar"));
		carros.setMarca(req.getParameter("marcaAtualizar"));
		
		CarrosRepositorio repositorio = new CarrosRepositorio();
		repositorio.alterarCarros(carros);
		
		resp.sendRedirect("cadastrarCarros");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		CarrosRepositorio repositorio = new CarrosRepositorio();
	
		req.setAttribute("carro", repositorio.obterCarros(id));
		
		req.getRequestDispatcher("atualizarCarros.jsp").forward(req, resp);;
	}
}
