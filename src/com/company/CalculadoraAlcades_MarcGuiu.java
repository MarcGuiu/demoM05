package com.company;

import java.util.Scanner;
// hola
public class CalculadoraAlcades_MarcGuiu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean correcte = false;
        int nombreMaximCalculs = 5;
        String nomsNens[] = new String[nombreMaximCalculs];
        double alcadesCalculades[] = new double[nombreMaximCalculs];
        String nomsMetodes[] = new String[nombreMaximCalculs];
        System.out.println("Benvingut a la calculadora d'alçades!");
        for (int i = 0; i < nombreMaximCalculs; i++) {
            System.out.println("Escriu el nom del Nen o Nena:");
            nomsNens[i] = input.nextLine();

            int metode = llegirInt("Quin mètode de càlcul vols utilitzar?\n1:Alçada2\n2:Progenitors\n3:Pitonissa", 0, 3);
            switch (metode) {
                case 1://Alçada2
                    nomsMetodes[i]  = "Alçada2";
                    int alcada2Anys = 0;

                    alcada2Anys = llegirInt("Quina es l'alçada (en cm) de " + nomsNens[i] + " quan tenia 2 anys?", 59, 121);

                    alcadesCalculades[i] = alcadesCalculades2Anys(alcada2Anys, alcadesCalculades[i]);

                    break;
                case 2://Progenitors
                    nomsMetodes[i]  = "Progenitors";
                    int alcadaPare = 0;
                    int alcadaMare = 0;

                    alcadaPare = llegirInt("Introdueix l'alçada del Pare(cm):", 99, 250);

                    alcadaMare = llegirInt("Introdueix l'alçada del Mare(cm):", 99, 250);

                    alcadesCalculades[i] = alcadesCalculadesProgenitors(alcadaPare, alcadaMare, alcadesCalculades[i]);

                    break;
                case 3: //Pitonissa
                    nomsMetodes[i] = "Pitonissa";
                    /*
                    * Pitonissa: Aquest mètode es basa en el nom del nen i consisteix en la suma del
                      valor ASCII de totes les consonants del   nom, dividit per el número de lletres del
                      nom(consonants + vocals) + 100, el resultat que s’obté és en centímetre
                    * */
                    int sumaValorConsonants=0;

                    for (int j = 0; j < nomsNens[i].length(); j++) {
                        char chActual = nomsNens[i].charAt(j);
                        if(chActual != 'a' && chActual != 'e' && chActual != 'i' && chActual != 'o' && chActual != 'u'){
                            sumaValorConsonants += chActual;
                        }
                    }

                    alcadesCalculades[i] = ((sumaValorConsonants / nomsNens[i].length()) + 100)/100;
                    break;
            }
            System.out.printf("Lalçada de %s quan sigui adult serà de %.2fm segons el mètode %s.\n", nomsNens[i], alcadesCalculades[i], nomsMetodes[i]);
            if(i < 5) {

              System.out.println("Vols calcular alguna altre alçada?[S/N]");

              if(input.nextLine().equalsIgnoreCase("N"))
                  i = 5;//igualo i a 5 perque surti deñ bucle

            }

        }
        System.out.println("________Resum del càlculs realitzats________");
        System.out.println("           Nom       Alçada        Metode");
        for (int i = 0; i < nombreMaximCalculs; i++) {
            if(nomsNens[i] == null){
                break;
            }
            System.out.printf("%15s %13.2f %15s\n",nomsNens[i],alcadesCalculades[i],nomsMetodes[i]);
        }
    }

    // Metode control d'errors

    /**
     * Control d'errors
     * Aquest metode funciona amb variables int
     * @param missatge Missatge que mostra a l'usurai
     * @param minValue Valor minim que es pot introduir en aquets control d'errors
     * @param maxVAlue Valor màxim que es pot introduir en aquets control d'errors
     * @return numero que es vol introduir ja controlat que no tingui errors
     */
    public static int llegirInt (String missatge,int minValue, int maxVAlue){
        Scanner input = new Scanner(System.in);
        System.out.println(missatge);
        boolean correcte = false;
        int numero = 0;
        while (!correcte) {
            if (input.hasNextInt()) {
                numero = input.nextInt();
                if (numero > minValue && numero < maxVAlue) {
                    correcte = true;
                } else {
                    System.out.println("El valor ha d'estar entre " + minValue +" i " + maxVAlue);
                }
            } else {
                System.out.println("Has d'introduir un numero!!");
            }
            input.nextLine();
        }
        return numero;
    }

    /**
     * Metode per calcular l'alçada del nen segons el metode alçada2
     * @param alcada2Anys alçada del nen quan tenia 2 anys
     * @param alcada variable que farem servir per fer els calculs
     * @return alçada ja calculada segons el metode alçada2
     */
    public static double alcadesCalculades2Anys(int alcada2Anys, double alcada) {
        alcada = (alcada2Anys * 2.0) / 100;
        return alcada;
    }

    /**
     * Metode per calcular l'alçada del noi o noia segons el metode progenitors
     * @param alcadaPare alçada del pare
     * @param alcadaMare alçada de la mare
     * @param alcadaCalculada variable que farem servir per fer els calculs
     * @return alçada calculada segons el metode progenitors
     */
    public static double alcadesCalculadesProgenitors(int alcadaPare, int alcadaMare, double alcadaCalculada){
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el sexe del nen [M/F]");
        boolean esMascle = input.nextLine().equalsIgnoreCase("M");
        if (esMascle) {
            alcadaCalculada = ((alcadaPare + alcadaMare + 13) / 2.0) / 100;
        }else{
            alcadaCalculada = ((alcadaPare + alcadaMare - 13) / 2.0) / 100;
        }

        return alcadaCalculada;
    }

}
