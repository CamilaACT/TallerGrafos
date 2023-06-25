import java.util.ArrayList;

public class Vertice {
    private String dato;
    private ArrayList<Arista> aristas;

    public Vertice(String dato) {
        this.dato = dato;
        this.aristas = new ArrayList<Arista>();
    }

    public boolean aristaUnica(String verticeFinal){
        for(Arista arista1: aristas){
            if(arista1.getVerticeFinal().getDato().equals(verticeFinal)){
                return false;
            }
        }
        return true;
    }
    public void addArista(Vertice verticeFinal,int peso){
        //this se usa para hacer referencia al propio objeto en este caso vertice
        this.aristas.add(new Arista(this,verticeFinal,peso));
    }
    public void removerVertice(Vertice verticeFinal){
        this.aristas.removeIf(arista -> arista.getVerticeFinal().equals(verticeFinal));
    }

    public String getDato() {
        return dato;
    }
    public Vertice getVertice(String dato){
        if(this.dato.equals(dato)){
            return this;
        }
        return null;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }


    public String imprimir(boolean conPeso){
        String mensaje="";
        if(this.aristas.size()==0){
            mensaje +=this.dato+"-->";
            return mensaje;
        }
        for(int i=0;i <this.aristas.size();i++){
            if(i==0){
                mensaje += this.aristas.get(i).getVerticeInicial().dato+" --> ";
            }
            mensaje += this.aristas.get(i).getVerticeFinal().dato;

            if(conPeso){
                mensaje+= " ("+this.aristas.get(i).getPeso()+ ") ";
            }
            if(i != this.aristas.size()-1){
                mensaje +=", ";
            }
        }
        return mensaje;
    }
}
