package converter;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter {
	
	public Date localDateConvert(LocalDate data) {
			return new Date(data.toEpochDay());
	}

	public LocalDate dateConvert(Date databaseValue) {
		if (databaseValue != null) {
			return databaseValue.toLocalDate();
		}
		return null;
	}
	
}
