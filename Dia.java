public class Dia {
    private int tiempo;

    Dia(int tiempo) {
        this.tiempo = tiempo;
    }

    public void restar(int tiempo) {
        this.tiempo -= tiempo;
    }

    public int getTiempo() {
        return tiempo;
    }
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
