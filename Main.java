// Autores: Robison Rojas, John Villamil
// Titulo: Algoritmo Voraz
//
import java.util.Scanner;
import java.util.LinkedList;
//
class Main {
  /*
  Ejemplo 2.
  Se debe entregar 36 pesos y se requiere gastar el menor número de monedas posibles (hay monedas de 1, 5, 10, 18 y 20).
    36 – 20 =16
    16- 10 = 6
    6 – 5 = 1
    1 – 1 = 0
  */
  public void Ejemplo2(int entradaCambio) {
    //Monedas
    int uno = 1;
    int cinco = 5;
    int diez = 10;
    int dieciocho = 18;
    int veinte = 20;
    //bueltas
    int cambio = entradaCambio;
    //contadores
    int contUno=0;
    int contCinco=0;
    int contDiez=0;
    int contDieciocho=0;
    int contVeinte=0;
    //
    while(cambio > 0){
      if(cambio >= veinte){
        cambio = cambio - veinte;
        contVeinte++;
      }
      if(cambio >= dieciocho){
        cambio = cambio - dieciocho;
        contDieciocho++;
      }
      if(cambio >= diez){
        cambio = cambio - diez;
        contDiez++;
      }
      if(cambio >= cinco){
        cambio = cambio - cinco;
        contCinco++;
        }
      if(cambio >= uno){
        cambio = cambio - uno;
        contUno++;
      }
    }//while
    //Validando contadores
    if(contVeinte != 0)
      System.out.println("Monedas de 20: "+contVeinte);
    
    if(contDieciocho != 0)
      System.out.println("Monedas de 18: "+contDieciocho);
    
    if(contDiez != 0)
      System.out.println("Monedas de 10: "+contDiez);
    
    if(contCinco != 0)
      System.out.println("Monedas de 5: "+contCinco);
    
    if(contUno != 0)
      System.out.println("Monedas de 1: "+contUno);
  }//Ejemplo2
  //
  /*
  Ejemplo 3.
    Formar una cadena de string con una lista de caracteres que me indica el problema. Cada carácter leído puedo agregarlo al inicio o al fin del String. El objetivo es formar la palabra lexicográficamente mayor posible
  */
  public void Ejemplo3(String entradaCadena) {
      LinkedList pila1 = new LinkedList();
      LinkedList pila2 = new LinkedList();
      //
      String comparador1;
      String comparador2;
      char palabra;
      //
      for(int i = 0; i<entradaCadena.length(); i++){
        palabra = entradaCadena.charAt(i);
        pila1.add(Character.toString(palabra));
      }//for insertando cadena en un arreglo

      System.out.println("Cadena de caracteres            Resultado");
      for (int num = 0; num < pila1.size(); num++) {
          comparador1 = (String) pila1.get(num);
          if (pila2.size() != 0) {
              comparador2 = (String) pila2.element();
              if (comparador1.compareTo(comparador2) == 0) {
                  pila2.addFirst(comparador1);
              } else if (comparador1.compareTo(comparador2) > 0) {
                  pila2.addFirst(comparador1);
              } else if (comparador1.compareTo(comparador2) < 0) {
                  pila2.add(comparador1);
              }
          } else {
              pila2.add(comparador1);
          }
      }//For
      System.out.println(pila1 + "              " + pila2);
  }//Ejemplo3
  //
  public static void main(String[] args) {
    Main objeto = new Main();
    Scanner sc = new Scanner(System.in);
    Scanner sct = new Scanner(System.in);
    int entradaNumTeclado = 0;
    String entradaStrTeclado = "";
    int quedarse = true;
    do{
      System.out.println("Que ejemplo deseas ver:");
      System.out.println("(1) Ejemplo 2:");
      System.out.println("(2) Ejemplo 3:");
      System.out.println("(3) Salir:");
      entradaNumTeclado = sc.nextInt();
      if(entradaNumTeclado == 1){
        System.out.println("Ingrese el cambio");
        entradaNumTeclado = sc.nextInt();
        objeto.Ejemplo2(entradaNumTeclado);
      }
      if(entradaNumTeclado == 2){
        System.out.println("Ingrese la cadena");
        entradaStrTeclado = sct.nextLine();
        //objeto.Ejemplo3(entradaStrTeclado);
      }
      if(entradaNumTeclado == 3){
        quedarse = false;
        System.out.println("Bye");
      }
    }while(quedarse);
  }//main
}//Main

