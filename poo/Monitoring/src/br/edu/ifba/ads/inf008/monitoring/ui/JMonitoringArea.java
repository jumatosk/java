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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JMonitoringArea extends JFrame implements ActionListener {

	private Label abscissa;
	private Label ordenada;
	private Label idResult;

	private TextField textFieldAbcissa;
	private TextField textFieldOrdenada;

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
	private JMenuBar menuBar;
	private JMenu mnNewMenuOptions;
	private JMenuItem mntmNewMenuItemAdd;
	private JMenuItem mntmNewMenuItemList;
	private JMenuItem mntmNewMenuItemUpdate;
	private JMenuItem mntmNewMenuItemDelete;
	
	private Checkbox checkboxCo2;
	private Checkbox checkboxThermomether;
	private Checkbox checkboxVideo;
	private Checkbox checkboxCh4;

	public JMonitoringArea() throws SQLException {
		setTitle("\u00C1rea de Monitoramento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 459);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.mnNewMenuOptions = new JMenu("Op\u00E7\u00F5es");
		mnNewMenuOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mnNewMenuOptions.setVisible(true);;
			}
		});
		this.menuBar.add(this.mnNewMenuOptions);
		
		this.mntmNewMenuItemAdd = new JMenuItem("Adicionar");
		this.mntmNewMenuItemAdd.addActionListener(this);
		this.mnNewMenuOptions.add(this.mntmNewMenuItemAdd);
		
		this.mntmNewMenuItemList = new JMenuItem("Listar");
		this.mntmNewMenuItemList.addActionListener(this);
		this.mnNewMenuOptions.add(this.mntmNewMenuItemList);
		
		this.mntmNewMenuItemUpdate = new JMenuItem("Atualizar");
		this.mntmNewMenuItemUpdate.addActionListener(this);
		this.mnNewMenuOptions.add(this.mntmNewMenuItemUpdate);
		
		this.mntmNewMenuItemDelete = new JMenuItem("Apagar");
		this.mntmNewMenuItemDelete.addActionListener(this);
		this.mnNewMenuOptions.add(mntmNewMenuItemDelete);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		this.abscissa = new Label("Abcissa");
		this.abscissa.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.abscissa.setBounds(10, 26, 56, 24);
		this.abscissa.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(this.abscissa);

		this.ordenada = new Label("Ordenada");
		this.ordenada.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.ordenada.setBounds(178, 26, 70, 24);
		contentPane.add(this.ordenada);

		this.textFieldAbcissa = new TextField();
		this.textFieldAbcissa.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldAbcissa.setBounds(72, 26, 82, 24);
		contentPane.add(this.textFieldAbcissa);

		this.textFieldOrdenada = new TextField();
		this.textFieldOrdenada.setFont(new Font("Calibri", Font.PLAIN, 14));
		this.textFieldOrdenada.setBounds(254, 26, 82, 24);
		contentPane.add(this.textFieldOrdenada);

		this.idResult = new Label();
		this.idResult.setAlignment(Label.CENTER);
		this.idResult.setFont(new Font("Calibri", Font.BOLD, 16));
		this.idResult.setBounds(10, 204, 352, 24);
		this.idResult.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(this.idResult);

		this.buttonMonitorar = new Button("Monitorar");
		this.buttonMonitorar.addActionListener(this);
		this.buttonMonitorar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonMonitorar.setBounds(200, 256, 111, 37);
		contentPane.add(this.buttonMonitorar);

		this.buttonBuscar = new Button("Buscar");

		this.buttonBuscar.addActionListener(this);
		this.buttonBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.buttonBuscar.setBounds(44, 256, 111, 37);
		contentPane.add(this.buttonBuscar);
		
		this.checkboxCo2 = new Checkbox("CO2");
		checkboxCo2.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.checkboxCo2.setBounds(72, 166, 60, 24);
		this.contentPane.add(this.checkboxCo2);
		
		checkboxThermomether = new Checkbox("Term\u00F4metro");
		checkboxThermomether.setFont(new Font("Calibri", Font.PLAIN, 16));
		checkboxThermomether.setBounds(225, 106, 108, 24);
		contentPane.add(checkboxThermomether);
		
		checkboxVideo = new Checkbox("V\u00EDdeo");
		checkboxVideo.setFont(new Font("Calibri", Font.PLAIN, 16));
		checkboxVideo.setBounds(69, 106, 108, 24);
		contentPane.add(checkboxVideo);
		
		checkboxCh4 = new Checkbox("CH4");
		checkboxCh4.setBounds(225, 163, 108, 24);
		contentPane.add(checkboxCh4);

		this.logic = new AppMonitoring();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.buttonBuscar)) {
			this.buscar();
		} else if (arg0.getSource().equals(this.buttonMonitorar)) {
			this.monitorar();
		} else if (arg0.getSource().equals(this.mntmNewMenuItemAdd)) {
			try {
				new JAddUnity().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (arg0.getSource().equals(this.mntmNewMenuItemDelete)) {
			try {
				new JDeleteUnity().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (arg0.getSource().equals(this.mntmNewMenuItemList)) {
			try {
				new JGetAllUnities().frmListarTodasUnidades.setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(arg0.getSource().equals(this.mntmNewMenuItemUpdate)) {
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
		boolean video = this.checkboxVideo.getState();
		boolean termometro = this.checkboxThermomether.getState();
		boolean co2 = this.checkboxCo2.getState();
		boolean ch4 = this.checkboxCh4.getState();
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
		boolean video = this.checkboxVideo.getState();
		boolean termometro = this.checkboxThermomether.getState();
		boolean co2 = this.checkboxCo2.getState();
		boolean ch4 = this.checkboxCh4.getState();
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
