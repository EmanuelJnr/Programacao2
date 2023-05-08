package Lista03;

public class Nutricionista {
	String resultado;
	public String avaliarIMC(Paciente pac) {
		float imc = (float) (pac.getPeso()/Math.pow(pac.getAltura(), 2));
		if (imc >= 30)
			resultado = "Obesidade";
		else if (imc >= 25)
			resultado = "Sobrepeso";
		else if (imc >= 18.5)
			resultado = "Normal";
		else
			resultado = "Baixo peso";
		return resultado;
	}
}