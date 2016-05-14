
public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		ConnSql sql = new ConnSql();
		sql.connect();
		sql.inData();
		sql.outData();
		sql.close();
		
		long time = System.currentTimeMillis() - start;
		System.out.println("‘À––∫ƒ ±= "+time+" ∫¡√Î");
	}
}
