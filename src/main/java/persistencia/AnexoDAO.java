package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Anexo;
import model.Avaliacao;
import model.Disciplina;
import model.Usuario;

import java.util.ArrayList;

public class AnexoDAO implements DAO {

	private ConexaoMysql conexao;

	public AnexoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}


	
	public Object cadastrar(Object o) {
		Anexo anexo = (Anexo)o; 
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO anexo VALUES (null, ?, ?, ?, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
		
			statement.setBoolean(1, anexo.getStatusAnexo());
			statement.setString(2, anexo.getLink());
			statement.setString(3, anexo.getTitulo());
			statement.setString(4, anexo.getTipoAnexo());
			statement.setLong(5, anexo.getDisciplina().getIdDisciplina());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return anexo;
	}

	
	public void editar(Object o) {
		Anexo anexo = (Anexo)o;
		
		this.conexao.abrirConexao();
	
		String sqlUpdate = "UPDATE anexo SET status_anexo=?, link=?, titulo=?, tipo_anexo=?, id_disciplina=?  WHERE id_anexo=?;";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
		
			statement.setBoolean(1, anexo.getStatusAnexo());
			statement.setString(2, anexo.getLink());
			statement.setString(3, anexo.getTitulo());
			statement.setString(4, anexo.getTipoAnexo());
			statement.setLong(5, anexo.getDisciplina().getIdDisciplina());
			statement.setLong(6, anexo.getIdAnexo());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public void excluir(long o) {
		long idAnexo = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM anexo WHERE id_anexo=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idAnexo);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public Object buscarPorId(long o) {
		long idAnexo = (long)o;
	
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM anexo INNER JOIN disciplina on anexo.id_disciplina = disciplina.id_disciplina WHERE id_anexo=?;";
		PreparedStatement statement;
		Anexo anexo = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idAnexo);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				anexo = new Anexo();
				anexo.setIdAnexo(rs.getLong("id_anexo"));
				anexo.setStatusAnexo(rs.getBoolean("status_anexo"));
				anexo.setLink(rs.getString("link"));
				anexo.setTitulo(rs.getString("titulo"));
				anexo.setTipoAnexo(rs.getString("tipo_anexo"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				anexo.setDisciplina(disciplina);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return anexo;
	}


	public List <Anexo> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM anexo INNER JOIN disciplina on anexo.id_disciplina = disciplina.id_disciplina;";
		PreparedStatement statement;
		Anexo anexo = null;
		List<Anexo> listaAnexos = new ArrayList<Anexo>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				anexo = new Anexo();
				anexo.setIdAnexo(rs.getLong("id_anexo"));
				anexo.setStatusAnexo(rs.getBoolean("status_anexo"));
				anexo.setLink(rs.getString("link"));
				anexo.setTitulo(rs.getString("titulo"));
				anexo.setTipoAnexo(rs.getString("tipo_anexo"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				anexo.setDisciplina(disciplina);

				listaAnexos.add(anexo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAnexos;
	}



}
