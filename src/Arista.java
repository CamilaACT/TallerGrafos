public class Arista {
    private Vertice verticeInicial;
    private Vertice verticeFinal;
    private int peso;

    public Arista(Vertice verticeInicial, Vertice verticeFinal, int peso) {
        this.verticeInicial = verticeInicial;
        this.verticeFinal = verticeFinal;
        this.peso = peso;
    }

    public Vertice getVerticeInicial() {
        return verticeInicial;
    }

    public Vertice getVerticeFinal() {
        return verticeFinal;
    }

    public int getPeso() {
        return peso;
    }
}
