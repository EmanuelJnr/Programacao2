package Lista05;

public class MaquinaDeLavar {
	public int lavar(Roupa[] roupas) {
		
		for(int i=0;i<roupas.length;i++) {
			for(int j=i+1;j<roupas.length;j++) {
				if(!roupas[i].equals(null) && !roupas[j].equals(null)) {
					if(!roupas[i].getCor().equals(roupas[j].getCor()))
						return -1;
				}
			}
		}
		
		int tempo=0;
		for(Roupa r:roupas) {
			if(r!=null) {
				if(r.getCor().equals(TipoCor.valueOf("BRANCA")))
					tempo++;
				else if(r.getCor().equals(TipoCor.valueOf("COLORIDA")))
					tempo+=2;
				if(r.getEstado().equals(TipoEstado.valueOf("SUJA")))
					tempo+=3;
				if(r.getTamanho().equals(TipoTamanho.valueOf("P")))
					tempo+=3;
				else if(r.getTamanho().equals(TipoTamanho.valueOf("M")))
					tempo+=5;
				else if(r.getTamanho().equals(TipoTamanho.valueOf("G")))
					tempo+=8;
				r.setEstado(TipoEstado.valueOf("LIMPA"));
			}
		}
		return tempo;
	}
}