package uniandes.cupi2.simuladorBancario.mundo;

public class Cuenta {
	
	public float saldoPromedio(int meses, double saldo, double intereses) {
			
			float saldoPrincipal = (float) saldo;
			float sumaSaldos = 0;
			
			for (int i = 1; i <= meses; i++) {
				saldoPrincipal = (float) (saldoPrincipal * (1 + intereses));
				sumaSaldos += saldoPrincipal;
			}
			
			return sumaSaldos / meses;
		}

}
