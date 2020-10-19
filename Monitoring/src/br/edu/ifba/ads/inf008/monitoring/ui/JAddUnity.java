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

public class JAddUnity extends JFrame implements ActionListener {

	private JPanel contentPane;

	private Label id;
	private TextField textFieldId;
	private Label latitude;
	private TextField textFieldLatitude;
	private Label longitude;
	private TextField textFieldLongitude;
	private Label video;
	private TextField textFieldVideo;
	private Label termometro;
	private TextField textFieldTermometro;
	private Label co2;
	private TextField textFieldCO2;
	private Label ch4;
	private TextField textFieldCH4;

	private Button buttonManhattan;
	private Button buttonEuclidiana;

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
		setBounds(100, 100, 649, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.id = new Label("Id");
		this.id.setAlignment(Label.RIGHT);
		this.id.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.id.setBounds(98, 54, 70, 24);
		contentPane.add(this.id);

		this.textFieldId = new TextField();
		this.textFieldId.setBackground(Color.WHITE);
		this.textFieldId.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldId.setBounds(174, 54, 70, 24);
		contentPane.add(this.textFieldId);

		this.latitude = new Label("Latitude");
		this.latitude.setAlignment(Label.RIGHT);
		this.latitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.latitude.setBounds(98, 142, 70, 24);
		contentPane.add(this.latitude);

		this.textFieldLatitude = new TextField();
		this.textFieldLatitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLatitude.setBounds(174, 142, 70, 24);
		contentPane.add(this.textFieldLatitude);

		this.longitude = new Label("Longitude");
		this.longitude.setAlignment(Label.RIGHT);
		this.longitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.longitude.setBounds(98, 221, 70, 24);
		contentPane.add(this.longitude);

		this.textFieldLongitude = new TextField();
		this.textFieldLongitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLongitude.setBounds(174, 221, 70, 24);
		contentPane.add(this.textFieldLongitude);

		this.video = new Label("V\u00EDdeo");
		this.video.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.video.setAlignment(Label.RIGHT);
		this.video.setBounds(98, 301, 70, 24);
		contentPane.add(this.video);

		this.textFieldVideo = new TextField();
		this.textFieldVideo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldVideo.setBounds(174, 301, 70, 24);
		contentPane.add(this.textFieldVideo);

		this.termometro = new Label("Term\u00F4metro");
		this.termometro.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.termometro.setAlignment(Label.RIGHT);
		this.termometro.setBounds(286, 54, 99, 24);
		contentPane.add(this.termometro);

		this.textFieldTermometro = new TextField();
		this.textFieldTermometro.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldTermometro.setBounds(391, 54, 70, 24);
		contentPane.add(this.textFieldTermometro);

		this.co2 = new Label("CO2");
		this.co2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.co2.setAlignment(Label.RIGHT);
		this.co2.setBounds(315, 142, 70, 24);
		contentPane.add(this.co2);

		this.textFieldCO2 = new TextField();
		this.textFieldCO2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldCO2.setBounds(391, 142, 70, 24);
		contentPane.add(this.textFieldCO2);

		this.ch4 = new Label("CH4");
		this.ch4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.ch4.setAlignment(Label.RIGHT);
		this.ch4.setBounds(315, 221, 70, 24);
		contentPane.add(this.ch4);

		this.textFieldCH4 = new TextField();
		this.textFieldCH4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldCH4.setBounds(391, 221, 70, 24);
		contentPane.add(this.textFieldCH4);

		this.buttonManhattan = new Button("Adicionar Manhattan");
		this.buttonManhattan.addActionListener(this);
		this.buttonManhattan.setEnabled(true);
		this.buttonManhattan.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonManhattan.setBounds(98, 381, 179, 39);
		contentPane.add(this.buttonManhattan);

		this.buttonEuclidiana = new Button("Adicionar Euclidiana");
		this.buttonEuclidiana.addActionListener(this);
		this.buttonEuclidiana.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonEuclidiana.setBounds(336, 381, 179, 39);
		contentPane.add(this.buttonEuclidiana);

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
				JOptionPane.showConfirmDialog(this, "Unidade Adicionada!");
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
		boolean video = Boolean.parseBoolean(this.textFieldVideo.getText().toString());
		boolean termometro = Boolean.parseBoolean(this.textFieldTermometro.getText().toString());
		boolean co2 = Boolean.parseBoolean(this.textFieldCO2.getText().toString());
		boolean ch4 = Boolean.parseBoolean(this.textFieldCH4.getText().toString());

		this.logic.addManhattanUnity(id, latitude, longitude, video, termometro, co2, ch4);
	}

	private void addEuclidiana() throws Exception {
		String id = this.textFieldId.getText();
		float latitude = Float.parseFloat(this.textFieldLatitude.getText().toString());
		float longitude = Float.parseFloat(this.textFieldLongitude.getText().toString());
		boolean video = Boolean.parseBoolean(this.textFieldVideo.getText().toString());
		boolean termometro = Boolean.parseBoolean(this.textFieldTermometro.getText().toString());
		boolean co2 = Boolean.parseBoolean(this.textFieldCO2.getText().toString());
		boolean ch4 = Boolean.parseBoolean(this.textFieldCH4.getText().toString());

		this.logic.addEuclideanUnity(id, latitude, longitude, video, termometro, co2, ch4);
	}
}
