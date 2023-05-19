package Lista12;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.sql.Date;

public class MinhaData {
	private String strDate;
	
	public MinhaData(String strDate) throws DateTimeParseException{
		String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dTF = DateTimeFormatter.ofPattern(dateFormat)
	    		.withResolverStyle(ResolverStyle.STRICT);
	    LocalDate dataValida = LocalDate.parse(strDate, dTF);
	    
        Date date = Date.valueOf(dataValida);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        setStrDate(format.format(date));
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
}