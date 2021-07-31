package entidade;

import java.io.Serializable;

import java.text.NumberFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class EPessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3534439732850615530L;
	private String cpf_cnpj;
	private String nome;
	private String email;
	private String observacao;
	private String sexo;
	private String text_sexo;
	private Date data_nasc;
	private double salario;
	private double inss;
	private double ir;
	private double salario_liquido;
	private String tipoPessoa;

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public double getSalario() {

		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public double getIr() {
		return ir;
	}

	public void setIr(double ir) {
		this.ir = ir;
	}

	public double getSalario_liquido() {
		return salario_liquido;
	}

	public void setSalario_liquido(double salario_liquido) {
		this.salario_liquido = salario_liquido;
	}

	public String getText_sexo() {
		return text_sexo;
	}

	public void setText_sexo(String text_sexo) {
		this.text_sexo = text_sexo;
	}

}
