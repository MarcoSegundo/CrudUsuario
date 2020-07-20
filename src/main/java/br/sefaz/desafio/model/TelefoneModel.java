package br.sefaz.desafio.model;

import java.io.Serializable;

import br.sefaz.desafio.entity.enums.TipoTelefoneEnum;

public class TelefoneModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	private int codigo;
	private String dddFone;
	private String numero;
	private TipoTelefoneEnum tipo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDddFone() {
		return dddFone;
	}
	public void setDddFone(String dddFone) {
		this.dddFone = dddFone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoTelefoneEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoTelefoneEnum tipo) {
		this.tipo = tipo;
	}
}
