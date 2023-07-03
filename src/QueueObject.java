public class QueueObject implements Comparable<QueueObject> {

    private final Vertice vertex;
    private final int priority;

    public QueueObject(Vertice v, int p){
        this.vertex = v;
        this.priority = p;
    }

    @Override
    public int compareTo(QueueObject o) {
        if (this.priority == o.priority){
            return 0;
        }
        else if (this.priority > o.priority){
            return 1;
        }
        else{
            return -1;
        }
    }

    public Vertice getVertex() {
        return vertex;
    }
}