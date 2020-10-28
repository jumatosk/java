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
import java.awt.Checkbox;

public class JUpdateUnity extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private Label id;
	private TextField textFieldId;
	private Label latitude;
	private TextField textFieldLatitude;
	private Label longitude;
	private TextField textFieldLongitude;
	private Label tipo;
	private JLabel tipoUnidade;
	private TextField textFieldTipo;
	
	private Button atualizar;
	
	private AppMonitoring logic;
	private Checkbox checkboxVideo;
	private Checkbox checkboxThermomether;
	private Checkbox checkboxCo2;
	private Checkbox checkboxCh4;
	

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
		setBounds(100, 100, 338, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.id = new Label("Id");
		this.id.setAlignment(Label.RIGHT);
		this.id.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.id.setBounds(10, 18, 70, 24);
		contentPane.add(this.id);

		this.textFieldId = new TextField();
		this.textFieldId.setBackground(Color.WHITE);
		this.textFieldId.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldId.setBounds(86, 18, 70, 24);
		contentPane.add(this.textFieldId);

		this.latitude = new Label("Latitude");
		this.latitude.setAlignment(Label.RIGHT);
		this.latitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.latitude.setBounds(10, 73, 70, 24);
		contentPane.add(this.latitude);

		this.textFieldLatitude = new TextField();
		this.textFieldLatitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLatitude.setBounds(86, 73, 70, 24);
		contentPane.add(this.textFieldLatitude);

		this.longitude = new Label("Longitude");
		this.longitude.setAlignment(Label.RIGHT);
		this.longitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.longitude.setBounds(10, 122, 70, 24);
		contentPane.add(this.longitude);

		this.textFieldLongitude = new TextField();
		this.textFieldLongitude.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldLongitude.setBounds(86, 122, 70, 24);
		contentPane.add(this.textFieldLongitude);

		this.atualizar = new Button("Atualizar");
		this.atualizar.addActionListener(this);
		this.atualizar.setEnabled(true);
		this.atualizar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.atualizar.setBounds(67, 260, 179, 39);
		contentPane.add(this.atualizar);
		
		this.tipo = new Label("Tipo");
		this.tipo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.tipo.setAlignment(Label.RIGHT);
		this.tipo.setBounds(10, 174, 70, 24);
		contentPane.add(this.tipo);
		
		this.textFieldTipo = new TextField();
		this.textFieldTipo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.textFieldTipo.setBounds(86, 174, 70, 24);
		contentPane.add(this.textFieldTipo);
		
		this.tipoUnidade = new JLabel("0-Euclidiana 1-Manhattan");
		this.tipoUnidade.setFont(new Font("Calibri", Font.PLAIN, 12));
		this.tipoUnidade.setBounds(20, 204, 148, 26);
		contentPane.add(this.tipoUnidade);
		
		this.checkboxVideo = new Checkbox("V\u00EDdeo");
		this.checkboxVideo.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxVideo.setBounds(185, 18, 108, 24);
		contentPane.add(this.checkboxVideo);
		
		this.checkboxThermomether = new Checkbox("Term\u00F4metro");
		this.checkboxThermomether.setEnabled(true);
		this.checkboxThermomether.setState(false);
		this.checkboxThermomether.setFont(new Font("Calibri", Font.PLAIN, 16));
		checkboxThermomether.setBounds(185, 73, 108, 24);
		contentPane.add(this.checkboxThermomether);
		
		this.checkboxCo2 = new Checkbox("CO2");
		this.checkboxCo2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxCo2.setBounds(185, 122, 108, 24);
		contentPane.add(this.checkboxCo2);
		
		this.checkboxCh4 = new Checkbox("CH4");
		this.checkboxCh4.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxCh4.setBounds(185, 174, 108, 24);
		contentPane.add(this.checkboxCh4);
		
		this.logic = new AppMonitoring();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.atualizar)) {
			String id = this.textFieldId.getText();
			float latitude = Float.parseFloat(this.textFieldLatitude.getText().toString());
			float longitude = Float.parseFloat(this.textFieldLongitude.getText().toString());
			int tipo = Integer.parseInt(this.textFieldTipo.getText().toString());
			boolean video = this.checkboxVideo.getState();
			boolean termometro = this.checkboxThermomether.getState();
			boolean co2 = this.checkboxCo2.getState();
			boolean ch4 = this.checkboxCh4.getState();
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
