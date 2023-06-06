package Lista14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ProgramaQ2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel resultado;
	private JSpinner spinner;
	private JLabel dado;
	private static Clip clip;
	private int faceSorteada;

	public ProgramaQ2() {
		super("Sorteia dado");
		setLayout(null);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		label();
		spinner();
		botao();
		setVisible(true);
	}

	public void label() {
		resultado = new JLabel();
		resultado.setBounds(210,400,120,30);
		add(resultado);

		dado = new JLabel(getImgDado("1.png"));
		dado.setBounds(180,180,140,140);
		add(dado);
	}

	public void spinner() {
		SpinnerModel valores = new SpinnerNumberModel(1,1,6,1);
		spinner = new JSpinner(valores);
		spinner.setBounds(170,20,40,35);
		add(spinner);
	}

	public ImageIcon getImgDado(String face) {
		String caminho = "images/" + face;
		ClassLoader classLoader = this.getClass().getClassLoader();
		ImageIcon icone = new ImageIcon(classLoader.getResource(caminho));
		return icone;
	}

	public void botao() {
		JButton jogar = new JButton("Jogar");
		jogar.setBounds(230,20,110,35);
		add(jogar);
		jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rolarDado();
			}
		});
	}

	public void somDadoRolando() {
		File file = new File("./src/images/dadoRolando.wav");
		AudioInputStream sound;
		try {
			sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		clip.setFramePosition(0);
		clip.start();
	}

	public void rolarDado() {
		new Thread() {
			public void run() {
				try {
					dado.setIcon(getImgDado("anim.gif"));
					somDadoRolando();
					Thread.sleep(1000);
					faceSorteada = ((int) (1 + Math.random() * 6));
					dado.setIcon(getImgDado(faceSorteada + ".png"));
					verificaResultado();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void verificaResultado() throws InterruptedException {
		if((int) spinner.getValue() == faceSorteada)
			resultado.setText("Você acertou!");
		else
			resultado.setText("Você errou!");
		Thread.sleep(2000);

		int repetir = JOptionPane.showConfirmDialog(this, "Quer jogar de novo?",
				"Confirmação", JOptionPane.YES_NO_OPTION);
		if(repetir == 1)
			System.exit(0);
		else
			resultado.setText("");
	}

	public static void main(String[] args) {
		new ProgramaQ2();
	}
}