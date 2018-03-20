package br.usjt.desmob.geodata;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;


public class SectionIndexBuilder {
    // países devem estar ordenados por nome
    public static Object[] buildSectionHeaders(Pais[] paises){
        ArrayList<String> resultado = new ArrayList<>();
        TreeSet<String> usados = new TreeSet<>();
        for(Pais pais:paises){
            String letra = pais.getNome().substring(0,1);
            if((!usados.contains(letra))){
                resultado.add(letra);
            }
            usados.add(letra);
        }
        return resultado.toArray(new Object[0]);
    }
    //cria um mapa para responder: ordenados pelo nome
    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Pais[] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
            }
            resultados.put(i, secao);
        }
        return resultados;
    }

    //cria um mapa para responder: ordenados pelo nome
    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Pais[] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
                resultados.put(secao, i);
            }
        }
        return resultados;
    }
}
