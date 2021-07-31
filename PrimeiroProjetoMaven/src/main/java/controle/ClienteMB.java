package controle;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import entidade.ECliente;

@Named("cMB")
@ViewScoped
@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1375301618528006536L;
	@Inject
	ECliente cliente;

	public ECliente getCliente() {
		return cliente;
	}

	public void setCliente(ECliente cliente) {
		this.cliente = cliente;
	}

	public void concatenar() {
		// cliente.setConcatenado(cliente.getCpf().concat(cliente.getNome().concat(cliente.getDescricao())));

		String dados = "<br> Cliente: " + cliente.getNome() + "<br>" + "CPF: " + cliente.getCpf() + "<br> Idade: "
				+ cliente.getDataNasc() + "<br> Observações: " + cliente.getDescricao();
		cliente.setConcatenado(dados);
	}

	public void limparCliente() {
		cliente = new ECliente();
	}

}