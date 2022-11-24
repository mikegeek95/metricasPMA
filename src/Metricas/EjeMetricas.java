package Metricas;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ClasesTipo.Clase;

public class EjeMetricas {
	
	public Void ProteccionMoular(ArrayList<Clase> listaC){
		
		PMA.listaC=listaC;

		PMA pmap=new PMAP();
		PMA pmapr=new PMAPr();
		PMA pmaf=new PMAF();
		PMA pm=new PM();
		PMA tpm=new TPM();
		
		
		
		panel(pmap.calcular(),pmapr.calcular(),pmaf.calcular(),pm.calcular(),tpm.calcular());
		return null;
	}
	
	
	private void panel(double calcular, double calcular2, double calcular3, double calcular4, double calcular5) {
		DecimalFormat format = new DecimalFormat("0.0000");
		
		calcular = (Double.isNaN(calcular))?0.0:calcular;
		calcular2 = (Double.isNaN(calcular2))?0.0:calcular2;
		calcular3 = (Double.isNaN(calcular3))?0.0:calcular3;
		calcular4 = (Double.isNaN(calcular4))?0.0:calcular4;
		calcular5 = (Double.isNaN(calcular5))?0.0:calcular5;
		
		JFrame frame = new JFrame("Resultado de Métricas PMA");
		
		JLabel label1=new JLabel("Resultado de metrica PMAP  : "+format.format(calcular));
		JLabel label2=new JLabel("Resultado de metrica PMAPr : "+format.format(calcular2));
		JLabel label3=new JLabel("Resultado de metrica PMAF  : "+format.format(calcular3));
		JLabel label4=new JLabel("Resultado de metrica PM    : "+format.format(calcular4));
		JLabel label5=new JLabel("Resultado de metrica TPM   : "+format.format(calcular5));
		JLabel label6=new JLabel("Resultado: "+calificativo(calcular5));
		JLabel label7=new JLabel("");
		
		label1.setBounds(60,10,300,20);
		label2.setBounds(60,30,300,20);
		label3.setBounds(60,50,300,20);
		label4.setBounds(60,70,300,20);
		label5.setBounds(60,90,300,20);
		label6.setBounds(100,140,300,20);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		
		frame.setSize(350, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	private String calificativo(double format) {
		String calif="";
		format=format*100;
		// 0% = nulo	20%= deficiente	40%= bajo	60% regular	80% = bueno	100% = excelente
		if(format==0.0) {
			calif="Nulo";
		}
		if(format>0.0 && format<20.0) {
			calif="Deficiente";
		}
		if(format>20.0 && format<40.0) {
			calif="Bajo";
		}
		if(format>40.0 && format<60.0) {
			calif="Regular";
		}
		if(format>60.0 && format<80.0) {
			calif="Bueno";
		}
		if(format>80.0 && format<100.0) {
			calif="Optimo";
		}
		if(format==100.0) {
			calif="Exelente";
		}
		return calif;
	}

}
