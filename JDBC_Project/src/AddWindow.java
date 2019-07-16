import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddWindow extends JFrame {
	private JTextField nome_tf;
	private JTextField cpf_tf;
	private JLabel lblDataDeNascimento;
	private JTextField dataNascimento_tf;
	private JLabel lblSexo;
	private JLabel lblIdend;
	private JTextField idEnd_tf;
	private JButton btnCadastrar;
	private JButton btnAdicionarImagem;
	private JInternalFrame fotoExibida;
	
	private JRadioButton rdbtnM, rdbtnF;
	
	private ButtonGroup bgSexo;

	private BufferedImage image;
	
	private String name, CPF, sexo, id_end, dataNascimento;
	private File fileImage;
	
	private JLabel photoLabel;
	
	public AddWindow() {
		super("JDBC");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(32, 25, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(32, 50, 46, 14);
		getContentPane().add(lblCpf);

		nome_tf = new JTextField();
		nome_tf.setBounds(88, 22, 231, 20);
		getContentPane().add(nome_tf);
		nome_tf.setColumns(10);

		cpf_tf = new JTextField();
		cpf_tf.setBounds(88, 47, 231, 20);
		getContentPane().add(cpf_tf);
		cpf_tf.setColumns(10);

		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(32, 75, 125, 14);
		getContentPane().add(lblDataDeNascimento);

		dataNascimento_tf = new JTextField();
		dataNascimento_tf.setBounds(145, 72, 125, 20);
		getContentPane().add(dataNascimento_tf);
		dataNascimento_tf.setColumns(10);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(32, 115, 46, 14);
		getContentPane().add(lblSexo);

		bgSexo = new ButtonGroup();

		rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(84, 96, 109, 23);
		getContentPane().add(rdbtnM);

		rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(84, 122, 109, 23);
		getContentPane().add(rdbtnF);

		bgSexo.add(rdbtnF);
		bgSexo.add(rdbtnM);

		lblIdend = new JLabel("ID_END:");
		lblIdend.setBounds(50, 207, 46, 14);
		getContentPane().add(lblIdend);

		idEnd_tf = new JTextField();
		idEnd_tf.setBounds(106, 204, 125, 20);
		getContentPane().add(idEnd_tf);
		idEnd_tf.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(249, 222, 89, 23);
		getContentPane().add(btnCadastrar);

		btnAdicionarImagem = new JButton("Adicionar Imagem");
		btnAdicionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(getContentPane());
				fileImage = fc.getSelectedFile();

				if (fileImage != null) {
					
					try {
						
						image = ImageIO.read(fileImage);
						
						ImageIcon img = new ImageIcon(image.getScaledInstance(180, 180, 100));
						
						photoLabel = new JLabel(img);
						fotoExibida.getContentPane().add(photoLabel);
						fotoExibida.repaint();
						fotoExibida.pack();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		});
		btnAdicionarImagem.setBounds(32, 154, 125, 23);
		getContentPane().add(btnAdicionarImagem);

		fotoExibida = new JInternalFrame("Foto");
		fotoExibida.setBounds(372, 25, 180, 180);
		getContentPane().add(fotoExibida);
		fotoExibida.setVisible(true);
		this.setVisible(true);
	}

	protected void cadastrar() {
		
		// contem bugs. se uma pessoa tenta cadastrar algo vazio, dá erro
		
		
		name = nome_tf.getText();
		CPF = cpf_tf.getText();
		dataNascimento = dataNascimento_tf.getText();
		if(rdbtnF.isSelected()) {
			sexo = "F";
		} else if(rdbtnM.isSelected()) {
			sexo = "M";
		}
		id_end = idEnd_tf.getText();
		
		new BusinessLayer(name, CPF, dataNascimento, sexo, id_end, fileImage);
		
		JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
		
		nome_tf.setText("");
		cpf_tf.setText("");
		dataNascimento_tf.setText("");
		rdbtnF.setSelected(false);
		rdbtnM.setSelected(false);
		idEnd_tf.setText("");
		fotoExibida.getContentPane().remove(photoLabel);
		fotoExibida.repaint();
	}
}
