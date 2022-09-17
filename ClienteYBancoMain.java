//Hace un programa que haga gestiones en un banco. Vas a usar 2 clases (Cliente y Cuenta).Considera que un cliente
//se caracteriza por su nombre,apellido y dni. El cliente puede consultar cuanta plata tiene disponible,
//puede ingresar plata y retirar plata de sus cuentas. Acordate, CUENTASSS, tenes que hacer que el cliente pueda
//hacer todo eso, pero no va a tener una sola cuenta, va a tener mas (pedilas por consola o por donde quieras).
//Y ademas, cada cuenta se caracteriza por un numero de cuenta y su saldo. Cualquier duda me preguntas amigo. Exitos hermanito.

package clientesYBancos; 

import java.util.Scanner;

public class ClienteYBancoMain {
	
public static int buscarNumeroCuenta(Cuenta cuentas[], int n) {
	int i=0,indice=0;
	boolean encontrado=false;
	
	while(i<cuentas.length && encontrado==false) {
		if(cuentas[i].getNumeroCuenta() == n) {
			encontrado = true;
			indice=i;
			
		}
		i++;
	}
	if(encontrado == false) {
		indice = -1;
	}
	return indice;
	
}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String nombre,apellido,dni;
		int numeroCuenta,cantidadCuentas=0,opcionMenu,indiceCuenta;
		double saldo,cantidad;
		
		Cuenta cuentas[];
		Cliente cliente;
		
		System.out.println("Ingrese el nombre del cliente:");
		nombre=reader.next();
		System.out.println("Ingrese el apellido del cliente:");
		apellido=reader.next();
		System.out.println("Ingrese el DNI del cliente:");
		dni=reader.next();
		System.out.println("Ahora ingrese cuantas cuentas tiene:");
		cantidadCuentas=reader.nextInt();
		
		cuentas = new Cuenta[cantidadCuentas];
		
		for(int i=0;i<cuentas.length;i++) {
			System.out.println("Ingrese los datos para la cuenta numero" + (i+1) + ":");
			System.out.println("Ingrese el numero de cuenta:");
			numeroCuenta=reader.nextInt();
			System.out.println("Ingrese el saldo de la cuenta:");
			saldo=reader.nextDouble();
			
			cuentas[i]= new Cuenta(numeroCuenta,saldo);
			
		}
		cliente=new Cliente(nombre,apellido,dni,cuentas);
		
		do {
			System.out.println("MENU:");
			System.out.println("1-INGRESAR DINERO A LA CUENTA");
			System.out.println("2-RETIRAR DINERO DE LA CUENTA");
			System.out.println("3-CONSULTAR SALDO DE LA CUENTA");
			System.out.println("4-SALIR");
			System.out.println("DIGITE LA OPCION DEL MENU:");
			opcionMenu=reader.nextInt();
			
			switch(opcionMenu){
			
			case 1: System.out.println("Ingrese el numero de cuenta:");
			numeroCuenta = reader.nextInt();
			indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
			
			if (indiceCuenta == -1) {
			 	System.out.println("ERROR" + "El numero de cuenta que ha digitado no existe");
			}
			else {
				System.out.println("Ingrese la cantidad de dinero a ingresar:");
				cantidad=reader.nextDouble();
				
				cliente.ingresar_dinero(indiceCuenta, cantidad);
				System.out.println("Ingreso realizado correctamente");
				System.out.println("Saldo disponible" + cliente.consultar_saldo(indiceCuenta));

			}
			break;
			
			case 2:System.out.println("Ingrese el numero de cuenta:");
			numeroCuenta = reader.nextInt();
			indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
			
			if(indiceCuenta == -1) {
				System.out.println("ERROR" + "El numero de cuenta que ha digitado no existe");
				
			}
			else {
				System.out.println("Ingrese la cantidad de dinero a retirar:");
				cantidad=reader.nextDouble();
				
				if (cantidad>cliente.consultar_saldo(indiceCuenta)) {
					System.out.println("SALDO INSUFICIENTE");
				}
				else {
				cliente.retirar_dinero(indiceCuenta, cantidad);
				System.out.println("Retiro realizado correctamente");
				System.out.println("Saldo disponible" + cliente.consultar_saldo(indiceCuenta));
				}	
				
			}
			
			break;
			
			case 3:System.out.println("Ingrese el numero de cuenta:");
			numeroCuenta = reader.nextInt();
			indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
			
			if (indiceCuenta == -1) {
				System.out.println("ERROR" + "El numero de cuenta que ha digitado no existe");
				
			}
			else {
				System.out.println("Consulta de saldo realizada correctamente");
			System.out.println(cliente.consultar_saldo(indiceCuenta));
			}
			
			break;
			
			case 4: break;
			
			default: System.out.println("ERROR" + "Usted se confundio de opcion de menu");
			}
			System.out.println();	
		}while(opcionMenu!=4);

	}
}
