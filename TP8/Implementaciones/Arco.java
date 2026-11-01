package TP8.Implementaciones;

import TP8.Interfaz.Edge;
import TP8.Interfaz.Vertex;


/**
 * En un grafo implementado con una lista de adyacencia,
 * cada arco conoce los vértices que une, y su rótulo 
 */
public class Arco<V,E> implements Edge<E>{
    //Atributos de Instancia
    Vertex<V> verticeOrigen;
    Vertex<V> verticeDestino;
    int peso;
    E rotulo;

    //Constructor
    public Arco(E rotulo, int peso){
        this.rotulo = rotulo;
        this.peso = peso;
    }

    //Métodos
    public E element(){
        return rotulo;
    }
}