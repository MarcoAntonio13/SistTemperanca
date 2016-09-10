package converter;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter {
	
	public Date localDateConvert(LocalDate data) {
			return new Date(data.toEpochDay());
	}
	
	public static Date convertToDatabaseColumn(LocalDate entityValue) {
		if (entityValue != null) {
			return java.sql.Date.valueOf(entityValue);
		}
		return null;
	}
	
	public static LocalDate convertToEntityAttribute(Date databaseValue) {
		if (databaseValue != null) {
			return databaseValue.toLocalDate();
		}
		return null;
	}

	public LocalDate dateConvert(Date databaseValue) {
		if (databaseValue != null) {
			return databaseValue.toLocalDate();
		}
		return null;
	}
	
}
