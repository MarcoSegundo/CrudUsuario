package br.sefaz.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class TelefoneEntity implements AbstractEntity, Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cd_telefone")
	private int codigo;
 
	@Column(name = "ddd_fone")
	private String  ddd_fone;
 
	@Column(name = "num_fone")
	private String  numero;
 
	@Column(name = "tipo")
	private String	tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private UsuarioEntity usuario;
	
	@Override
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDdd_fone() {
		return ddd_fone;
	}

	public void setDdd_fone(String ddd_fone) {
		this.ddd_fone = ddd_fone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}
