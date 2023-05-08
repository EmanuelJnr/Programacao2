package Lista03;
public class Contas {
	public static void main(String[] args) {
		int x = 7/2;
		int y = (x++ % 2 == 0)? 2 : 3;
		int z = ++x + y--;
		int w = ((z-x) < ++y)? 10 : 20;
		System.out.println(w);
	}
}