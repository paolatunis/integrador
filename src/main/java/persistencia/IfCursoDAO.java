package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Anexo;
import model.Curso;
import model.Disciplina;
import model.IfCurso;
import model.InstitutoFederal;
import model.Usuario;

import java.util.ArrayList;

public class IfCursoDAO implements DAO {

	private ConexaoMysql conexao;

	public IfCursoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}


	public Object cadastrar(Object o) {
		IfCurso  ifCurso = (IfCurso)o;

		this.conexao.abrirConexao();
	
		String sqlInsert = "INSERT INTO if_curso VALUES (null, ?, ?);";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setLong(1, ifCurso.getInstitutoFederal().getIdIf());
			statement.setLong(2, ifCurso.getCurso().getIdCurso());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return ifCurso;
	}


	public void editar(Object o) {
		IfCurso  ifCurso = (IfCurso)o;

		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE if_curso SET id_if=?, id_curso=? WHERE id_if_curso=?;";
		try {

			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			statement.setLong(1, ifCurso.getInstitutoFederal().getIdIf());
			statement.setLong(2, ifCurso.getCurso().getIdCurso());
			statement.setLong(3, ifCurso.getIdIfCurso());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}

	public void excluir(long o) {
		long idIfCurso = (long)o;
	
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM if_curso WHERE id_if_curso=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idIfCurso);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}

	public Object buscarPorId(long o) {
		long idIfCurso = (long)o;

		this.conexao.abrirConexao();

		String sqlInsert = "SELECT * FROM if_curso INNER JOIN instituto_federal on if_curso.id_if = instituto_federal.id_if INNER JOIN curso on if_curso.id_curso = curso.id_curso WHERE id_if_curso=?;";
		PreparedStatement statement;
		IfCurso ifCurso = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idIfCurso);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				ifCurso = new IfCurso(); 
				ifCurso.setIdIfCurso(rs.getLong("id_if_curso"));

				InstitutoFederal institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));

				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));
				
				ifCurso.setInstitutoFederal(institutoFederal);
				ifCurso.setCurso(curso);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	
		return ifCurso;
	}



	public List<IfCurso> buscarTodos() {

		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM if_curso INNER JOIN instituto_federal on if_curso.id_if = instituto_federal.id_if INNER JOIN curso on if_curso.id_curso = curso.id_curso;";
		PreparedStatement statement;
		IfCurso ifCurso = null;
		List<IfCurso> listaifCurso = new ArrayList<IfCurso>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				ifCurso = new IfCurso(); 
				ifCurso.setIdIfCurso(rs.getLong("id_if_curso"));

				InstitutoFederal institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));

				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));

				ifCurso.setInstitutoFederal(institutoFederal);
				ifCurso.setCurso(curso);

				listaifCurso.add(ifCurso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaifCurso;
	}




}
