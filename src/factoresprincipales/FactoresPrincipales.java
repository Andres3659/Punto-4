/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoresprincipales;

import java.util.Scanner;

public class FactoresPrincipales {


    public static void main(String[] args) {
         System.out.print("Introduzca el límite maximo (entero positivo): ");
        Scanner entrada = new Scanner(System.in);
        if ( ! entrada.hasNextInt()) {
            System.out.println("ERROR,límite superior invalido. Inténtalo de nuevo.");
            return;
        }
        int LimSup = entrada.nextInt();
        
        FactoresPrincipales num = new FactoresPrincipales();
        
        System.out.println(num.isProductOfPrimeFactors(30));
        System.out.println(num.isProductOfPrimeFactors(20));
        
        num.ImprimirFactoresPrimos(LimSup);
    }
    
   
    
    private boolean isProductOfPrimeFactors(int posInt)
    {
        int prod = 1;
        for (int i = 2; i < posInt; i++) {
            prod *= EsPrimo(i) && (posInt%i == 0) ? i : 1;
        }
        return (prod == posInt);
    }
    
     private boolean EsPrimo(int posInt)
    {
        for (int i = 2; i <= Math.sqrt(posInt); i++)
        {
            if (posInt%i != 0) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    private void ImprimirFactoresPrimos(int LimSup)
    {
        System.out.println("Estos números son iguales al producto de factores primos: ");
        
        int contProdPrimeFactors = 0;
        for (int i = 1; i <= LimSup; i++) {
            if (! isProductOfPrimeFactors(i)) {
                continue;
            }
            System.out.printf("%1$d ", i);
            contProdPrimeFactors++;
        }
        System.out.printf("\n[%1$d Numeros encontrados:  (%2$.2f%%)]\n"
                , contProdPrimeFactors, ((double) 100 * contProdPrimeFactors/LimSup));
    }
    }
    
