package model;

public class DisciplinaUsuario {
	
	private long idDiscipinaUsuario;
	private Disciplina disciplina;
	private Usuario usuario;
	
	public DisciplinaUsuario() {
		super();
	}

	public DisciplinaUsuario(long idDiscipinaUsuario, Disciplina disciplina, Usuario usuario) {
		super();
		this.idDiscipinaUsuario = idDiscipinaUsuario;
		this.disciplina = disciplina;
		this.usuario = usuario;
	}

	public long getIdDiscipinaUsuario() {
		return idDiscipinaUsuario;
	}

	public void setIdDiscipinaUsuario(long idDiscipinaUsuario) {
		this.idDiscipinaUsuario = idDiscipinaUsuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	


}
