package TP8.Implementaciones;

import TP4.Interfaz.Position;
import TP4.Interfaz.PositionList;
import TP4.ListaDoble.TDALista;
import TP8.Interfaz.Edge;
import TP8.Interfaz.Vertex;

/**
 * En un grafo implementado con una lista de adyacencia,
 * cada vértice conoce su rótulo y los arcos que inciden 
 * en él
 */
public class Vertice<V, E> implements Vertex<V>{
    //Atributos de instancia
    protected V element;
    protected PositionList<Edge<E>> arcosIncidentes;
    protected Position<Vertex<V>> posLista;
    
    //Constructor
    public Vertice(V element){
        this.element = element;
        arcosIncidentes = new TDALista<>();
    }
    public Vertice(){
        this.element = null;
        arcosIncidentes = new TDALista<>();
    }

    //Metodos
    public V element(){
        return element;
    }
    public void setElement(V element){
        this.element = element;
    }
    public PositionList<Edge<E>> arcosIncidentes(){
        return arcosIncidentes;
    }
    public Position<Vertex<V>> getPosLista(){
        return posLista;
    }
    public void setPosLista(Position<Vertex<V>> p){
        posLista = p;
    }
}
