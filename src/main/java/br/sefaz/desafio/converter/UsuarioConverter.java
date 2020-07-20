package br.sefaz.desafio.converter;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.model.UsuarioModel;

public class UsuarioConverter {
	
	public static UsuarioEntity toEntity(UsuarioModel model) {
		
		UsuarioEntity entity = new UsuarioEntity();
		entity.setCodigo(model.getCodigo());
		entity.setNome(model.getNome());
		entity.setEmail(model.getEmail());

		String senhaEncoded = Base64.getEncoder().encodeToString(model.getSenha().getBytes());
		
		entity.setSenha(senhaEncoded);
		
		return entity;
	}
	
	public static UsuarioModel toModel(UsuarioEntity entity) {
		
		UsuarioModel model = new UsuarioModel();
		model.setCodigo(entity.getCodigo());
		model.setNome(entity.getNome());
		model.setEmail(entity.getEmail());
		
		byte[] senhaBytes = Base64.getDecoder().decode(entity.getSenha());
		String decodedSenha = new String(senhaBytes);
		
		model.setSenha(decodedSenha);
		
		return model;
	}
	
	public static List<UsuarioModel> toListModel(List<UsuarioEntity> listaEntity){
		List<UsuarioModel> listaModel = listaEntity.stream().map(entity -> {
			return toModel(entity);
		}).collect(Collectors.toList());
		
		return listaModel;
	}
}
