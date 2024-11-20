import java.util.ArrayList;

public class Registro_Utenti {

    private ArrayList<Utente> registro = new ArrayList<>();
    private static Registro_Utenti instanceOfRegistroUtenti;

    private Registro_Utenti(){

    }

    public aggiungiUtente(Utente u){
        registro.add(u);
    }

    public rimuoviUtente(Utente u){
        registro.remove(u);
    }

    public cercaPerNomeUtente(String nome){
        boolean trovato = false;
        for(Utente u: registro){
            if(u.getNomeUtente().equals(nome)){
                System.out.println("Utene Trovato, ...carico le informazioni...");
                System.out.println("info varie");
                trovato = true;
                break;
            }
        }
        if(trovato == false){
            System.out.println("Utente non Trovato");
        }
    }


    public ArrayList<Utente> getRegistro() {
        return registro;
    }


    public Registro_Utenti getInstanceOfRegistro() {
        return new Registro_Utenti();
    }
}
