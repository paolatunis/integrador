package model;
import java.util.List;

//id - nome - turmas -infoCurso

public class Curso {
	private long idCurso;
	private String nomeCurso;
	private String turmas;
	private String infoCurso;

	private List<String> listaTurmas;
	private List<Disciplina> listaDisciplinas;
	private List<IfCurso> listaIfCurso;

	public Curso() {
		super();
	}

	public Curso(long idCurso, String nomeCurso, String turmas, String infoCurso, List<String> listaTurmas,
			List<Disciplina> listaDisciplinas, List<IfCurso> listaIfCurso) {
		super();
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.turmas = turmas;
		this.infoCurso = infoCurso;
		this.listaTurmas = listaTurmas;
		this.listaDisciplinas = listaDisciplinas;
		this.listaIfCurso = listaIfCurso;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getTurmas() {
		return turmas;
	}

	public void setTurmas(String turmas) {
		this.turmas = turmas;
	}

	public String getInfoCurso() {
		return infoCurso;
	}

	public void setInfoCurso(String infoCurso) {
		this.infoCurso = infoCurso;
	}

	public List<String> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<String> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public List<IfCurso> getListaIfCurso() {
		return listaIfCurso;
	}

	public void setListaIfCurso(List<IfCurso> listaIfCurso) {
		this.listaIfCurso = listaIfCurso;
	}




}
