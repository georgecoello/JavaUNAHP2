import java.util.scanner;
public class usoCicloFor{
	public static void main (String [] args ){
	String [][] empleado = new String [10][9];
	Scanner sc = new Scanner (System.in);
	int i;
	
	for(i=0; i<10 ; i++){
		int j =0;
		System.out.print("Ingrese el numero de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el nombre de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;		
		System.out.print("Ingrese el numero de identidad: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese la fecha de nacimiento: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el genero del empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el celular de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el ingreso de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el salario de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		System.out.print("Ingrese el cargo de empleado: ");
		empleado[i][j] = sc.nextline();
		j++;
		
		}
	for (i=0; i<empleado.length ; i++){
		for (int j=0; j<empleado[0].length ; j++){
			if (empleado[i][j] != null)
			System.out.println(empleado[i][j]);
		}
	}
	
	}
}