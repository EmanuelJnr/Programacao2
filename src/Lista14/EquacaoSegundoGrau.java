package Lista14;

public abstract class EquacaoSegundoGrau {
	private static double delta(int a, int b, int c) {
		return b * b - 4 * a * c;
	}

	public static double getX(int a, int b, int c, boolean isX1) throws NaoHaSolucaoRealException {
		double delta = delta(a, b, c);

		if (delta < 0)
			throw new NaoHaSolucaoRealException();
		if (isX1)
			return ( -1 * b + Math.sqrt(delta) ) / ( 2 * a);
		else
			return ( -1 * b - Math.sqrt(delta) ) / ( 2 * a);
	}
}