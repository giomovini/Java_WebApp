package br.fiap.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.EmpregadoDAO;
import br.fiap.modelo.Departamento;
import br.fiap.modelo.Empregado;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Departamento departamento = new Departamento();
		Empregado empregado = new Empregado();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		Integer id = Integer.parseInt(request.getParameter("departamento"));
		
		departamento.setId(id);
		empregado.setNome(nome);
		empregado.setCpf(cpf);
		
		empregado.setDepartamento(departamento);
		
		new EmpregadoDAO().inserir(empregado);
		
		response.sendRedirect("index.jsp");
	}

}
