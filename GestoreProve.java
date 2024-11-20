import java.util.ArrayList;

public class GestoreProve {
    ArrayList<Prova> prove = new ArrayList();
    int stato = 0;

    public Prova prossimaProva() {
        return prove.get(stato);
    }

    public boolean rispondi(int risposta) {
        int result = Prova.rispondi(risposta);
        if(result) {
            if(stato<prove.size()-1) {
                stato +=1;
            }
        }
        return result;
    }

    public boolean finito() {
        if(stato==prove.size()) {
            return true;
        } else {
            false;
        }
    }

    
}
