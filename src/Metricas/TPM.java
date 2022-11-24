package Metricas;

import java.util.ArrayList;

import ClasesTipo.Clase;

public class TPM extends PMA{

	
	double calcular() {
		//TVPr
		System.out.println(TVP);
		System.out.println(TVPrC);
		System.out.println(TVF);
		TPM=((TVP*1)+(TVPrC*0.75)+(TVF*0.25))/TAC;
		System.out.println("Nivel de protección modular TOTAL del proyecto : "+TPM);
		return TPM;
	}



}
