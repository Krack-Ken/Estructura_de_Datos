package TP8.Implementaciones;

import TP4.Interfaz.Position;
import TP8.Interfaz.Edge;
import TP8.Interfaz.Vertex;


/**
 * En un grafo implementado con una lista de adyacencia,
 * cada arco conoce los vértices que une, y su rótulo 
 */
public class Arco<V,E> implements Edge<E>{
    //Atributos de Instancia
    protected Vertex<V> verticeOrigen;//Este se no existe en grafos dirigidos asdsa
    protected Vertex<V> verticeDestino;
    protected E peso;
    protected Position<Edge<E>> posLista;
    protected Position<Edge<E>> posListaO;
    protected Position<Edge<E>> posListaD;

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
    public Position<Edge<E>> getPosition(){
        return posLista;
    }
    public void setPosLista(Position<Edge<E>> p){
        posLista = p;
    }
    public Position<Edge<E>> getPositionO(){
        return posListaO;
    }
    public void setPositionO(Position<Edge<E>> pO){
        posListaO = pO;
    }
    public Position<Edge<E>> getPositionD(){
        return posListaD;
    }
    public void setPositionD(Position<Edge<E>> pD){
        posListaD = pD;
    }
}