package entidade;

import java.io.Serializable;

public class ECliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5703477637163516915L;
	private String cpf;
	private String nome;
	private String descricao;
	private String dataNasc;
	private String concatenado;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConcatenado() {
		return concatenado;
	}

	public void setConcatenado(String concatenado) {
		this.concatenado = concatenado;
	}


	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

}
