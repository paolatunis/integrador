package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Curso;
import model.Disciplina;
import model.InstitutoFederal;
import model.Telefone;

import java.util.ArrayList;

public class DisciplinaDAO implements DAO {

	private ConexaoMysql conexao;

	public DisciplinaDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "agendif");

	}


	public Object cadastrar(Object o) {
		Disciplina disciplina = (Disciplina)o;

		this.conexao.abrirConexao();

		String sqlInsert = "INSERT INTO disciplina VALUES (null, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlInsert);

			statement.setString(1, disciplina.getNomeDisciplina());
			statement.setString(2, disciplina.getTurmaDisciplina());
			statement.setInt(3, disciplina.getAno());
			statement.setDouble(4, disciplina.getMediaNota());
			statement.setString(5, disciplina.getProfessor());
			statement.setDouble(6, disciplina.getNotaExtra());
			statement.setLong(7, disciplina.getCurso().getIdCurso());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.conexao.fecharConexao();
		}
		return disciplina;
	}


	public void editar(Object o) { 
		Disciplina disciplina = (Disciplina)o;
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE disciplina SET nome_disciplina=?, turma_disciplina=?, ano=?, media_nota=?, professor=?, nota_extra=?, id_curso=? WHERE id_disciplina=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			statement.setString(1, disciplina.getNomeDisciplina());
			statement.setString(2,disciplina.getTurmaDisciplina());
			statement.setInt(3,disciplina.getAno());
			statement.setFloat(4,(float) disciplina.getMediaNota());
			statement.setString(5,disciplina.getProfessor());
			statement.setFloat(6,(float) disciplina.getNotaExtra());
			statement.setLong(7, disciplina.getCurso().getIdCurso());
			statement.setLong(8, disciplina.getIdDisciplina());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}


	public void excluir(long o) {
		long idDisciplina = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM disciplina WHERE id_disciplina=?;";
		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idDisciplina);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}


	}



	public Object buscarPorId(long o) {
		long idDisciplina = (long)o;
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM disciplina INNER JOIN curso on disciplina.id_curso = curso.id_curso WHERE id_disciplina=?;";
		PreparedStatement statement;
		Disciplina disciplina = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, idDisciplina);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));
				disciplina.setCurso(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		
		return disciplina;
	}


	public List <Disciplina> buscarTodos() {
		
		this.conexao.abrirConexao();
		
		String sqlSelect = "SELECT * FROM disciplina INNER JOIN curso on disciplina.id_curso = curso.id_curso;";
		PreparedStatement statement;
		Disciplina disciplina = null;
		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));
				disciplina.setCurso(curso);

				listaDisciplinas.add(disciplina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDisciplinas;
	}


	public List <Disciplina> buscarPorNome(String nome) {
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM disciplina INNER JOIN curso on disciplina.id_curso = curso.id_curso WHERE nome_disciplina=?;";
		PreparedStatement statement;
		Disciplina disciplina = null;
		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, nome);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
				disciplina.setTurmaDisciplina(rs.getString("turma_disciplina"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setMediaNota((float) rs.getFloat("media_nota"));
				disciplina.setProfessor(rs.getString("professor"));
				disciplina.setNotaExtra((float) rs.getFloat("nota_extra"));

				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setTurmas(rs.getString("turmas"));
				curso.setInfoCurso(rs.getString("info_curso"));
				disciplina.setCurso(curso);

				listaDisciplinas.add(disciplina);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

		return listaDisciplinas;
	}
	public List <Disciplina> MostrarNomeTurma(String nome) {
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM disciplina INNER JOIN curso on disciplina.id_curso = curso.id_curso WHERE nome_disciplina=?;";


		return null;

	}




}
