import java.util.ArrayList;

public class Registro_Utenti {

    private static ArrayList<Utente> registro = new ArrayList<>();
    private static Registro_Utenti instanceOfRegistroUtenti;

    private Registro_Utenti(){

    }

    public void aggiungiUtente(Utente u){
        registro.add(u);
    }

    public void rimuoviUtente(Utente u){
        registro.remove(u);
    }

    public boolean cercaPerNomeUtente(String nome){
        boolean trovato = false;
        for(Utente u: registro){
            if(u.getNomeUtente().equals(nome)){
                System.out.println("Utene Trovato, ...carico le informazioni...");
                System.out.println("info varie");
                trovato = true;
                return trovato;
            }
        }
        
        System.out.println("Utente non Trovato");
        return trovato;
      
    }


    public static ArrayList<Utente> getRegistro() {
        return registro;
    }


    public Registro_Utenti getInstanceOfRegistro() {
        return new Registro_Utenti();
    }
}
