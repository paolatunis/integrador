package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.InstitutoFederal;
import model.Telefone;
import model.Usuario;

import java.util.ArrayList;

public class TelefoneDAO implements DAO {

	private ConexaoMysql conexao;

	public TelefoneDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	
	public Object cadastrar(Object o) {
		Telefone telefone = (Telefone)o;

		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO telefone VALUES(null, ?, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setString(1, telefone.getDescricaoDep());
			statement.setString(2, telefone.getNumero());
			statement.setLong(3, telefone.getInstitutoFederal().getIdIf());

			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return telefone;
	}


	public void editar(Object o) { 
		Telefone telefone = (Telefone)o;
		
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE telefone SET descricao_dep=?, numero=?, id_if=? WHERE id_telefone=?;";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			
			statement.setString(1, telefone.getDescricaoDep());
			statement.setString(2, telefone.getNumero());
			statement.setLong(3, telefone.getInstitutoFederal().getIdIf());
			statement.setLong(4, telefone.getIdTelefone());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public void excluir (long o) { ////////////////OK
		long idTelefone = (long)o;
	
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM telefone WHERE id_telefone=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idTelefone);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}


	}


	public Object buscarPorId(long o) {
		long idTelefone = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM telefone INNER JOIN instituto_federal on telefone.id_if = instituto_federal.id_if  WHERE id_telefone=?;";
		PreparedStatement statement;
		Telefone telefone = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idTelefone);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
			
				telefone = new Telefone();
				telefone.setIdTelefone(rs.getLong("id_telefone"));
				telefone.setDescricaoDep(rs.getString("descricao_dep"));
				telefone.setNumero(rs.getString("numero"));

				InstitutoFederal institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));

				telefone.setInstitutoFederal(institutoFederal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return telefone;
	}





	public List <Telefone> buscarTodos() {
		
		this.conexao.abrirConexao();
	
		String sqlSelect = "SELECT * FROM telefone INNER JOIN instituto_federal on telefone.id_if = instituto_federal.id_if;";
		PreparedStatement statement;
		Telefone telefone = null;
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				telefone = new Telefone();
				telefone.setIdTelefone(rs.getLong("id_telefone"));
				telefone.setDescricaoDep(rs.getString("descricao_dep"));
				telefone.setNumero(rs.getString("numero"));

				InstitutoFederal institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));

				telefone.setInstitutoFederal(institutoFederal);
				listaTelefones.add(telefone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaTelefones;
	}




}