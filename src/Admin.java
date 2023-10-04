import javax.swing.JTextField;

public class Admin {

	private JTextField login;
	private JTextField senha;

	Admin() {
	}

	Admin(JTextField login, JTextField senha) {
		this.login = login;
		this.senha = senha;
	}

	public JTextField getLogin() {
		return login;
	}

	public JTextField setLogin(JTextField login) {
		return this.login = login;
	}

	public JTextField getSenha() {
		return senha;
	}

	public JTextField setSenha(JTextField senha) {
		return this.senha = senha;
	}
}
