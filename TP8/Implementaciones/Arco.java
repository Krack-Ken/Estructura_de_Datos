package TP8.Implementaciones;

import TP8.Interfaz.Edge;
import TP8.Interfaz.Vertex;


/**
 * En un grafo implementado con una lista de adyacencia,
 * cada arco conoce los vértices que une, y su rótulo 
 */
public class Arco<V,E> implements Edge<E>{
    //Atributos de Instancia
    Vertex<V> verticeOrigen;//Este se no existe en grafos dirigidos asdsa
    Vertex<V> verticeDestino;
    E peso;

    //Constructor
    public Arco(Vertex<V> verticeOrigen, Vertex<V> verticeDestino, E peso){
        this.peso = peso;
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
    }

    //Métodos

    /** Devuelve el peso del arco
     * @return El peso del arco
     */
    public E element(){
        return peso;
    }
    
    public void setElement(E peso){
        this.peso = peso;
    }

    public Vertex<V> getVerticeOrigen(){
        return verticeOrigen;
    }

    public Vertex<V> getVerticeDestino(){
        return verticeDestino;
    }
}