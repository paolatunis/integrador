package model;

public class UsuarioAvaliacao {
	
	private long idUsuarioAvaliacao;
	
	private Usuario usuario;
	private Avaliacao avaliacao;
	
	public UsuarioAvaliacao() {
		super();
	}

	public UsuarioAvaliacao(long idUsuarioAvaliacao, Usuario usuario, Avaliacao avaliacao) {
		super();
		this.idUsuarioAvaliacao = idUsuarioAvaliacao;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
	}

	public long getIdUsuarioAvaliacao() {
		return idUsuarioAvaliacao;
	}

	public void setIdUsuarioAvaliacao(long idUsuarioAvaliacao) {
		this.idUsuarioAvaliacao = idUsuarioAvaliacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	

}
