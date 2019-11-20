package model;

import java.util.List;

public class Anexo {
	
	private long idAnexo;
	private boolean statusAnexo;
	private String link;
	private String titulo;
	private String tipoAnexo;
	
	private List<UsuarioAnexo> listaUsuarioAnexo;
	private Disciplina disciplina;
	
	public Anexo() {
		super();
	}

	public Anexo(long idAnexo, boolean statusAnexo, String link, String titulo, String tipoAnexo,
			List<UsuarioAnexo> listaUsuarioAnexo, Disciplina disciplia) {
		super();
		this.idAnexo = idAnexo;
		this.statusAnexo = statusAnexo;
		this.link = link;
		this.titulo = titulo;
		this.tipoAnexo = tipoAnexo;
		this.listaUsuarioAnexo = listaUsuarioAnexo;
		this.disciplina = disciplia;
	}

	public long getIdAnexo() {
		return idAnexo;
	}

	public boolean getStatusAnexo() {
		return statusAnexo;
	}

	public void setStatusAnexo(boolean statusAnexo) {
		this.statusAnexo = statusAnexo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipoAnexo() {
		return tipoAnexo;
	}

	public void setTipoAnexo(String tipoAnexo) {
		this.tipoAnexo = tipoAnexo;
	}

	public List<UsuarioAnexo> getListaUsuarioAnexo() {
		return listaUsuarioAnexo;
	}

	public void setListaUsuarioAnexo(List<UsuarioAnexo> listaUsuarioAnexo) {
		this.listaUsuarioAnexo = listaUsuarioAnexo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setIdAnexo(long idAnexo) {
		this.idAnexo = idAnexo;
	}
	
	

}
