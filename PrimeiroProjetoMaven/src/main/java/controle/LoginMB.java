package controle;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import util.SessionContext;
import entidade.Login;

@SuppressWarnings("unused")
@Named("loginMB")
@SessionScoped
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7902529627182957374L;
	MensagemMB oMsg = new MensagemMB();

	public LoginMB() throws SQLException {

		if (SessionContext.getInstance() != null) {
			SessionContext.getInstance().encerrarSessao();
		}

	}

	@Inject
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
		System.out.println("Login: " + login);
	}

	public void validarLogin() {
		System.out.println("Usuario: " + login.getUsuario());
		System.out.println("Senha: " + login.getSenha());

		if (!login.getUsuario().equalsIgnoreCase("natan")) {
			oMsg.mensagemUsuarioInexistente();
			return;
		}

		if (!login.getSenha().equalsIgnoreCase("102030")) {
			oMsg.mensagemSenhaIncorreta();

			return;
		} else {
			SessionContext.getInstance().setAttribute("usuario", login.getUsuario());
			login = new Login();
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Salario.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
