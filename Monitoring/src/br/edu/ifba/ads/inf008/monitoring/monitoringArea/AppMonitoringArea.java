package br.edu.ifba.ads.inf008.monitoring.monitoringArea;

import br.edu.ifba.ads.inf008.monitoring.ui.JMonitoringArea;


public class AppMonitoringArea {
	private JMonitoringArea ui;
	
	public void loadClass() throws Exception{
		this.ui = new JMonitoringArea();
	}
	
	public void asm() throws Exception {
		this.loadClass();
		this.ui.run();
	}
	
	public static void main(String[] args) throws Exception {
		(new AppMonitoringArea()).asm();
	}
}
