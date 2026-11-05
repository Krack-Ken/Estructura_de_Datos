package TP8.Implementaciones;

import TP4.Interfaz.PositionList;
import TP4.ListaDoble.TDALista;
import TP8.Excepciones.InvalidEdgeException;
import TP8.Excepciones.InvalidVertexException;
import TP8.Interfaz.Edge;
import TP8.Interfaz.Graph;
import TP8.Interfaz.Vertex;

@SuppressWarnings ("all")
public class Grafo<V,E> implements Graph<V,E> {
    //Atributos de instancia
    PositionList<Vertex<V>> vertices;
    PositionList<Edge<E>> arcos;

    //Constructor
    public Grafo(){
        vertices = new TDALista<>();
        arcos = new TDALista<>();
    }

    //Métodos
    @Override
    public Iterable<Vertex<V>> vertices(){
        return vertices;
    }

    @Override
    public Iterable<Edge<E>> edges(){
        return arcos;
    }

    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> v){
        Vertice<V,E> vertice = checkVertex(v);
        return vertice.arcosIncidentes();
    }

    @Override 
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e){
        Vertice<V,E> vertice = checkVertex(v);
        Arco<V,E> arco = checkEdge(e);
        Vertex<V> opuesto;
        //Asumiendo por implementación que un arco siempre tiene sus extremos
        if(vertice.equals(arco.getVerticeOrigen())){
            opuesto = arco.getVerticeDestino();
        }
        else if (vertice.equals(arco.getVerticeDestino())){
            opuesto = arco.getVerticeOrigen();
        }
            else{
                throw new InvalidVertexException("El arco no corresponde al vértice");
            }
        return opuesto;
    }

    //Métodos auxiliares
    /**
     * Verifica que el vértice no sea nulo, y se pueda castear
     * a Vertice<V,E>
     * @param v Vertice a comprobar
     * @return Vertice<V,E> clase que implementa Vertex
     */
    private Vertice<V,E> checkVertex(Vertex<V> v){
        if(v == null || !(v instanceof Vertice)){
            throw new InvalidVertexException("El vértice no puede ser nulo");
        }
        Vertice<V,E> vertice = (Vertice<V,E>)v;
        return vertice;
    }
    /**
     * Verifica que el Arco no sea nulo, y se pueda castear
     * a Edge<V,E>
     * @param e Arco a comprobar
     * @return Arco<V,E> clase que implementa Edge
     */
    private Arco<V,E> checkEdge(Edge<E> e){
        if(e == null || !(e instanceof Arco)){
            throw new InvalidEdgeException("El Arco no puede ser nulo");
        }
        Arco<V,E> arco = (Arco<V,E>)e;
        return arco;
    }
}
