package br.sefaz.desafio.model;

import java.io.Serializable;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String codigo;
	private String nome;
	private String email;
	private String senha;
 
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
}
