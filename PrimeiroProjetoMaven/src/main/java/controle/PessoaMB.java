package controle;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import entidade.EPessoa;
import util.SessionContext;

@SuppressWarnings("unused")
@Named("pessoaMB")
@SessionScoped
public class PessoaMB implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 3391963678858939445L;

	public PessoaMB() throws SQLException {
		this.preencherCombo();
	}

	@Inject
	private EPessoa pessoa;

	private List<EPessoa> listaPessoa = new ArrayList<>();
	private List<SelectItem> listaCombo = new ArrayList<>();

	MensagemMB oMsg = new MensagemMB();

	public EPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<EPessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<EPessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public List<SelectItem> getListaCombo() {
		return listaCombo;
	}

	public void setListCombo(List<SelectItem> listaCombo) {
		this.listaCombo = listaCombo;
	}

	public void preencherCombo() {
		this.listaCombo.add(new SelectItem("0", "--Selecione--"));
		this.listaCombo.add(new SelectItem("1", "Masculino"));
		this.listaCombo.add(new SelectItem("2", "Feminino"));
	}

	public void listaSexo() {
		String sexo = this.pessoa.getSexo();
		if (sexo.equals("1")) {
			sexo = "Masculino";
		} else if (sexo.equals("2")) {
			sexo = "Feminino";
		}

		this.pessoa.setText_sexo(sexo);

	}

	public void salvar() throws ParseException {
		this.listaPessoa.add(this.pessoa);
		this.pessoa = new EPessoa();
	}

	public void limpar() {
		this.listaPessoa.clear();
		this.pessoa = new EPessoa();
	}

	public void calcular() throws ParseException {
		this.descontos();
		listaSexo();
		this.listaPessoa.add(this.pessoa);
		this.pessoa = new EPessoa();

	}

	public void descontos() {
		this.calcular_inss(this.pessoa.getSalario());
		this.calcular_ir();
	}

	public void calcular_inss(double salarioBruto) {
		double inss = (salarioBruto * 0.11);
		double salario = salarioBruto - inss;

		this.pessoa.setSalario_liquido(salario);
		this.pessoa.setInss((inss));
	}

	public void calcular_ir() {
		double salarioBruto = this.pessoa.getSalario_liquido();
		double ir = 0;

		if (salarioBruto >= 0 && salarioBruto <= 1903.98) {
			this.pessoa.setSalario_liquido(salarioBruto);
		} else if (salarioBruto >= 1903.99 && salarioBruto <= 2826.65) {
			ir = (salarioBruto * 0.075);
			double salario = salarioBruto - ir;
			this.pessoa.setSalario_liquido(salario);
		} else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
			ir = (salarioBruto * 0.15);
			double salario = salarioBruto - ir;
			this.pessoa.setSalario_liquido(salario);
		} else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
			ir = (salarioBruto * 0.225);
			double salario = salarioBruto - ir;
			this.pessoa.setSalario_liquido(salario);
		} else if (salarioBruto >= 4664.68) {
			ir = (salarioBruto * 0.275);
			double salario = salarioBruto - ir;
			this.pessoa.setSalario_liquido(salario);
		}
		this.pessoa.setIr(ir);

	}

}
