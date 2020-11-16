//David Abell�n Navarro 1�DAM
//https://github.com/Naabda/Ejercicio6/blob/main/MejoraEjercicio7DavidAbellanNavarro.java
package EjerciciosEntregados;

import java.util.Scanner;

public class MejoraEjercicio7DavidAbellanNavarro {
	
	private static Scanner teclado = new Scanner (System.in);
	//Contador aux.
	private static int contador=1;
	//Vector para nombres
	private static String [] aNombre= new String [contador];

	//Matriz donde
	//Columna 0 es Tama�o, Columna 1 es Densidad y Columna 2 es el tama�o por densidad.
	private static int [][] mValores= new int [contador][3];


	//Asignacion de las variables a los diferentes terrenos.
	private static void asignacion () {

		//Inicializacion y predefinicion variables
		String [] aNombreNew = new String [1];
		int [][] mValoresNew = new int [1][3];
		String Respuesta;
		boolean extractor=true;

		System.out.println("Vamos asignar valores a los terrenos\n");

		//Entrada datos.
		do {
			//Predefinicion matrices.

			for (int i = (contador-1); i < contador; i++) {

				System.out.println("Vamos a crear el "+contador+"� terreno");
				System.out.println("�C�mo se llama este terreno?");
				String Nombre=teclado.next();
				aNombre [i]=Nombre;

				System.out.println("�Qu� tama�o tiene?");
				int tama�o=teclado.nextInt();
				mValores [i][0]=tama�o;

				System.out.println("�Y la densidad del terreno?");
				int densidad=teclado.nextInt();
				mValores [i][1]= densidad;
				mValores [i][2]= mValores[i][0]*mValores[i][1];

				aNombreNew=new String [contador+1];
				mValoresNew=new int [contador+1][3];

				for (int k = 0; k < aNombreNew.length; k++) {
					aNombreNew[k]= "Sin nombre";
				}
				//Copiamos valores en array auxiliar.
				for (int j = 0; j <contador; j++) {
					aNombreNew[j] = aNombre[j];
				}

				//Copiamos valores en matriz auxiliar.
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k <contador; k++) {
						mValoresNew[k][j]=mValores[k][j];
					}
				}
				contador++;

				aNombre=new String [contador];
				mValores=new int [contador][3];

				aNombre=aNombreNew;
				mValores=mValoresNew;

				System.out.println("�Quieres a�adir otro terreno? si/no");
				Respuesta=teclado.next();
				if (Respuesta.equals("si")) {

				} else {
					extractor=false;
					break;
				}
				if (Respuesta.equals("no")) {
					extractor = false;
					break;
				}
			}

		}
		while(extractor==true);

	}

	//Vamos a mostrar los resultados de lo recogido anteriormente.
	private static void consulterrenos () {

		System.out.println("Estos son los terrenos ingresados.");

		for (int i = 0; i < aNombre.length; i++) {
			if (aNombre[i] != "Sin nombre") {
				System.out.println((i+1)+". "+aNombre[i]);
			}
		}

		System.out.println("\nN�mero de terreno a consultar");
		int Nterreno=teclado.nextInt();
		Nterreno--;
		System.out.println("El terreno "+(Nterreno+1)+". "+aNombre[Nterreno]+" hay que reforestarlo con "+mValores[Nterreno][2]+" �rboles.\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programa que representando la situaci�n copiada en la libreta nos diga la cantidad
		// de �rboles que necesitamos para reforestar cada zona y cuantos �rboles necesitamos en total.

		//Definimos variables.
		int opcion;
		int Total=0;
		boolean continuar=true;

		System.out.println("Vamos a crear un mapa");

		//Creamos un men� para poder realizar las acciones m�s facilmente.
		do {
			//Definir opciones men�
			System.out.println("\n1. Asignaci�n de los terrenos.");
			System.out.println("2. Consultas terrenos.");
			System.out.println("3. Consulta total �rboles.");
			System.out.println("4. Salir.");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				asignacion ();
				break;
			case 2:
				consulterrenos ();
				break;
			case 3:
				for (int i = 0; i < mValores.length; i++) {
					Total= mValores[i][2]+Total;
				}
				System.out.println("El total de �rboles que necesitamos es: "+Total);
				break;
			case 4:
				continuar = false;
				break;
			default:
				System.out.println("Inserte una opci�n correcta");
				break;
			}
		}
		while (continuar);

	}
}
