package Lista13;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class ProgramaQ4 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField ctNome;
	private JTextField ctSenha;
	private JButton bEntrar;
	
	public ProgramaQ4() {
		super("Cadastro de Clientes - Acesso");
		gerarImagem();
		labels();
		botoes();
		camposTxt();
		setSize(450, 210);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void gerarImagem() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		ImageIcon chave = new ImageIcon(classLoader.getResource("chave.png"));
		JLabel jlChave = new JLabel(chave);
		jlChave.setBounds(35, 15, 156, 144);
		add(jlChave);
	}
	
	public void labels() {
		JLabel lNome = new JLabel("Nome:");
		lNome.setBounds(225, 45, 50, 20);
		lNome.setFont(new Font(null, Font.BOLD, 14 ));
		add(lNome);
		
		JLabel lSenha = new JLabel("Senha:");
		lSenha.setForeground(Color.red);
		lSenha.setBounds(225, 75, 50, 20);
		lSenha.setFont(new Font(null, Font.BOLD, 14 ));
		add(lSenha);
	}
	
	public void camposTxt() {
		ctNome = new JTextField();
		ctNome.setBounds(295, 45, 115, 20);
		add(ctNome);
		
		ctSenha = new JTextField();
		ctSenha.setBounds(295, 75, 115, 20);
		add(ctSenha);
	}
	
	public void botoes() {
		bEntrar = new JButton("Entrar");
		bEntrar.setForeground(new Color(47,148,0));
		bEntrar.setFont(new Font(null, Font.BOLD, 14 ));
		bEntrar.setBounds(295, 115, 93, 23);
		add(bEntrar);
	}
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new ProgramaQ4();
	}
}