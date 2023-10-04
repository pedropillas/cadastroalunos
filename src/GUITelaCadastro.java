import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUITelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nmAluno;
	private JTextField idadeAluno;
	private JTextField cursoAluno;

	Aluno alu = new Aluno();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITelaCadastro frame = new GUITelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUITelaCadastro() {
		setForeground(new Color(255, 255, 255));
		setTitle("Cadastro de Aluno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do Aluno(a):");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(123, 64, 119, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(122, 105, 47, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Curso:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(123, 142, 46, 14);
		contentPane.add(lblNewLabel_2);

		nmAluno = new JTextField();
		nmAluno.setHorizontalAlignment(SwingConstants.LEFT);
		alu.setNome(nmAluno).setBounds(123, 80, 160, 20);
		contentPane.add(alu.setNome(nmAluno));
		alu.setNome(nmAluno).setColumns(10);

		idadeAluno = new JTextField();
		alu.setIdade(idadeAluno).setBounds(122, 118, 161, 20);
		contentPane.add(alu.setNome(idadeAluno));
		alu.setIdade(idadeAluno).setColumns(10);

		cursoAluno = new JTextField();
		alu.setCurso(cursoAluno).setBounds(122, 157, 161, 20);
		contentPane.add(alu.setCurso(cursoAluno));
		alu.setCurso(cursoAluno).setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar\r\n");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBackground(new Color(224, 224, 224));
		btnCadastrar.setToolTipText("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "INSERT INTO tb_aluno(nmaluno, idadealuno, cursoaluno) VALUES (?,?,?)";
				ConectaBanco factory = new ConectaBanco();
				try (Connection c = factory.obtemConexao()) {
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, nmAluno.getText());
					ps.setString(2, idadeAluno.getText());
					ps.setString(3, cursoAluno.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso.");
					
				} catch (Exception w) {
					w.printStackTrace();
				}
				nmAluno.setText("");
				idadeAluno.setText("");
				cursoAluno.setText("");
			}
		});
		btnCadastrar.setBounds(155, 209, 105, 34);
		contentPane.add(btnCadastrar);

		
	//---------------------- BOTÃO ALTERAR CADASTRO ----------------------	
	//	JButton btnAlterar = new JButton("Alterar");
	//	btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
	//	btnAlterar.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
	//	btnAlterar.setBackground(new Color(224, 224, 224));
	//	btnAlterar.setBounds(22, 238, 105, 34);
	//	contentPane.add(btnAlterar);
    //---------------------- BOTÃO ALTERAR CADASTRO ----------------------		
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUITelaInicial tli = new GUITelaInicial();
				tli.setVisible(true);
				dispose();
			}
		});
		btnFechar.setForeground(new Color(0, 0, 0));
		btnFechar.setBackground(new Color(224, 224, 224));
		btnFechar.setBounds(155, 249, 105, 34);
		contentPane.add(btnFechar);

		JLabel lblNewLabel_3 = new JLabel("CADASTRO DE ALUNOS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(108, 29, 196, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Limpar");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				limparCampos();
			}
		});
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(172, 184, 68, 14);
		contentPane.add(lblNewLabel_4);
	}

	private void limparCampos() {
		nmAluno.setText("");
		idadeAluno.setText("");
		cursoAluno.setText("");
		nmAluno.requestFocus();
	}
	
	// private void mSelecionar() { -- Fazer mouse selecionar botao limpar.
		
}
