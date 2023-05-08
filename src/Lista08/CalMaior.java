package Lista08;

public class CalMaior {
	public static int maior(int n1, int n2) {
		if(n1>n2)
			return n1;
		return n2;
	}
	public static int maior(int n1, int n2, int n3) {
		return maior(maior(n1,n2),n3);
	}
	public static int maior(int n1, int n2, int n3, int n4) {
		return maior(maior(n1,n2,n3),n4);
	}
	public static int maior(int n1, int n2, int n3, int n4, int n5) {
		return maior(maior(n1,n2,n3,n4),n5);
	}
}