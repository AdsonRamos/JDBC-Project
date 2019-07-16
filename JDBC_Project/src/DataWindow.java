import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DataWindow {

	private JFrame frame;
	private JTextField cpf_tf;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtSexo;
	private JTextField txtID;
	
	private BufferedImage image;
	
	private String nome, CPF, dataNascimento, sexo, id_End;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new DataWindow();
	}

	public DataWindow() {
		
		loadVariables();
		
		initialize();
		
	}
	
	private void loadVariables() {
		// carrega os dados do banco sql e joga nas variáveis
		// exemplos ficcionais
		
		try {
			image = ImageIO.read(new File("res/student.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.nome = "Albert Einstein";
		this.CPF = "111111111-22";
		this.dataNascimento = "23/12/1822";
		this.sexo = "M";
		this.id_End = "555";
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JDBC");
		frame.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(55, 48, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		cpf_tf = new JTextField();
		cpf_tf.setText(CPF);
		cpf_tf.setEditable(false);
		cpf_tf.setBounds(212, 45, 152, 20);
		frame.getContentPane().add(cpf_tf);
		cpf_tf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(55, 79, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText(nome);
		txtNome.setEditable(false);
		txtNome.setBounds(212, 76, 152, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(55, 118, 109, 14);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(55, 159, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblIdend = new JLabel("ID_End:");
		lblIdend.setBounds(182, 159, 46, 14);
		frame.getContentPane().add(lblIdend);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setText(dataNascimento);
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setBounds(212, 115, 152, 20);
		frame.getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setText(sexo);
		txtSexo.setBounds(111, 156, 46, 20);
		frame.getContentPane().add(txtSexo);
		txtSexo.setColumns(10);
		
		txtID = new JTextField();
		txtID.setText(id_End);
		txtID.setEditable(false);
		txtID.setBounds(238, 156, 126, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JInternalFrame imageFrame = new JInternalFrame("Foto");
		imageFrame.setBounds(400, 11, 180, 180);
		
		ImageIcon img = new ImageIcon(image);
		img.setImage(img.getImage().getScaledInstance(180, 180, 100));
		
		JLabel picLabel = new JLabel(img);
		imageFrame.getContentPane().add(picLabel);
		imageFrame.repaint();
		frame.getContentPane().add(imageFrame);
		imageFrame.setVisible(true);
		
		frame.setVisible(true);
		
	}
}
