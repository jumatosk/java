package br.edu.ifba.ads.inf008.monitoring.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.Window;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifba.ads.inf008.monitoring.entities.Euclidean;
import br.edu.ifba.ads.inf008.monitoring.entities.Manhattan;
import br.edu.ifba.ads.inf008.monitoring.entities.Unity;
import br.edu.ifba.ads.inf008.monitoring.session.AppMonitoring;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JGetAllUnities extends JFrame{

	public JFrame frmListarTodasUnidades;
	private JTable table;
	private AppMonitoring logic;
	private boolean tipo;
	private String tipoUnidade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JGetAllUnities window = new JGetAllUnities();
					window.frmListarTodasUnidades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public JGetAllUnities() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frmListarTodasUnidades = new JFrame();
		frmListarTodasUnidades.setTitle("Listar todas unidades monitoras");
		frmListarTodasUnidades.setBounds(100, 100, 794, 464);
		frmListarTodasUnidades.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarTodasUnidades.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 55, 752, 300);
		frmListarTodasUnidades.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Latitude", "Longitude", "V\u00EDdeo", "Term\u00F4metro", "CO2", "CH4", "Tipo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Float.class, Float.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		Label unidades = new Label("Unidades Monitoras");
		unidades.setFont(new Font("Calibri", Font.PLAIN, 18));
		unidades.setAlignment(Label.CENTER);
		unidades.setBounds(12, 10, 752, 39);
		frmListarTodasUnidades.getContentPane().add(unidades);
		
		Button buttonBuscar = new Button("Listar Unidades");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel  = (DefaultTableModel) table.getModel();
				
				tableModel.setRowCount(0);
				
				try {
					ArrayList<Unity> unities = logic.getAll();
					unities.forEach((Unity u) -> {
						tipo = getTipo(u);
						
						if(tipo) {
							tipoUnidade = "0.Euclidiana";
						} else {
							tipoUnidade = "1.Manhattan";
						}
						
						tableModel.addRow(new Object[] {
								u.getId(),
								u.getPoint().getLatitude(),
								u.getPoint().getLongitude(),
								u.isVideoCamera(),
								u.isThermomether(),
								u.isCo2(),
								u.isCh4(),
								tipoUnidade,
						});
					});
					table.setModel(tableModel);
					
					if(unities.size() == 0) {
						JOptionPane.showMessageDialog(null, "Não há unidades monitoras");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}				
			}
		});
		buttonBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		buttonBuscar.setBounds(268, 370, 254, 39);
		frmListarTodasUnidades.getContentPane().add(buttonBuscar);
		
		this.logic = new AppMonitoring();
	}
	
	private boolean getTipo(Unity unity) {
		return unity instanceof Euclidean;
	}

}
