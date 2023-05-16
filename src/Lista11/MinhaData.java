package Lista11;

public class MinhaData implements ClasseComparavel{
	private int dia;
	private int mes;
	private int ano;
	
	public MinhaData(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}
	public String toString() {
		return dia+"/"+mes+"/"+ano;
	}
	public int comparacao(Object o) {
		MinhaData md = (MinhaData)o;
		
		if(md.getAno()<ano)
			return 1;
		else if(md.getAno()==ano) {
			if(md.getMes()<mes)
				return 1;
			else if(md.getMes()==mes) {
				if(md.getDia()<dia)
					return 1;
				else if(md.getDia()==dia)
					return 0;
				return -1;
			}
			return -1;
		}
		return -1;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
}