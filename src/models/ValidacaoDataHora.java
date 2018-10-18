package models;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidacaoDataHora {

	public static Time retornaHora(String texto) {
		Time hora;
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		Date data = null;
		
		try {
			data = (Date) formatador.parse(texto + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		hora = new Time(data.getTime());
		
		return hora;
	}
	
	public static Date retornaData(String texto) {
		Date dt = null;
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(texto);
		try {
			dt = (Date) formatador.parse(texto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dt;
	}
	
}
