package Lista02;

public class Planejador {
	public int estimarAbastecimentos(Carro car, int dist) {
		float maxAutonomia = car.getAutonomia()*car.getCapacidadeDoTanque();
		return (int) (Math.ceil(dist/maxAutonomia));
	}
}