package Metricas;

import java.util.ArrayList;
import java.util.Map;

import ClasesTipo.Clase;

public abstract class PMA {

	 protected static ArrayList<Clase> listaC=new ArrayList<Clase>();

	 protected static double TAC;
	 
	 protected static double TVPrC=0;//TOTAL VARAIBLES PROTEGIDAS POR CLASE
	 protected static double TVPr=0;//TOTAL VARIABLES PROTEGIDAS
	 protected double PMAPr;//RESULTADO DE LA METRICA PROTEGIDA
	 
	 protected static double TVP=0;//TOTAL VARIABLES PRIBADAS
	 protected double TVPC=0;//TOTAL VARIABLES PRIVADAS POR CLASE
	 protected double PMAP;//RESULTADO DE METRICA PRIVADA
	 
	 protected double PM;//RESULTADO DE METRICA NO PUBLICA
	 protected static double TVPu=0;//TOTAL VARIABLES NO PUBLICAS
	 protected double TVPuC=0;//TOTAL VARIABLES NO PUBLICAS POR CLASE
	 
	 protected static double TVF=0;//TOTAL VARIABLES FRIENDLY
	 protected double TVFC=0;//TOTAL VARIABLES FRIENDLY POR CLASE
	 protected double PMAF;//RESULTADO DE METRICA FRIENDLY
	 
	 protected double TPM;//total de proteccion modular
	
	
	abstract double calcular();

	protected boolean buscarPalabra ( String palabra,  String frase) {
		boolean encontrado=false;
		String[] palabras;
		if(frase.contains(palabra)) {
			palabras = frase.split("\\W+");
			for(String palb:palabras) {
				if(palb.equals(palabra)) {
					encontrado=true;
				}
			}
		}else {
			frase=frase.replace(" ","");
			if(frase.contains(palabra)) {
				encontrado=true;
			}
		}
		return  encontrado;
	}
	
	protected String valifcalif(String variable) {
		String resp=null;
		String[] calificadores={"public","protected","private"};
		
		
			for(String calif:calificadores) {
				if(buscarPalabra(calif, variable)) {
					resp=calif;
				}
			}
			if (resp==null) {
				resp="";
			}
		
		return resp;
	}
	
	
	protected boolean buscarEnImportaciones(Clase claseA, Clase ClaseB) {
        boolean encontradoEnImportaciones = false;
        String paqueteNombre = claseA.getPaquete() + "." + claseA.getNombre();

        for (String importacion : ClaseB.getImportaciones()) {
            if (importacion.contains(paqueteNombre)) {
                encontradoEnImportaciones = true;
            }
            if (encontradoEnImportaciones) {
                break;
            }
        }
        return encontradoEnImportaciones;
    }
	
	protected String obtenernombre(String variable) {
		String[] nom=variable.split("=");
		return nom[0].trim();
	}
	
}
