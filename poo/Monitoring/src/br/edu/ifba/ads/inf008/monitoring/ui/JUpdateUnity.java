package br.edu.ifba.ads.inf008.monitoring.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifba.ads.inf008.monitoring.entities.Euclidean;
import br.edu.ifba.ads.inf008.monitoring.entities.Manhattan;
import br.edu.ifba.ads.inf008.monitoring.entities.Unity;
import br.edu.ifba.ads.inf008.monitoring.exception.UnityException;
import br.edu.ifba.ads.inf008.monitoring.session.AppMonitoring;
import javax.swing.JLabel;

public class JUpdateUnity extends JFrame implements ActionListener{

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
	private Label tipo;
	private JLabel tipoUnidade;
	private TextField textFieldTipo;
	
	private Button atualizar;
	
	private AppMonitoring logic;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUpdateUnity frame = new JUpdateUnity();
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
	public JUpdateUnity() throws SQLException {
		setTitle("Atualizar Unidade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.id = new Label("Id");
		this.id.setAlignment(Label.RIGHT);
		this.id.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.id.setBounds(60, 18, 70, 24);
		contentPane.add(this.id);

		this.textFieldId = new TextField();
		this.textFieldId.setBackground(Color.WHITE);
		this.textFieldId.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldId.setBounds(136, 18, 70, 24);
		contentPane.add(this.textFieldId);

		this.latitude = new Label("Latitude");
		this.latitude.setAlignment(Label.RIGHT);
		this.latitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.latitude.setBounds(62, 73, 70, 24);
		contentPane.add(this.latitude);

		this.textFieldLatitude = new TextField();
		this.textFieldLatitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLatitude.setBounds(138, 73, 70, 24);
		contentPane.add(this.textFieldLatitude);

		this.longitude = new Label("Longitude");
		this.longitude.setAlignment(Label.RIGHT);
		this.longitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.longitude.setBounds(65, 133, 70, 24);
		contentPane.add(this.longitude);

		this.textFieldLongitude = new TextField();
		this.textFieldLongitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLongitude.setBounds(141, 133, 70, 24);
		contentPane.add(this.textFieldLongitude);

		this.video = new Label("V\u00EDdeo");
		this.video.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.video.setAlignment(Label.RIGHT);
		this.video.setBounds(65, 196, 70, 24);
		contentPane.add(this.video);

		this.textFieldVideo = new TextField();
		this.textFieldVideo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldVideo.setBounds(141, 196, 70, 24);
		contentPane.add(this.textFieldVideo);

		this.termometro = new Label("Term\u00F4metro");
		this.termometro.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.termometro.setAlignment(Label.RIGHT);
		this.termometro.setBounds(252, 18, 99, 24);
		contentPane.add(this.termometro);

		this.textFieldTermometro = new TextField();
		this.textFieldTermometro.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldTermometro.setBounds(357, 18, 70, 24);
		contentPane.add(this.textFieldTermometro);

		this.co2 = new Label("CO2");
		this.co2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.co2.setAlignment(Label.RIGHT);
		this.co2.setBounds(281, 73, 70, 24);
		contentPane.add(this.co2);

		this.textFieldCO2 = new TextField();
		this.textFieldCO2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldCO2.setBounds(357, 73, 70, 24);
		contentPane.add(this.textFieldCO2);

		this.ch4 = new Label("CH4");
		this.ch4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.ch4.setAlignment(Label.RIGHT);
		this.ch4.setBounds(281, 133, 70, 24);
		contentPane.add(this.ch4);

		this.textFieldCH4 = new TextField();
		this.textFieldCH4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldCH4.setBounds(357, 133, 70, 24);
		contentPane.add(this.textFieldCH4);

		this.atualizar = new Button("Atualizar");
		this.atualizar.addActionListener(this);
		this.atualizar.setEnabled(true);
		this.atualizar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.atualizar.setBounds(161, 258, 179, 39);
		contentPane.add(this.atualizar);
		
		this.tipo = new Label("Tipo");
		this.tipo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.tipo.setAlignment(Label.RIGHT);
		this.tipo.setBounds(281, 196, 70, 24);
		contentPane.add(this.tipo);
		
		this.textFieldTipo = new TextField();
		this.textFieldTipo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldTipo.setBounds(357, 196, 70, 24);
		contentPane.add(this.textFieldTipo);
		
		this.tipoUnidade = new JLabel("0-Euclidiana 1-Manhattan");
		this.tipoUnidade.setFont(new Font("Calibri", Font.PLAIN, 12));
		this.tipoUnidade.setBounds(315, 226, 172, 26);
		contentPane.add(this.tipoUnidade);
		
		this.logic = new AppMonitoring();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.atualizar)) {
			String id = this.textFieldId.getText();
			float latitude = Float.parseFloat(this.textFieldLatitude.getText().toString());
			float longitude = Float.parseFloat(this.textFieldLongitude.getText().toString());
			int tipo = Integer.parseInt(this.textFieldTipo.getText().toString());
			boolean video = Boolean.parseBoolean(this.textFieldVideo.getText().toString());
			boolean termometro = Boolean.parseBoolean(this.textFieldTermometro.getText().toString());
			boolean co2 = Boolean.parseBoolean(this.textFieldCO2.getText().toString());
			boolean ch4 = Boolean.parseBoolean(this.textFieldCH4.getText().toString());
			Unity unity = null;
			
			try {				
				if(tipo == 0) {
					unity = new Euclidean(id, latitude, longitude, video, termometro, co2, ch4);
					this.logic.update(unity);
				} 
				else if(tipo == 1) {
					unity = new Manhattan(id, latitude, longitude, video, termometro, co2, ch4);
					this.logic.update(unity);
				}
				JOptionPane.showMessageDialog(this, "Unidade atualizada!");
			}
			catch (UnityException e) {
				JOptionPane.showMessageDialog(this, "Não há unidade com o id: " + id);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
