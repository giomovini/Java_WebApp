package br.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.dao.conexao.Conexao;
import br.fiap.modelo.Departamento;
import br.fiap.modelo.Empregado;

public class EmpregadoDAO extends DAO {

	// método para retornar os dados do empregado
	public List<Empregado> listar() {
		List<Empregado> lista = new ArrayList<Empregado>();
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		Departamento departamento;
		Empregado empregado;
		
		sql = "select E.nome, E.cpf, D.nome as dnome from java_empregado E, "
				+ "java_departamento D where E.id_departamento = D.id order by E.nome";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				departamento = new Departamento();
				departamento.setNome(rs.getString("dnome"));
				empregado = new Empregado();
				empregado.setCpf(rs.getString("cpf"));
				empregado.setNome(rs.getString("nome"));
				empregado.setDepartamento(departamento);
				lista.add(empregado);
			}
			ps.close();
			conexao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public void inserir(Empregado empregado) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql="insert into java_empregado values(empregado_sequence.nextval, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, empregado.getDepartamento().getId());
			ps.setString(2, empregado.getNome());
			ps.setString(3, empregado.getCpf());
			
			ps.execute();
			ps.close();
			conexao.desconectar();
			} catch (SQLException e) {
			System.out.println("erro ao inserir empregado\n" + e);
		}
	}
}
