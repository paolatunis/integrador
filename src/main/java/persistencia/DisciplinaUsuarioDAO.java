package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Anexo;
import model.Avaliacao;
import model.Disciplina;
import model.DisciplinaUsuario;
import model.Usuario;
import model.UsuarioAnexo;
import model.UsuarioAvaliacao;

public class DisciplinaUsuarioDAO implements DAO {

	private ConexaoMysql conexao;

	public  DisciplinaUsuarioDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	public Object cadastrar(Object o) {
		DisciplinaUsuario disciplinaUsuario = (DisciplinaUsuario)o;

		this.conexao.abrirConexao();

		String sqlInsert = "INSERT INTO disciplina_usuario VALUES (null, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);

			statement.setLong(1, disciplinaUsuario.getDisciplina().getIdDisciplina());
			statement.setLong(2, disciplinaUsuario.getUsuario().getIdUsuario());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return disciplinaUsuario;
	}


	public void editar(Object o) {
		DisciplinaUsuario disciplinaUsuario = (DisciplinaUsuario)o;

		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE disciplina_usuario SET id_disciplina=?, id_usuario=? WHERE id_disciplina_usuario=?;";
		try {

			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);

			statement.setLong(1, disciplinaUsuario.getDisciplina().getIdDisciplina());
			statement.setLong(2, disciplinaUsuario.getUsuario().getIdUsuario());
			statement.setLong(3, disciplinaUsuario.getIdDiscipinaUsuario());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long o) {
		long IdDisciplinaUsuario = (long)o;

		this.conexao.abrirConexao();

		String sqlDelete = "DELETE FROM disciplina_usuario WHERE id_disciplina_usuario=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, IdDisciplinaUsuario);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}


	public Object buscarPorId(long o) {
		long idDisciplinaUsuario = (long)o;

		this.conexao.abrirConexao();

		String sqlInsert = "SELECT * FROM disciplina_usuario INNER JOIN disciplina on disciplina_usuario.id_disciplina = disciplina.id_disciplina INNER JOIN usuario on disciplina_usuario.id_usuario = usuario.id_usuario WHERE id_disciplina_usuario=?;";
		PreparedStatement statement;
		DisciplinaUsuario disciplinaUsuario  = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idDisciplinaUsuario );
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {

				disciplinaUsuario = new DisciplinaUsuario (); 
				disciplinaUsuario.setIdDiscipinaUsuario (rs.getLong("id_disciplina_usuario"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				disciplinaUsuario.setDisciplina(disciplina);
				disciplinaUsuario.setUsuario(usuario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return disciplinaUsuario;
	}


	public List<DisciplinaUsuario> buscarTodos() {

		this.conexao.abrirConexao();

		String sqlSelect = "SELECT * FROM disciplina_usuario INNER JOIN disciplina on disciplina_usuario.id_disciplina = disciplina.id_disciplina INNER JOIN usuario on disciplina_usuario.id_usuario = usuario.id_usuario;";
		PreparedStatement statement;
		DisciplinaUsuario disciplinaUsuario = null;
		List<DisciplinaUsuario> listaDisciplinaUsuario = new ArrayList<DisciplinaUsuario>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    

				disciplinaUsuario = new DisciplinaUsuario (); 
				disciplinaUsuario.setIdDiscipinaUsuario (rs.getLong("id_disciplina_usuario"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				disciplinaUsuario.setDisciplina(disciplina);
				disciplinaUsuario.setUsuario(usuario);

				listaDisciplinaUsuario.add(disciplinaUsuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDisciplinaUsuario;
	}



	public List<Disciplina> buscarPorUsuario(long idUsuario) {
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM disciplina_usuario INNER JOIN usuario on disciplina_usuario.id_usuario = usuario.id_usuario "
				+ "INNER JOIN disciplina on disciplina_usuario.id_disciplina = disciplina.id_disciplina WHERE disciplina_usuario.id_usuario=?;";
		PreparedStatement statement;

		DisciplinaUsuario disciplinaUsuario = null;
		List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();

		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setLong(1, idUsuario);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    
				disciplinaUsuario = new DisciplinaUsuario(); 
				disciplinaUsuario.setIdDiscipinaUsuario(rs.getLong("id_disciplina_usuario"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				disciplinaUsuario.setDisciplina(disciplina);
				disciplinaUsuario.setUsuario(usuario);

				listaDisciplina.add(disciplina);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDisciplina;
	}




}
