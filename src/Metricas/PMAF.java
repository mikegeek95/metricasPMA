package Metricas;

import java.util.Map;
import ClasesTipo.Clase;

public class PMAF extends PMA{
	

	public double calcular() {

		for (Clase cA:listaC) {
			if(!cA.getEsInterfaz() && cA.getVariables().size()!=0) {
				for(Map.Entry<String, String> var:cA.getVar_b().entrySet()) {
					
					for(String varcalif: cA.getVariables()) {
						
						if(buscarPalabra(obtenernombre(var.getKey()),varcalif) && valifcalif(varcalif).equals("")) {
							TVFC++;
						}
					}
				}

				TVF=TVF+TVFC;
				//System.out.println("Nivel de protección modular friendly de la clase "+cA.getNombre()+" "+TVFC+"/"+cA.getVar_b().size()+" : "+(TVFC/cA.getVar_b().size()));
				TVFC=0;
			}
		}
		
		PMAF=TVF/TAC;
		System.out.println("Nivel de protección modular friendly del proyecto : "+TVF+"/"+TAC+"="+PMAF);
		return PMAF;
	}

}
