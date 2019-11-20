package model;

public class Telefone {

	private long idTelefone;
	private String descricaoDep;
	private String numero;
	
	private InstitutoFederal institutoFederal;

	public Telefone() {
		super();
	}

	public Telefone(long idTelefone, String descricaoDep, String numero, InstitutoFederal institutoFederal) {
		super();
		this.idTelefone = idTelefone;
		this.descricaoDep = descricaoDep;
		this.numero = numero;
		this.institutoFederal = institutoFederal;
	}

	public long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getDescricaoDep() {
		return descricaoDep;
	}

	public void setDescricaoDep(String descricaoDep) {
		this.descricaoDep = descricaoDep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public InstitutoFederal getInstitutoFederal() {
		return institutoFederal;
	}

	public void setInstitutoFederal(InstitutoFederal institutoFederal) {
		this.institutoFederal = institutoFederal;
	}

	
	
	

	

}
