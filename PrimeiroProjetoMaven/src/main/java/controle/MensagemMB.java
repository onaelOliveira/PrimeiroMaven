package controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("mensagemMB")
@ViewScoped
public class MensagemMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5625611786410458291L;

	public void mensagemUsuarioInexistente() {
		FacesMessage mensagem = new FacesMessage("Usuário Invalido!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void mensagemSenhaIncorreta() {
		FacesMessage mensagem = new FacesMessage("Senha Incorreta");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
}
