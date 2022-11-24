package Metricas;

import java.util.ArrayList;
import java.util.Map;

import ClasesTipo.Clase;

public class PM extends PMA{


	public double calcular() {

		for (Clase cA:listaC) {
			System.out.println(listaC.size());
			if(!cA.getEsInterfaz() && cA.getVariables().size()!=0) {
				for(Map.Entry<String, String> var:cA.getVar_b().entrySet()) {
					for(String varcalif: cA.getVariables()) {
						if(buscarPalabra(obtenernombre(var.getKey()),varcalif) && !valifcalif(varcalif).equals("public")) {
							TVPuC++;
						}
					}
				}
				TVPu=TVPu+TVPuC;
				//System.out.println("Nivel de protección modular (VARIABLES NO PUBLICAS) de la clase "+cA.getNombre()+" : "+TVPu+"/"+TVPuC+" = "+(TVPuC/cA.getVar_b().size()));
				TVPuC=0;
			}
		}
		
		PM=TVPu/TAC;
		System.out.println("Nivel de protección modular no publico del proyecto : "+TVPu+"/"+TAC+"="+PM);
		return PM;
	}
	
}
