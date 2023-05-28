package Lista12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class MinhaData {
	private LocalDate strDate;
	
	public MinhaData(String strDate) throws DateTimeParseException{
	    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/uuuu")
	    		.withResolverStyle(ResolverStyle.STRICT);
	    LocalDate dataValida = LocalDate.parse(strDate, dTF);
        setStrDate(dataValida);
	}
	public LocalDate getStrDate() {
		return strDate;
	}
	public void setStrDate(LocalDate strDate) {
		this.strDate = strDate;
	}
}