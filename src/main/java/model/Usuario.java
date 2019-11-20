package model;

import java.util.ArrayList;
import java.util.List;
//id - nome - senha - info - fto - email - listaUsuarioAnexo - listaUsuarioAvaiacao


public class Usuario {
	private long idUsuario;
	private String nomeUsuario;
	private String senha;
	private String infoUsuario;
	private String fotoPerfil;
	private String email;
	
	private List<UsuarioAnexo> listaUsuarioAnexo;
	private List<DisciplinaUsuario> listaDisciplinaUsuario;
	private List<UsuarioAvaliacao> listaUsuarioAvaliacao;
	
	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String nomeUsuario, String senha, String infoUsuario, String fotoPerfil,
			String email, List<UsuarioAnexo> listaUsuarioAnexo, List<DisciplinaUsuario> listaDisciplinaUsuario,
			List<UsuarioAvaliacao> listaUsuarioAvaliacao) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.infoUsuario = infoUsuario;
		this.fotoPerfil = fotoPerfil;
		this.email = email;
		this.listaUsuarioAnexo = listaUsuarioAnexo;
		this.listaDisciplinaUsuario = listaDisciplinaUsuario;
		this.listaUsuarioAvaliacao = listaUsuarioAvaliacao;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(String infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UsuarioAnexo> getListaUsuarioAnexo() {
		return listaUsuarioAnexo;
	}

	public void setListaUsuarioAnexo(List<UsuarioAnexo> listaUsuarioAnexo) {
		this.listaUsuarioAnexo = listaUsuarioAnexo;
	}

	public List<DisciplinaUsuario> getListaDisciplinaUsuario() {
		return listaDisciplinaUsuario;
	}

	public void setListaDisciplinaUsuario(List<DisciplinaUsuario> listaDisciplinaUsuario) {
		this.listaDisciplinaUsuario = listaDisciplinaUsuario;
	}

	public List<UsuarioAvaliacao> getListaUsuarioAvaliacao() {
		return listaUsuarioAvaliacao;
	}

	public void setListaUsuarioAvaliacao(List<UsuarioAvaliacao> listaUsuarioAvaliacao) {
		this.listaUsuarioAvaliacao = listaUsuarioAvaliacao;
	}
	

	
}
	
	
	
	
	
	