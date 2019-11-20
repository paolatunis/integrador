package model;

import java.util.List;
import java.util.ArrayList;

public class Disciplina {

	private long idDisciplina;
	private String nomeDisciplina;
	private String turmaDisciplina;
	private int ano;
	private float mediaNota;
	private String professor;
	private float notaExtra;

	private Curso curso;
	private List<Anexo> listaAnexos;
	private List<DisciplinaUsuario> listaDisciplinaUsuario;
	private List<Avaliacao> listaAvaliacao;

	public Disciplina() {
		super();
	}

	public Disciplina(long idDisciplina, String nomeDisciplina, String turmaDisciplina, int ano, float mediaNota,
			String professor, float notaExtra, Curso curso, List<Anexo> listaAnexos,
			List<DisciplinaUsuario> listaDisciplinaUsuario, List<Avaliacao> listaAvaliacao) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.turmaDisciplina = turmaDisciplina;
		this.ano = ano;
		this.mediaNota = mediaNota;
		this.professor = professor;
		this.notaExtra = notaExtra;

		this.curso = curso;
		this.listaAnexos = listaAnexos;
		this.listaDisciplinaUsuario = listaDisciplinaUsuario;
		this.listaAvaliacao = listaAvaliacao;
	}

	public long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getTurmaDisciplina() {
		return turmaDisciplina;
	}

	public void setTurmaDisciplina(String turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getMediaNota() {
		return mediaNota;
	}

	public void setMediaNota(float mediaNota) {
		this.mediaNota = mediaNota;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public float getNotaExtra() {
		return notaExtra;
	}

	public void setNotaExtra(float notaExtra) {
		this.notaExtra = notaExtra;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Anexo> getListaAnexos() {
		return listaAnexos;
	}

	public void setListaAnexos(List<Anexo> listaAnexos) {
		this.listaAnexos = listaAnexos;
	}

	public List<DisciplinaUsuario> getListaDisciplinaUsuario() {
		return listaDisciplinaUsuario;
	}

	public void setListaDisciplinaUsuario(List<DisciplinaUsuario> listaDisciplinaUsuario) {
		this.listaDisciplinaUsuario = listaDisciplinaUsuario;
	}

	public List<Avaliacao> getListaAvaliacao() {
		return listaAvaliacao;
	}

	public void setListaAvaliacao(List<Avaliacao> listaAvaliacao) {
		this.listaAvaliacao = listaAvaliacao;
	}
	
	

}
