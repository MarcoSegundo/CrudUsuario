package br.sefaz.desafio.entity;

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
public class TelefoneEntity {
	@Id
	@GeneratedValue
	@Column(name = "cd_telefone")
	private Integer codigo;
 
	@Column(name = "ddd_fone")
	private String  ddd_fone;
 
	@Column(name = "num_fone")
	private String  numero;
 
	@Column(name = "tipo")
	private String	tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private UsuarioEntity usuario;
}
