import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private boolean esDirigido;
    private boolean conPesos;

    public Grafo(boolean esDirigido, boolean conPesos) {
        this.vertices = new ArrayList<Vertice>();
        this.esDirigido = esDirigido;
        this.conPesos = conPesos;
    }

    public void addVertice(String dato){
        Vertice Vertice1=new Vertice(dato);
        this.vertices.add(Vertice1);
    }

    public void addArista(Vertice verticeInicial,Vertice verticeFinal,int peso) {
        //revisa si el grafo creado es un grado sin peso, entoncer coloca 1
        if (this.conPesos == false) {
            peso = 1;
        }
        //indexOf sirve para saber el indice de un pbjeto
        vertices.get(vertices.indexOf(verticeInicial)).addArista(verticeFinal, peso);
        verticeInicial.addArista(verticeFinal, peso);

        if (this.esDirigido == false) {
            verticeFinal.addArista(verticeInicial, peso);
        }
    }

    public void addArista(String verticeInicial,String verticeFinal,int peso) {
        //revisa si el grafo creado es un grado sin peso, entoncer coloca 1
        if (this.conPesos == false) {
            peso = 1;
        }
        //indexOf sirve para saber el indice de un objeto
        getVertexByValue(verticeInicial).addArista(getVertexByValue(verticeFinal),peso);

        if (this.esDirigido == false) {
            getVertexByValue(verticeFinal).addArista(getVertexByValue(verticeInicial),peso);
        }
    }

    public Vertice getVertexByValue(String valor){
        for(Vertice vertice1:this.vertices){
            if(vertice1.getDato().equals(valor)){
                return vertice1;
            }
        }
        return null;
    }

    public void borrarArista(Vertice verticeInicial,Vertice verticeFinal){
        verticeInicial.removerVertice(verticeFinal);
        if (!this.esDirigido){
            verticeFinal.removerVertice(verticeInicial);
        }
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public boolean isConPesos() {
        return conPesos;
    }
    public String depthFirstTraversal (Vertice verticeInicio,ArrayList<Vertice> verticesVisitados ){
        String result="";
        result += verticeInicio.getDato() + "\n";

        for(Arista arista1:verticeInicio.getAristas()){
            Vertice verticeVecino=arista1.getVerticeFinal();
            if(!verticesVisitados.contains(verticeVecino)){
                verticesVisitados.add(verticeVecino);
                result += depthFirstTraversal(verticeVecino,verticesVisitados);
            }
        }
        return result;
    }

    public String breadthFirstTraversal(Vertice verticeInicio) {
        // Creamos un ArrayList para almacenar los vértices visitados
        ArrayList<Vertice> visitados = new ArrayList<>();
        // Creamos una cola (Queue) para procesar los vértices en orde
        Queue<Vertice> cola = new LinkedList<>();
        // Creamos un StringBuilder para construir el resultado
        StringBuilder resultado = new StringBuilder();

        // Agregamos el vértice inicial a la cola y lo marcamos como visitado
        cola.offer(verticeInicio);
        visitados.add(verticeInicio);

        int contador=0;
        // Ejecutamos el BFS mientras la cola no esté vacía
        while (!cola.isEmpty()) {
            System.out.println("Cuantas veces entra aqui: "+ contador);
            contador++;
            // Tomamos un vértice de la cola
            Vertice vertice = cola.poll();
            // Agregamos el vértice al resultado string
            resultado.append(vertice.getDato()).append("\n");

            // Iteramos sobre las aristas del vértice en el que estamos
            for (Arista arista : vertice.getAristas()) {
                // Obtenemos el vértice vecino de la arista
                Vertice verticeVecino = arista.getVerticeFinal();
                // Verificamos si el vértice vecino no ha sido visitado
                if (!visitados.contains(verticeVecino)) {
                    // Agregamos el vértice vecino a la cola y lo marcamos como visitado
                    cola.offer(verticeVecino);
                    visitados.add(verticeVecino);
                }
            }
        }
        // Devolvemos el resultado como una cadena de caracteres
        return resultado.toString();
    }


}
