package Metricas;

import java.util.ArrayList;
import java.util.Map;

import ClasesTipo.Clase;

public class PMAP extends PMA{



	public double calcular() {

		for (Clase cA:listaC) {
			if(!cA.getEsInterfaz() && cA.getVariables().size()!=0) {
				for(Map.Entry<String, String> var:cA.getVar_b().entrySet()) {
					for(String varcalif: cA.getVariables()) {
						if(buscarPalabra(obtenernombre(var.getKey()),varcalif) && valifcalif(varcalif).equals("private")) {
							TVPC++;
						}
					}
				}
				TAC=TAC+cA.getVar_b().size();
				TVP=TVP+TVPC;
				//System.out.println("Nivel de protección modular privada de la clase "+cA.getNombre()+" : "+TVPC+"/"+cA.getVar_b().size()+"="+(TVPC/cA.getVar_b().size()));
				TVPC=0;
			}
		}
		
		PMAP=TVP/TAC;
		System.out.println("Nivel de protección modular private del proyecto : "+TVP+"/"+TAC+"="+PMAP);
		return PMAP;
	}

}
