package app;

import java.sql.Date;
import java.util.Calendar;

public class TesteCalendar {
	public static void main(String[]args){
		Calendar c = Calendar.getInstance();
		Date data = new Date(c.getTime().getTime());
		System.out.println("Data e hora atual: "+ c.getTime());
		System.out.println("SQL Date "+ data.toString());
	}
}
