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
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Button;
import java.awt.Checkbox;

public class JAddUnity extends JFrame implements ActionListener {

	private JPanel contentPane;

	private Label id;
	private TextField textFieldId;
	private Label latitude;
	private TextField textFieldLatitude;
	private Label longitude;
	private TextField textFieldLongitude;

	private Button buttonManhattan;
	private Button buttonEuclidiana;

	private Checkbox checkboxVideo;
	private Checkbox checkboxThermomether;
	private Checkbox checkboxCo2;
	private Checkbox checkboxCh4;
	
	private AppMonitoring logic;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAddUnity frame = new JAddUnity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JAddUnity() throws SQLException {
		setTitle("Adicionar Unidade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.id = new Label("Id");
		this.id.setAlignment(Label.RIGHT);
		this.id.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.id.setBounds(41, 25, 26, 24);
		contentPane.add(this.id);

		this.textFieldId = new TextField();
		this.textFieldId.setBackground(Color.WHITE);
		this.textFieldId.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldId.setBounds(97, 25, 70, 24);
		contentPane.add(this.textFieldId);

		this.latitude = new Label("Latitude");
		this.latitude.setAlignment(Label.RIGHT);
		this.latitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.latitude.setBounds(10, 77, 57, 24);
		contentPane.add(this.latitude);

		this.textFieldLatitude = new TextField();
		this.textFieldLatitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLatitude.setBounds(97, 77, 70, 24);
		contentPane.add(this.textFieldLatitude);

		this.longitude = new Label("Longitude");
		this.longitude.setAlignment(Label.RIGHT);
		this.longitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.longitude.setBounds(10, 132, 70, 24);
		contentPane.add(this.longitude);

		this.textFieldLongitude = new TextField();
		this.textFieldLongitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLongitude.setBounds(97, 132, 70, 24);
		contentPane.add(this.textFieldLongitude);

		this.buttonManhattan = new Button("Adicionar Manhattan");
		this.buttonManhattan.addActionListener(this);
		this.buttonManhattan.setEnabled(true);
		this.buttonManhattan.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonManhattan.setBounds(10, 238, 179, 39);
		contentPane.add(this.buttonManhattan);

		this.buttonEuclidiana = new Button("Adicionar Euclidiana");
		this.buttonEuclidiana.addActionListener(this);
		this.buttonEuclidiana.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonEuclidiana.setBounds(208, 238, 179, 39);
		contentPane.add(this.buttonEuclidiana);
		
		this.checkboxVideo = new Checkbox("V\u00EDdeo");
		this.checkboxVideo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxVideo.setBounds(222, 25, 108, 24);
		contentPane.add(this.checkboxVideo);
		
		this.checkboxThermomether = new Checkbox("Term\u00F4metro");
		this.checkboxThermomether.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxThermomether.setBounds(222, 77, 108, 24);
		contentPane.add(this.checkboxThermomether);
		
		this.checkboxCo2 = new Checkbox("CO2");
		this.checkboxCo2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxCo2.setBounds(222, 132, 108, 24);
		contentPane.add(this.checkboxCo2);
		
		this.checkboxCh4 = new Checkbox("CH4");
		this.checkboxCh4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxCh4.setBounds(222, 182, 108, 24);
		contentPane.add(this.checkboxCh4);

		this.logic = new AppMonitoring();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.buttonEuclidiana)) {
			try {
				this.addEuclidiana();
				JOptionPane.showMessageDialog(this, "Unidade Adicionada!");
			} 
			catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(this, "Unidade com id inserido já existe.");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} else if (arg0.getSource().equals(this.buttonManhattan)) {
			try {
				this.addManhattan();
				JOptionPane.showMessageDialog(this, "Unidade Adicionada!");
			} 
			catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(this, "Unidade com id inserido já existe.");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void addManhattan() throws Exception {
		String id = this.textFieldId.getText();
		float latitude = Float.parseFloat(this.textFieldLatitude.getText().toString());
		float longitude = Float.parseFloat(this.textFieldLongitude.getText().toString());
		boolean video = this.checkboxVideo.getState();
		boolean termometro = this.checkboxThermomether.getState();
		boolean co2 = this.checkboxCo2.getState();
		boolean ch4 = this.checkboxCh4.getState();

		this.logic.addManhattanUnity(id, latitude, longitude, video, termometro, co2, ch4);
	}

	private void addEuclidiana() throws Exception {
		String id = this.textFieldId.getText();
		float latitude = Float.parseFloat(this.textFieldLatitude.getText().toString());
		float longitude = Float.parseFloat(this.textFieldLongitude.getText().toString());
		boolean video = this.checkboxVideo.getState();
		boolean termometro = this.checkboxThermomether.getState();
		boolean co2 = this.checkboxCo2.getState();
		boolean ch4 = this.checkboxCh4.getState();

		this.logic.addEuclideanUnity(id, latitude, longitude, video, termometro, co2, ch4);
	}
}
