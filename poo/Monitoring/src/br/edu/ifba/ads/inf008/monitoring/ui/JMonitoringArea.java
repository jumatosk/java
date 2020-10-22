package br.edu.ifba.ads.inf008.monitoring.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifba.ads.inf008.monitoring.entities.Unity;
import br.edu.ifba.ads.inf008.monitoring.exception.UnityException;
import br.edu.ifba.ads.inf008.monitoring.session.AppMonitoring;
import br.edu.ifba.ads.inf008.monitoring.session.AppMonitoringIF;

import java.awt.Label;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JMonitoringArea extends JFrame implements ActionListener {

	private Label abscissa;
	private Label ordenada;
	private Label video;
	private Label termometro;
	private Label co2;
	private Label CH4;
	private Label idResult;

	private TextField textFieldAbcissa;
	private TextField textFieldOrdenada;
	private TextField textFieldVideo;
	private TextField textFieldTermometro;
	private TextField textFieldCO2;
	private TextField textFieldCH4;

	private Button buttonMonitorar;
	private Button buttonBuscar;
	private Button adicionarUnidade;
	private Button buttonAtualizar;

	private JPanel contentPane;
	private AppMonitoringIF logic;
	private Unity unity;

	private JAddUnity jAddManhattan;
	private Button buttonApagar;
	private Button buttonListar;

	public JMonitoringArea() throws SQLException {
		setTitle("\u00C1rea de Monitoramento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		this.abscissa = new Label("Abcissa");
		this.abscissa.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.abscissa.setBounds(60, 24, 56, 24);
		this.abscissa.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(this.abscissa);

		this.ordenada = new Label("Ordenada");
		this.ordenada.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.ordenada.setBounds(319, 24, 70, 24);
		contentPane.add(this.ordenada);

		this.textFieldAbcissa = new TextField();
		this.textFieldAbcissa.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldAbcissa.setBounds(133, 24, 130, 24);
		contentPane.add(this.textFieldAbcissa);

		this.textFieldOrdenada = new TextField();
		this.textFieldOrdenada.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldOrdenada.setBounds(407, 24, 130, 24);
		contentPane.add(this.textFieldOrdenada);

		this.video = new Label("V\u00EDdeo");
		this.video.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.video.setBounds(60, 122, 56, 24);
		contentPane.add(this.video);

		this.textFieldVideo = new TextField();
		this.textFieldVideo.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldVideo.setBounds(133, 122, 130, 24);
		contentPane.add(this.textFieldVideo);

		this.termometro = new Label("Term\u00F4metro");
		this.termometro.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.termometro.setBounds(308, 122, 81, 24);
		contentPane.add(this.termometro);

		this.textFieldTermometro = new TextField();
		this.textFieldTermometro.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldTermometro.setBounds(407, 122, 130, 24);
		contentPane.add(this.textFieldTermometro);

		this.co2 = new Label("CO2");
		this.co2.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.co2.setBounds(83, 213, 33, 24);
		contentPane.add(this.co2);

		this.textFieldCO2 = new TextField();
		this.textFieldCO2.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldCO2.setBounds(133, 213, 130, 24);
		contentPane.add(this.textFieldCO2);

		this.CH4 = new Label("CH4");
		this.CH4.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.CH4.setBounds(356, 213, 33, 24);
		contentPane.add(this.CH4);

		this.textFieldCH4 = new TextField();
		this.textFieldCH4.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldCH4.setEnabled(true);
		this.textFieldCH4.setEditable(true);
		this.textFieldCH4.setBounds(407, 213, 130, 24);
		contentPane.add(this.textFieldCH4);

		this.idResult = new Label();
		this.idResult.setAlignment(Label.CENTER);
		this.idResult.setFont(new Font("Calibri", Font.BOLD, 16));
		this.idResult.setBounds(10, 268, 607, 24);
		this.idResult.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(this.idResult);

		this.buttonMonitorar = new Button("Monitorar");
		this.buttonMonitorar.addActionListener(this);
		this.buttonMonitorar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonMonitorar.setBounds(331, 308, 111, 37);
		contentPane.add(this.buttonMonitorar);

		this.buttonBuscar = new Button("Buscar");

		this.buttonBuscar.addActionListener(this);
		this.buttonBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonBuscar.setBounds(173, 308, 111, 37);
		contentPane.add(this.buttonBuscar);

		this.adicionarUnidade = new Button("Adicionar");
		this.adicionarUnidade.addActionListener(this);
		this.adicionarUnidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.adicionarUnidade.setBounds(10, 379, 116, 37);
		contentPane.add(this.adicionarUnidade);

		this.buttonApagar = new Button("Apagar");
		this.buttonApagar.addActionListener(this);
		this.buttonApagar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonApagar.setBounds(173, 379, 116, 37);
		contentPane.add(this.buttonApagar);

		this.buttonListar = new Button("Listar");
		this.buttonListar.addActionListener(this);
		this.buttonListar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonListar.setBounds(338, 379, 116, 37);
		contentPane.add(this.buttonListar);
		
		this.buttonAtualizar = new Button("Atualizar");
		this.buttonAtualizar.addActionListener(this);
		this.buttonAtualizar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonAtualizar.setBounds(501, 379, 116, 37);
		contentPane.add(this.buttonAtualizar);

		this.logic = new AppMonitoring();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.buttonBuscar)) {
			this.buscar();
		} else if (arg0.getSource().equals(this.buttonMonitorar)) {
			this.monitorar();
		} else if (arg0.getSource().equals(this.adicionarUnidade)) {
			try {
				new JAddUnity().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (arg0.getSource().equals(this.buttonApagar)) {
			try {
				new JDeleteUnity().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (arg0.getSource().equals(this.buttonListar)) {
			try {
				new JGetAllUnities().frmListarTodasUnidades.setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(arg0.getSource().equals(this.buttonAtualizar)) {
			try {
				new JUpdateUnity().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void buscar() {
		float abscissa = Float.parseFloat(textFieldAbcissa.getText().toString());
		float ordenada = Float.parseFloat(textFieldOrdenada.getText().toString());
		boolean video = Boolean.parseBoolean(textFieldVideo.getText().toString());
		boolean termometro = Boolean.parseBoolean(textFieldTermometro.getText().toString());
		boolean co2 = Boolean.parseBoolean(textFieldCO2.getText().toString());
		boolean ch4 = Boolean.parseBoolean(textFieldCH4.getText().toString());
		Unity unity = null;

		try {
			unity = this.logic.possibleUnity(abscissa, ordenada, video, termometro, co2, ch4);
			this.idResult.setText("Unidade mais próxima: " + unity.getId());
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Preencha os campos corretamente");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Unidades não encontrada para essa configuração");
		}  catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado");
		}
	}

	private void monitorar() {
		float abscissa = Float.parseFloat(textFieldAbcissa.getText().toString());
		float ordenada = Float.parseFloat(textFieldOrdenada.getText().toString());
		boolean video = Boolean.parseBoolean(textFieldVideo.getText().toString());
		boolean termometro = Boolean.parseBoolean(textFieldTermometro.getText().toString());
		boolean co2 = Boolean.parseBoolean(textFieldCO2.getText().toString());
		boolean ch4 = Boolean.parseBoolean(textFieldCH4.getText().toString());
		String idTxt;

		try {
			idTxt = this.logic.monitorar(abscissa, ordenada, video, termometro, co2, ch4);

			JOptionPane.showMessageDialog(this, "Unidade " + idTxt + " transladada para o local informado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws Exception {
		try {
			JMonitoringArea frame = new JMonitoringArea();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
