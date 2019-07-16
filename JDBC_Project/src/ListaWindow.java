import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ListaWindow extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<String> model;

	public ListaWindow() {
		super("JDBC");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setSize(240, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		insertIntoList();
		
		JList<String> list = new JList<String>(model);
		list.setBounds(10, 10, 210, 230);
		list.setBackground(Color.WHITE);
		getContentPane().add(list);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Consulta item "+list.getSelectedIndex());				
			}
		});
		btnConsultar.setBounds(72, 257, 89, 23);
		getContentPane().add(btnConsultar);
		setVisible(true);
	}
	
	private void insertIntoList() {
		
		// consulta itens na lista e exibe o nome e o cpf da pessoa a ser consultada
		// ao clicar na consulta abre a janela referente aos dados da pessoa a ser consultada - executa where passando cpf
		
		model = new DefaultListModel<String>();
		
		String names[] = {};
		
		for(int i = 0; i < names.length; i++) {
			model.add(i, names[i]);
		}
	}
	
}
