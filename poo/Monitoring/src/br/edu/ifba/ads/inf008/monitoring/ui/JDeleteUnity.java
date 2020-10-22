package br.edu.ifba.ads.inf008.monitoring.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifba.ads.inf008.monitoring.session.AppMonitoring;

import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Button;

public class JDeleteUnity extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private AppMonitoring logic;
	private Label id;
	private TextField textFieldId;
	private Button buttonApagar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDeleteUnity frame = new JDeleteUnity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JDeleteUnity() throws SQLException {
		setTitle("Apagar Unidade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.id = new Label("Id da unidade");
		this.id.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.id.setBounds(43, 33, 101, 24);
		contentPane.add(this.id);
		
		this.textFieldId = new TextField();
		this.textFieldId.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldId.setBounds(150, 33, 141, 24);
		contentPane.add(this.textFieldId);
		
		this.buttonApagar = new Button("Apagar");
		this.buttonApagar.addActionListener(this);
		this.buttonApagar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonApagar.setBounds(43, 92, 248, 34);
		contentPane.add(this.buttonApagar);
		
		this.logic = new AppMonitoring();
	}
	
	private void apagarUnidade() {
		String id = this.textFieldId.getText();
		
		try {
			this.logic.deleteUnity(id);
			JOptionPane.showMessageDialog(this, "Unidade apagada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.buttonApagar)) {
			this.apagarUnidade();
		}
	}
}
