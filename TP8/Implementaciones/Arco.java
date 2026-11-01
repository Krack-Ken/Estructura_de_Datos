import TP4.Interfaz.PositionList;
import TP4.ListaDoble.TDALista;
import TP8.Interfaz.Edge;


/**
 * En un grafo implementado con una lista de adyacencia,
 * cada arco conoce los vértices que une, y su rótulo 
 */
public class Arco<V,E> implements Edge<E>{
    //Atributos de Instancia
    PositionList<Vertex<V>> listaDeVertices;
    int peso;
    E rotulo;

    //Constructor
    public Arco(){
        listaDeVertices = new TDALista<Vertex<V>>();
    }
    public Arco(E rotulo){
        listaDeVertices = new TDALista<Vertex<V>>();
        this.rotulo = rotulo;
    }
    public Arco(E rotulo, int peso){
        listaDeVertices = new TDALista<Vertex<V>>();
        this.rotulo = rotulo;
        this.peso = peso;
    }

    //Métodos
    public E element(){
        return rotulo;
    }
}