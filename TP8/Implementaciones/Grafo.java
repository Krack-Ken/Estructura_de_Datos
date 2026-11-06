package TP8.Implementaciones;

import TP4.Interfaz.PositionList;
import TP4.ListaDoble.TDALista;
import TP8.Excepciones.InvalidEdgeException;
import TP8.Excepciones.InvalidVertexException;
import TP8.Interfaz.Edge;
import TP8.Interfaz.Graph;
import TP8.Interfaz.Vertex;
import javax.swing.text.Position;

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
                throw new InvalidEdgeException("El arco no corresponde al vértice");
            }
        return opuesto;
    }
    @Override
    public Vertex<V> [] endvertices(Edge<E> e){
        Arco<V,E> arco = checkEdge(e);
        Vertex<V>[] lista = new Vertex[2];
        lista[0] = arco.getVerticeOrigen();
        lista[1] = arco.getVerticeDestino();  
        return lista;
    }
    @Override
    public boolean areAdjacent(Vertex<V> v,Vertex<V> w){
        Vertice<V,E> verticeV = checkVertex(v);
        Vertice<V,E> verticeW = checkVertex(w);
        boolean aux = false;
        
        // Tomo todos los arcos de v, y si w es uno de los extremos de alguno de dichos arcos, 
        // v será adyacente con w
        for(Edge<E> arcos : verticeV.arcosIncidentes()){
            if(opposite(v, arcos) == (verticeW)){
                aux = true;
                break;
            }
        }
        return aux;
    }
    
    @Override
    public V replace(Vertex<V> v, V x){
        Vertice<V,E> vertice = checkVertex(v);
        V aux = vertice.element();
        vertice.setElement(x);
        return aux;
    }

    @Override 
    public E replace(Edge<E> e, E x){
        Arco<V,E> arco = checkEdge(e);
        E aux = arco.element();
        arco.setElement(x);
        return aux;
    }

    @Override 
    public Vertex<V> insertVertex(V x){
        Vertice<V,E> vertice = new Vertice<V,E>(x);
        vertices.addLast(vertice);
        vertice.setPosLista(vertices.last());
        return vertice;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e){
        Vertice<V,E> verticeO = checkVertex(v);
        Vertice<V,E> verticeD = checkVertex(w);
        Arco<V,E> arco = new Arco<>(verticeO, verticeD, e);
        arcos.addLast(arco);
        arco.setPosLista(arcos.last());
        verticeO.arcosIncidentes().addLast(arco);
        arco.setPositionO(verticeO.arcosIncidentes.last());
        //If para que en el caso de que v == w, no tenga un arco duplicado
        if(!(verticeO.equals(verticeD))){
            verticeD.arcosIncidentes().addLast(arco);
            arco.setPositionD(verticeD.arcosIncidentes.last());
        }
        return arco;
    } 
    @Override
    public E removeEdge(Edge<E> e){
        Arco<V,E> arco = checkEdge(e);
        E elem = arco.element();
        //Elimino el arco de la lista general
        arcos.remove(arco.getPosition());
        Vertice<V,E> verticeO = (Vertice)arco.getVerticeOrigen();
        //elimino el arco de la lista de arcos del vértice origen
        verticeO.arcosIncidentes().remove(arco.getPositionO());
        //If por si el arco es un lazo, para no intentar "eliminarlo por 2da vez"
        if(!arco.getVerticeDestino().equals(verticeO)){
            Vertice<V,E> verticeD = (Vertice)arco.getVerticeDestino();
            //elimino el arco de la lista de arcos del vértice destino
            verticeD.arcosIncidentes().remove(arco.getPositionD());
        }
        return elem;
    }

    @Override
    public V removeVertex(Vertex<V> v){
        Vertice<V,E> vertice = checkVertex(v);
        //Elimino todos los arcos conectados al vértice
        for(Edge<E> e : vertice.arcosIncidentes()){
            removeEdge(e); //Asumo que se puede modificar la lista mientras se usa el for
        }
        V elem = vertice.element;
        vertices.remove(vertice.getPosLista());
        return elem;
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
