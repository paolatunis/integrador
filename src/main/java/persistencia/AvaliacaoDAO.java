package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Avaliacao;
import model.Curso;
import model.Disciplina;
import model.Usuario;

import java.util.ArrayList;

public class AvaliacaoDAO implements DAO {

	private ConexaoMysql conexao;

	public AvaliacaoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");
	}

	public Object cadastrar(Object o) {
		Avaliacao avaliacao = (Avaliacao)o; 

		this.conexao.abrirConexao();
	
		String sqlInsert = "INSERT INTO avaliacao VALUES(null, ?, ?, ?, ?, ?, ?, ?);";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);
			
			statement.setString(1, avaliacao.getTipoAvaliacao());
			statement.setFloat(2, avaliacao.getNotaAvaliacao());
			statement.setFloat(3, avaliacao.getPesoAvaliacao());
			statement.setString(4, avaliacao.getDataAvaliacao());
			statement.setString(5, avaliacao.getMaterial());
			statement.setString(6, avaliacao.getConteudo());
			statement.setLong(7, avaliacao.getDisciplina().getIdDisciplina());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.conexao.fecharConexao();
		}
		return avaliacao;
	}


	public void editar(Object o) {
		Avaliacao avaliacao = (Avaliacao)o;
		
		this.conexao.abrirConexao();
	
		String sqlUpdate = "UPDATE avaliacao SET tipo_avaliacao=?, nota_avaliacao=?, peso_avaliacao=?, data_avaliacao=?, material=?, conteudo=?, id_disciplina=? WHERE id_avaliacao=?;";
		try {
			
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			statement.setString(1, avaliacao.getTipoAvaliacao());
			statement.setFloat(2, (float) avaliacao.getNotaAvaliacao());
			statement.setFloat(3, (float) avaliacao.getPesoAvaliacao());
			statement.setString(4, avaliacao.getDataAvaliacao());
			statement.setString(5, avaliacao.getMaterial());
			statement.setString(6, avaliacao.getConteudo());
			statement.setLong(7, avaliacao.getDisciplina().getIdDisciplina());
			statement.setLong(8, avaliacao.getIdAvaliacao());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}

	public void excluir(long o) {
		long idAvaliacao = (long)o;
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM avaliacao WHERE id_avaliacao=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idAvaliacao);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}


	}
	
	public Object buscarPorId(long o) {
		long idAvaliacao = (long)o;
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM avaliacao INNER JOIN disciplina on avaliacao.id_disciplina = disciplina.id_disciplina "
				+ "WHERE id_avaliacao=?;";
		PreparedStatement statement;
		Avaliacao avaliacao = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idAvaliacao);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				avaliacao.setDisciplina(disciplina);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return avaliacao;
	}


	public List <Avaliacao> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM avaliacao INNER JOIN disciplina on avaliacao.id_disciplina = disciplina.id_disciplina;";
		PreparedStatement statement;
		Avaliacao avaliacao = null;
		List<Avaliacao> listaAvaliacoes = new ArrayList<Avaliacao>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				avaliacao.setDisciplina(disciplina);

				listaAvaliacoes.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAvaliacoes;
	}


	public  List <Avaliacao> buscarPorTipo(String tipo) {
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM avaliacao WHERE tipo_avaliacao=?";
		PreparedStatement statement;
		Avaliacao avaliacao = null;
		List <Avaliacao> listaAvaliacao = new ArrayList<Avaliacao>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, tipo);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getLong("id_avaliacao"));
				avaliacao.setTipoAvaliacao(rs.getString("tipo_avaliacao"));
				avaliacao.setNotaAvaliacao(rs.getFloat("nota_avaliacao"));
				avaliacao.setPesoAvaliacao(rs.getFloat("peso_avaliacao"));
				avaliacao.setDataAvaliacao(rs.getString("data_avaliacao"));
				avaliacao.setMaterial(rs.getString("material"));
				avaliacao.setConteudo(rs.getString("conteudo"));

				listaAvaliacao.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAvaliacao;
	}



}
