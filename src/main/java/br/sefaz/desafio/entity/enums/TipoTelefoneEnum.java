package br.sefaz.desafio.entity.enums;

public enum TipoTelefoneEnum {
	RESIDENCIAL("R", "Residencial"),
    CELULAR("C", "Celular"),
    TRABALHO("T", "Trabalho");

    private String valor;
    private String descricao;

    TipoTelefoneEnum (String tipoTelefone, String descricaoTelefone) {
        this.valor = tipoTelefone;
        this.descricao = descricaoTelefone;
    }

    public String getValue() {
        return this.valor;
    }
    public String getDescricao() { return this.descricao; }
}
