package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Curso;

import java.util.ArrayList;

public class CursoDAO implements DAO{

	private ConexaoMysql conexao;

	public CursoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");

	}

	
	public Object cadastrar(Object o) {
		Curso curso = (Curso)o; 

		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO curso VALUES(null, ?, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setString(1, curso.getNomeCurso());
			statement.setString(2, curso.getTurmas());
			statement.setString(3, curso.getInfoCurso());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return curso;
	}


	public void editar(Object o) {
		Curso curso = (Curso)o;
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE curso SET nome_curso=?, turmas=?, info_curso=? WHERE id_curso=?;";

		try {

			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			
			statement.setString(1, curso.getNomeCurso());
			statement.setString(2, curso.getTurmas());
			statement.setString(3, curso.getInfoCurso());
			statement.setLong(4, curso.getIdCurso());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}



	public void excluir(long o) {
		long idCurso = (long)o;
		
		this.conexao.abrirConexao();
	
		String sqlDelete = "DELETE FROM curso WHERE id_curso=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idCurso);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}


	public Object buscarPorId(long o) {
		long idCurso = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM curso WHERE id_curso=?;";
		PreparedStatement statement;
		Curso curso = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idCurso);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
			
				curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setInfoCurso(rs.getString("info_curso"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return curso;
	}


	
	public List <Curso> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM curso;";
		PreparedStatement statement;
		Curso curso = null;
		List<Curso> listaCursos = new ArrayList<Curso>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
			
				curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));

				listaCursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCursos;
	}

	
	public Curso buscarPorNome(String nome) {
		
		this.conexao.abrirConexao();
	
		String sqlInsert = "SELECT * FROM curso WHERE nome_curso=?";
		PreparedStatement statement;
		Curso curso = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, nome);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				
				curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return curso;
	}




}
