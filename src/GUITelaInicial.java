import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class GUITelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField pwSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITelaInicial frame = new GUITelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Admin adm = new Admin();

	public GUITelaInicial() {
		setTitle("Cadastro de Aluno (ADMIN)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		adm.setLogin(txtLogin).setBounds(144, 80, 125, 20);
		contentPane.add(adm.setLogin(txtLogin));
		adm.setLogin(txtLogin).setColumns(10);

		pwSenha = new JTextField();
		adm.setSenha(pwSenha).setBounds(144, 120, 125, 20);
		contentPane.add(adm.setSenha(pwSenha));

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(144, 65, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(144, 105, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = ("SELECT * FROM administrador WHERE login= ? and senha= ?");
				ConectaBanco factory = new ConectaBanco();
				try (Connection c = factory.obtemConexao()) {
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, txtLogin.getText());
					ps.setString(2, pwSenha.getText());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Bem-vindo! Acesso liberado.");
						GUITelaCadastro TlCad = new GUITelaCadastro();
						TlCad.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Acesso negado.");
					}

				} catch (Exception w) {
					w.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(161, 162, 89, 23);
		contentPane.add(btnEntrar);

		JLabel lblNewLabel_2 = new JLabel("ADMIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(172, 40, 66, 14);
		contentPane.add(lblNewLabel_2);

	}
}
