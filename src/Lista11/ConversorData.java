package Lista11;

public class ConversorData {
	public static MinhaData dataToMData(String data) {
		String[] dataSplit = data.split("/");
		int[] dataInt = new int[3];
		for(int i=0;i<dataInt.length;i++)
			dataInt[i] = Integer.parseInt(dataSplit[i]);
		
		MinhaData mData = new MinhaData(dataInt[0], dataInt[1], dataInt[2]);
		return mData;
	}
}