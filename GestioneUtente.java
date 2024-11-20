
public class GestioneUtente {

    private static Registro_Utenti registroUtenti = Registro_Utenti.getInstanceOfRegistro();
    private static Utente utenteInSessione;

    public static void login(String nome, String password) {
        for (Utente u : registroUtenti.getRegistro()) {
            if (u.getNomeUtente().equals(nome) && u.getPassword().equals(password)) {
                System.out.println("Login avvenuto con successo!");
                utenteInSessione = u;
            } else {
                System.err.println("Nessun utente trovato!");
            }
        }
    }

    public static void registrazione(String nome, String password) {
        if (registroUtenti.cercaPerNomeUtente(nome)) {
            System.out.println("Nome già in uso!");
            return;
        } else {
            Utente u = new Utente(nome, password, 0, 1);
        }
    }

    public static void modifica(String nome, String password) {
        if (utenteInSessione == null) {
            return;
        } else {
            Utente u = new Utente(nome, password, utenteInSessione.getPunteggio(), utenteInSessione.getDifficolta());
            registroUtenti.rimuoviUtente(utenteInSessione);
            registroUtenti.aggiungiUtente(u);
            utenteInSessione = u;
        }
    }

    public static void esci() {
        utenteInSessione = null;
    }

    public static void elimina() {
        registroUtenti.rimuoviUtente(utenteInSessione);
        esci();
    }

    public static void incrementaPunteggio() {
        registroUtenti.rimuoviUtente(utenteInSessione);
        utenteInSessione.setPunteggio(utenteInSessione.getPunteggio() + 1);
        registroUtenti.aggiungiUtente(utenteInSessione);
    }
    public static void decrementaPunteggio() {
        registroUtenti.rimuoviUtente(utenteInSessione);
        utenteInSessione.setPunteggio(utenteInSessione.getPunteggio() - 1);
        registroUtenti.aggiungiUtente(utenteInSessione);
    }

    public static void incrementaDifficoltà() {
        if (utenteInSessione.getDifficolta() < 3) {
            registroUtenti.rimuoviUtente(utenteInSessione);
            utenteInSessione.setDifficolta(utenteInSessione.getDifficolta() + 1);
            registroUtenti.aggiungiUtente(utenteInSessione);
        } else {
            return;
        }
    }
    public static void decrementaDifficoltà() {
        if (utenteInSessione.getDifficolta() >1) {
            registroUtenti.rimuoviUtente(utenteInSessione);
            utenteInSessione.setDifficolta(utenteInSessione.getDifficolta() - 1);
            registroUtenti.aggiungiUtente(utenteInSessione);
        } else {
            return;
        }
    }


}
