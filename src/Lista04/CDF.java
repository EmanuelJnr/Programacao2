package Lista04;
public class CDF {
	public boolean ePerfeito(int n) {
		int soma = 0;
		
		for(int i=1;i<n;i++) {
			if(n % i == 0)
				soma += i;
		}
		
		if(soma == n)
			return true;
		return false;
	}
}