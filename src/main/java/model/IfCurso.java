package model;

public class IfCurso {

	private long idIfCurso;

	private Curso curso;
	private InstitutoFederal institutoFederal;

	public IfCurso() {
		super();
	}

	public IfCurso(long idIfCurso, Curso curso, InstitutoFederal institutoFederal) {
		super();
		this.idIfCurso = idIfCurso;
		this.curso = curso;
		this.institutoFederal = institutoFederal;
	}

	public long getIdIfCurso() {
		return idIfCurso;
	}

	public void setIdIfCurso(long idIfCurso) {
		this.idIfCurso = idIfCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public InstitutoFederal getInstitutoFederal() {
		return institutoFederal;
	}

	public void setInstitutoFederal(InstitutoFederal institutoFederal) {
		this.institutoFederal = institutoFederal;
	}
	
	
}