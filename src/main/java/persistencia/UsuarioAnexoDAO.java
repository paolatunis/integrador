package persistencia;

import java.util.List;

import model.Anexo;
import model.Avaliacao;
import model.Usuario;
import model.UsuarioAnexo;
import model.UsuarioAvaliacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioAnexoDAO implements DAO {

	private ConexaoMysql conexao;

	public  UsuarioAnexoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	
	public Object cadastrar(Object o) {
		UsuarioAnexo usuarioAnexo = (UsuarioAnexo)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO usuario_anexo VALUES (null, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setLong(1, usuarioAnexo.getAnexo().getIdAnexo());
			statement.setLong(2, usuarioAnexo.getUsuario().getIdUsuario());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			this.conexao.fecharConexao();
		}
		return usuarioAnexo;
	}


	public void editar(Object o) {
		UsuarioAnexo usuarioAnexo = (UsuarioAnexo)o;
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE usuario_anexo SET  id_anexo=?, id_usuario=? WHERE id_usuario_anexo=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			statement.setLong(1, usuarioAnexo.getAnexo().getIdAnexo());
			statement.setLong(2, usuarioAnexo.getUsuario().getIdUsuario());
			statement.setLong(3, usuarioAnexo.getIdUsuarioAnexo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public void excluir(long o) {
		long idUsuarioAnexo = (long)o;

		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM usuario_anexo WHERE id_usuario_anexo=?;";
	
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idUsuarioAnexo);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}


	public Object buscarPorId(long o) {
		long idUsuarioAnexo = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM usuario_anexo INNER JOIN usuario on usuario_anexo.id_usuario = usuario.id_usuario INNER JOIN anexo on usuario_anexo.id_anexo = anexo.id_anexo WHERE id_usuario_anexo=?;";
		PreparedStatement statement;
		UsuarioAnexo usuarioAnexo = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idUsuarioAnexo);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
		
				usuarioAnexo = new UsuarioAnexo(); 
				usuarioAnexo.setIdUsuarioAnexo(rs.getLong("id_usuario_anexo"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Anexo anexo = new Anexo();
				anexo.setIdAnexo(rs.getLong("id_anexo"));
				anexo.setStatusAnexo(rs.getBoolean("status_anexo"));
				anexo.setLink(rs.getString("link"));
				anexo.setTitulo(rs.getString("titulo"));
				anexo.setTipoAnexo(rs.getString("tipo_anexo"));

				usuarioAnexo.setUsuario(usuario);
				usuarioAnexo.setAnexo(anexo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		
		return usuarioAnexo;
	}


	public List<UsuarioAnexo> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM usuario_anexo INNER JOIN usuario on usuario_anexo.id_usuario = usuario.id_usuario INNER JOIN anexo on usuario_anexo.id_anexo = anexo.id_anexo;";
		PreparedStatement statement;
		UsuarioAvaliacao usuarioAvaliacao = null;
		List<UsuarioAnexo> listaUsuarioAnexo = new ArrayList<UsuarioAnexo>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {    
				UsuarioAnexo usuarioAnexo = new UsuarioAnexo(); 
				usuarioAnexo.setIdUsuarioAnexo(rs.getLong("id_usuario_anexo"));

				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setInfoUsuario(rs.getString("info_usuario"));
				usuario.setFotoPerfil(rs.getString("foto_perfil"));
				usuario.setEmail(rs.getString("email"));

				Anexo anexo = new Anexo();
				anexo.setIdAnexo(rs.getLong("id_anexo"));
				anexo.setStatusAnexo(rs.getBoolean("status_anexo"));
				anexo.setLink(rs.getString("link"));
				anexo.setTitulo(rs.getString("titulo"));
				anexo.setTipoAnexo(rs.getString("tipo_anexo"));

				usuarioAnexo.setUsuario(usuario);
				usuarioAnexo.setAnexo(anexo);

				listaUsuarioAnexo.add(usuarioAnexo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarioAnexo;
	}



}
