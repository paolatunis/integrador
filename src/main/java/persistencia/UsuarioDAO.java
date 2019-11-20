package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Curso;
import model.Disciplina;
import model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO implements DAO {

	private ConexaoMysql conexao;

	public UsuarioDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	public Object cadastrar(Object o) {
		Usuario usuario = (Usuario)o; 

		this.conexao.abrirConexao();

		String sqlInsert = "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?);";
		try {

			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);

			statement.setString(1, usuario.getNomeUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getInfoUsuario());
			statement.setString(4, usuario.getFotoPerfil());
			statement.setString(5, usuario.getEmail());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}



	public Usuario buscarPorEmailESenha(String email, String senha) {

		this.conexao.abrirConexao();

		String sqlInsert = "SELECT * FROM usuario WHERE email=? AND senha=?;";
		PreparedStatement statement;
		Usuario usuario = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, email);
			statement.setString(2, senha);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}


	public void editar(Object o) {
		Usuario usuario = (Usuario)o;
		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE usuario SET nome_usuario=?, senha=?, info_usuario=?, foto_perfil=?, email=? WHERE id_usuario=?;";

		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);

			statement.setString(1, usuario.getNomeUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getInfoUsuario());
			statement.setString(4, usuario.getFotoPerfil());
			statement.setString(5, usuario.getEmail());
			statement.setLong(6, usuario.getIdUsuario());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public void excluir (long o) {
		long idUsuario = (long)o;

		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM usuario WHERE id_usuario=?;";

		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idUsuario);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}


	}


	public Object buscarPorId(long o) {
		long idUsuario = (long)o;
		
		this.conexao.abrirConexao();
	
		String sqlInsert = "SELECT * FROM usuario WHERE id_usuario=?;";
		PreparedStatement statement;
		Usuario usuario = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idUsuario);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		/////System.out.println(usuario.getNomeUsuario());
		return usuario;
	}



	public List <Usuario> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM usuario;";
		PreparedStatement statement;
		Usuario usuario = null;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}

	
	public  List <Usuario> buscarPorNome(String nome) {
	
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM usuario WHERE nome_usuario=?";
		PreparedStatement statement;
		Usuario usuario = null;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, nome);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("senha"));
				usuario.setSenha(rs.getString("info_usuario"));
				usuario.setInfoUsuario(rs.getString("foto_perfil"));
				usuario.setFotoPerfil(rs.getString("email"));

				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}




}
