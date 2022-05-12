package com.foxcreations.springtest.app.util;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

public class Fechas {
	
	
	public Map<LocalDate , LocalDate> calculaMesInicioYFinal(Integer numeroMes){
		
		LocalDate diaInicialMes=LocalDate.of(LocalDate.now().getYear(), numeroMes, 1);
		LocalDate finalDiaMes= diaInicialMes.with(TemporalAdjusters.lastDayOfMonth());
		Map<LocalDate,LocalDate> fechas= new HashMap<LocalDate, LocalDate>();
		fechas.put(diaInicialMes,finalDiaMes );
		return fechas;
	}
	

}
