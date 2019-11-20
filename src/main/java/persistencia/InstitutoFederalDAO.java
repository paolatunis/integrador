package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Curso;
import model.InstitutoFederal;

import java.util.ArrayList;


public class InstitutoFederalDAO implements DAO {

	private ConexaoMysql conexao;

	public InstitutoFederalDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");

	}

	public Object cadastrar(Object o) {
		InstitutoFederal institutoFederal = (InstitutoFederal)o; 

	
		this.conexao.abrirConexao();
		
		String sqlInsert = "INSERT INTO instituto_federal VALUES(null, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			statement.setString(1, institutoFederal.getCampus());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return institutoFederal;
	}


	public void editar(Object o) {
		InstitutoFederal institutoFederal = (InstitutoFederal)o;
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE instituto_federal SET campus=? WHERE id_if=?;";

		try {
			// DECLARA E INICIALIZA UM STATEMENT, OBJETO USADO PARA PREPARAR O
			// SQL � SER EXECUTADO
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			// SUBSTITUIR AS INTERROGA��ES PELOS VALORES QUE EST�O NO OBJETO
			// USU�RIO
			statement.setString(1, institutoFederal.getCampus());
			statement.setLong(2, institutoFederal.getIdIf());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}


	}

	
	public void excluir(long o) {
		long idIf = (long)o;
		
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM instituto_federal WHERE id_if=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idIf);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	
	public Object buscarPorId(long o) {
		long idIf = (long)o;
		this.conexao.abrirConexao();
	
		String sqlInsert = "SELECT * FROM instituto_federal WHERE id_if=?;";
		PreparedStatement statement;
		InstitutoFederal institutoFederal = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idIf);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {

				institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return institutoFederal;
	}

		
	
	public List <InstitutoFederal> buscarTodos() {
		// ABRIR A CONEXÃO COM O BANCO
		this.conexao.abrirConexao();
		// SQL COM A OPERAÇÃO QUE DESEJA-SE REALIZAR
		String sqlSelect = "SELECT * FROM instituto_federal;";
		PreparedStatement statement;
		InstitutoFederal institutoFederal = null;
		List<InstitutoFederal> listaInstitutoFederal = new ArrayList<InstitutoFederal>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));
				listaInstitutoFederal.add(institutoFederal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaInstitutoFederal;
	}
	
	
	public InstitutoFederal buscarPorCampus(String campus) {
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM instituto_federal WHERE campus=?";
		PreparedStatement statement;
		InstitutoFederal institutoFederal = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, campus);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				
				institutoFederal = new InstitutoFederal();
				institutoFederal.setIdIf(rs.getLong("id_if"));
				institutoFederal.setCampus(rs.getString("campus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return institutoFederal;
	}
	
	

}
