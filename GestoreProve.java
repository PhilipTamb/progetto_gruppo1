import java.util.ArrayList;

// Utilizzo di questa classe
// 1. Istanzia un oggetto della classe GestoreProve g
// 2. Chiama rigeneraProve(int numeroDiProveDesiderate)
// 3. Apri un ciclo
//  4. chiama getCurrentProva, che restituisce un oggetto Prova p
//  5. chiama p.stampa per mostrare la domanda e le possibili risposte
//  6. ricevi da utente risposta alla domanda
//  7. chiama g.rispondi(float rispostaUtente)
//  8. chiama g.getFinito() e se restituisce true esci dal ciclo e dì all'utente che ha vinto
//  9. chiama g.getSqualificato() e se restituisce true esci dal ciclo e dì all'utente che ha perso
//  10. torna all'inizio del ciclo
public class GestoreProve {
    ArrayList<Prova> prove = new ArrayList();
    int stato = 0;
    int punteggioTotale = 0;
    int punteggioMinimo = 0;

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
    public void rispondi(float risposta) {
        if(finito()) {
            System.out.println("Non ci sono altre prove");
            return;
        }
        if(getSqualificato()) {
            System.out.println("Sei gia squalificato quindi non puoi più rispondere");
            return;
        }
        int punti = Prova.rispondi(risposta);
        punteggioTotale += punti;
        if(getSqualificato()) {
        } else {
            if(!finito()) {
                stato +=1;
            }
        }
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

    // ritorna lo stato
    public int getPunteggioTotale() {
        return this.punteggioTotale;
    }

    public boolean getSqualificato() {
        return punteggioTotale<punteggioMinimo;
    }

    // genera un numero di prove e resetta lo stato a 0
    // le prove sono a difficoltà crescente
    public void rigeneraProve(int num) {
        prove.clear();
        stato = 0;
        // i è anche la difficoltà
        for(int i=0;i<num; i++) {
            Prova p1 = new Prova(i);
            prove.add(p1);
        }
    }

    
}
