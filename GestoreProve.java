import java.util.ArrayList;

public class GestoreProve {
    ArrayList<Prova> prove = new ArrayList();
    int stato = 0;

    // restituisce la prova corrente o null se sono finite. Non cambia lo stato
    public Prova getCurrentProva() {
        if(finito()) {
            System.out.println("Non ci sono altre prove");
            return null;
        }
        return prove.get(stato);
    }

    // accetta la risposta alla domanda corrente.
    // Se corretta avanza lo stato di uno.
    // In ogni caso restituisce l'esito
    public boolean rispondi(int risposta) {
        if(finito()) {
            System.out.println("Non ci sono altre prove");
            return false;
        }
        boolean result = Prova.rispondi(risposta);
        if(result) {
            if(stato<prove.size()-1) {
                stato +=1;
            }
        }
        return result;
    }

    // dice se le prove sono finite
    public boolean finito() {
        if(stato>=prove.size()-1) {
            return true;
        } else {
            return false;
        }
    }

    // ritorna lo stato
    public int getStato() {
        return this.stato;
    }

    // genera un numero di prove e resetta lo stato a 0
    public void rigeneraProve(int num) {
        prove.clear();
        stato = 0;
        for(int i=0;i<num; i++) {
            Prova p1 = Prova.provaCasuale();
            prove.add(p1);
        }
    }

    
}
