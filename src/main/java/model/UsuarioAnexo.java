package model;


public class UsuarioAnexo {
	
	private long idUsuarioAnexo;
	
	private Usuario usuario;
	private Anexo anexo;
	
	public UsuarioAnexo() {
		super();
	}

	public UsuarioAnexo(long idUsuarioAnexo, Usuario usuario, Anexo anexo) {
		super();
		this.idUsuarioAnexo = idUsuarioAnexo;
		this.usuario = usuario;
		this.anexo = anexo;
	}

	public long getIdUsuarioAnexo() {
		return idUsuarioAnexo;
	}

	public void setIdUsuarioAnexo(long idUsuarioAnexo) {
		this.idUsuarioAnexo = idUsuarioAnexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Anexo getAnexo() {
		return anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}
	
	
	
	
	
}
