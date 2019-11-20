package model;

import java.sql.Date;
import java.util.List;

public class Avaliacao {

	private long idAvaliacao;
	private String tipoAvaliacao;
	private float notaAvaliacao;
	private float pesoAvaliacao;
	private String dataAvaliacao;
	private String material;
	private String conteudo;

	private Disciplina disciplina;
	private List<UsuarioAvaliacao> listaUsuarioAvaliacao;

	public Avaliacao() {
		super();
	}

	public Avaliacao(long idAvaliacao, String tipoAvaliacao, float notaAvaliacao, float pesoAvaliacao,
			String dataAvaliacao, String material, String conteudo, Disciplina disciplina,
			List<UsuarioAvaliacao> listaUsuarioAvaliacao) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.tipoAvaliacao = tipoAvaliacao;
		this.notaAvaliacao = notaAvaliacao;
		this.pesoAvaliacao = pesoAvaliacao;
		this.dataAvaliacao = dataAvaliacao;
		this.material = material;
		this.conteudo = conteudo;
		this.disciplina = disciplina;
		this.listaUsuarioAvaliacao = listaUsuarioAvaliacao;
	}

	public long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public float getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(float notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public float getPesoAvaliacao() {
		return pesoAvaliacao;
	}

	public void setPesoAvaliacao(float pesoAvaliacao) {
		this.pesoAvaliacao = pesoAvaliacao;
	}

	public String getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<UsuarioAvaliacao> getListaUsuarioAvaliacao() {
		return listaUsuarioAvaliacao;
	}

	public void setListaUsuarioAvaliacao(List<UsuarioAvaliacao> listaUsuarioAvaliacao) {
		this.listaUsuarioAvaliacao = listaUsuarioAvaliacao;
	}



}
