package model;

import java.util.List;

public class InstitutoFederal {
	private long idIf;
	private String campus;
	
	private List<Telefone> listaTelefones;
	private List<IfCurso> listaIfCurso;
	
	
	public InstitutoFederal() {
		super();
	}

	public InstitutoFederal(long idIf, String campus, List<Telefone> listaTelefones, List<IfCurso> listaIfCurso) {
		super();
		this.idIf = idIf;
		this.campus = campus;
		this.listaTelefones = listaTelefones;
		this.listaIfCurso = listaIfCurso;
	}

	public long getIdIf() {
		return idIf;
	}

	public void setIdIf(long idIf) {
		this.idIf = idIf;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public List<IfCurso> getListaIfCurso() {
		return listaIfCurso;
	}

	public void setListaIfCurso(List<IfCurso> listaIfCurso) {
		this.listaIfCurso = listaIfCurso;
	}
	
	

}
