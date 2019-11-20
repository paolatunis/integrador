package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Avaliacao;
import model.Curso;
import model.IfCurso;
import model.InstitutoFederal;
import model.Usuario;
import model.UsuarioAvaliacao;

import java.util.ArrayList;

public class UsuarioAvaliacaoDAO implements DAO {

	private ConexaoMysql conexao;

	public UsuarioAvaliacaoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	public Object cadastrar(Object o) {
		UsuarioAvaliacao usuarioAvaliacao = (UsuarioAvaliacao)o; 
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO usuario_avaliacao VALUES (null, ?, ?);";
		
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setLong(1, usuarioAvaliacao.getUsuario().getIdUsuario());
			statement.setLong(2, usuarioAvaliacao.getAvaliacao().getIdAvaliacao());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return usuarioAvaliacao;
	}

	public void excluir(long o) {
		long idUsuarioAvaliacao = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM usuario_avaliacao WHERE id_usuario_avaliacao=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idUsuarioAvaliacao);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}


	public void editar(Object o) {
		UsuarioAvaliacao usuarioAvaliacao = (UsuarioAvaliacao)o;
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE usuario_avaliacao SET id_usuario=?, id_avaliacao=? WHERE id_usuario_avaliacao=?;";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			
			statement.setLong(1, usuarioAvaliacao.getUsuario().getIdUsuario());
			statement.setLong(2, usuarioAvaliacao.getAvaliacao().getIdAvaliacao());
			statement.setLong(3, usuarioAvaliacao.getIdUsuarioAvaliacao());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}

	
	public Object buscarPorId(long o) {
		long idUsuarioAvaliacao = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM usuario_avaliacao INNER JOIN usuario on usuario_avaliacao.id_usuario = usuario.id_usuario INNER JOIN avaliacao on usuario_avaliacao.id_avaliacao = avaliacao.id_avaliacao WHERE id_usuario_avaliacao=?;";
		PreparedStatement statement;
		UsuarioAvaliacao usuarioAvaliacao = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idUsuarioAvaliacao);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				usuarioAvaliacao = new UsuarioAvaliacao(); 
				usuarioAvaliacao.setIdUsuarioAvaliacao(rs.getLong("id_usuario_avaliacao"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));
				
				usuarioAvaliacao.setUsuario(usuario);
				usuarioAvaliacao.setAvaliacao(avaliacao);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		
		return usuarioAvaliacao;
	}

	public List<UsuarioAvaliacao> buscarTodos() {
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM usuario_avaliacao INNER JOIN usuario on usuario_avaliacao.id_usuario = usuario.id_usuario INNER JOIN avaliacao "
				+ "on usuario_avaliacao.id_avaliacao = avaliacao.id_avaliacao;";
		PreparedStatement statement;
		UsuarioAvaliacao usuarioAvaliacao = null;
		List<UsuarioAvaliacao> listaUsuarioAvaliacao = new ArrayList<UsuarioAvaliacao>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    
				usuarioAvaliacao = new UsuarioAvaliacao(); 
				usuarioAvaliacao.setIdUsuarioAvaliacao(rs.getLong("id_usuario_avaliacao"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				usuarioAvaliacao.setUsuario(usuario);
				usuarioAvaliacao.setAvaliacao(avaliacao);

				listaUsuarioAvaliacao.add(usuarioAvaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarioAvaliacao;
	}
	
	public List<Avaliacao> buscarPorUsuario(long idUsuario) {
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM usuario_avaliacao INNER JOIN usuario on usuario_avaliacao.id_usuario = usuario.id_usuario "
				+ "INNER JOIN avaliacao on usuario_avaliacao.id_avaliacao = avaliacao.id_avaliacao WHERE usuario_avaliacao.id_usuario=?;";
		PreparedStatement statement;
		
		UsuarioAvaliacao usuarioAvaliacao = null;
		List<Avaliacao> listaAvaliacoes = new ArrayList<Avaliacao>();
		
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setLong(1, idUsuario);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    
				usuarioAvaliacao = new UsuarioAvaliacao(); 
				usuarioAvaliacao.setIdUsuarioAvaliacao(rs.getLong("id_usuario_avaliacao"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				usuarioAvaliacao.setUsuario(usuario);
				usuarioAvaliacao.setAvaliacao(avaliacao);

				listaAvaliacoes.add(avaliacao);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAvaliacoes;
	}
	
	
	public List<Avaliacao> buscarPorIdData(long idUsuario, String dataAvaliacao) {
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM usuario_avaliacao INNER JOIN usuario on usuario_avaliacao.id_usuario = usuario.id_usuario INNER JOIN avaliacao "
				+ "on usuario_avaliacao.id_avaliacao = avaliacao.id_avaliacao "
				+ "WHERE usuario_avaliacao.id_usuario=? AND avaliacao.data_avaliacao=?;";

		PreparedStatement statement;
		
		UsuarioAvaliacao usuarioAvaliacao = null;
		List<Avaliacao> listaAvaliacoesIdData = new ArrayList<Avaliacao>();
		
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setLong(1, idUsuario);
			statement.setString(2, dataAvaliacao );
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    
				usuarioAvaliacao = new UsuarioAvaliacao(); 
				usuarioAvaliacao.setIdUsuarioAvaliacao(rs.getLong("id_usuario_avaliacao"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				usuarioAvaliacao.setUsuario(usuario);
				usuarioAvaliacao.setAvaliacao(avaliacao);

				listaAvaliacoesIdData.add(avaliacao);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAvaliacoesIdData;
	}
	

	

}
