public class Menu {

    private static Registro_Utenti registro = Registro_Utenti.getInstanceOfRegistro();
    private static GestioneUtente gestioneUtente=GestioneUtente.getInstance();

    // Metodo principale che gestisce il flusso dell'applicazione
    public static void menuPrincipal(int scelta, String nomeUtente, String password) {
        switch (scelta) {
            case 1: // Login
                login(nomeUtente, password);
                break;

            case 2: // Registrazione
                registrazione(nomeUtente, password);
                break;

            case 3: // Visualizza Utenti
                visualizzaUtenti();
                break;

            case 4: // Inizia Gioco
                iniziaGioco();
                break;

            case 5: // Modifica Profilo
                modificaProfilo(nomeUtente, password);
                break;

            case 6: // Esci
                System.out.println("Uscendo dal gestionale...");
                break;

            default:
                System.out.println("Scelta non valida.");
        }
    }

    // Login dell'utente
    public static void login(String nomeUtente, String password) {
        GestioneUtente.login(nomeUtente, password);
    }

    // Registrazione di un nuovo utente
    public static void registrazione(String nomeUtente, String password) {
        GestioneUtente.registrazione(nomeUtente, password);
    }

    // Visualizzazione di tutti gli utenti registrati
    public static void visualizzaUtenti() {
        if (registro.getRegistro().isEmpty()) {
            System.out.println("Non ci sono utenti registrati.");
        } else {
            System.out.println("Utenti registrati:");
            for (Utente utente : registro.getRegistro()) {
                System.out.println("Nome: " + utente.getNomeUtente() + ", Punteggio: " + utente.getPunteggio() + ", Difficoltà: " + utente.getDifficolta());
            }
        }
    }

    // Inizio del gioco
    public static void iniziaGioco() {
        if (gestioneUtente.getUtenteInSessione() == null) {
            System.out.println("Per giocare, devi prima effettuare il login.");
            return;
        }

        int difficolta = gestioneUtente.getUtenteInSessione().getDifficolta();
        int punteggio = gestioneUtente.getUtenteInSessione().getPunteggio();
        int errori = 0;

        System.out.println("Iniziando il gioco per " + gestioneUtente.getUtenteInSessione().getNomeUtente());

        while (difficolta <= 3 && errori < 3) {
            boolean rispostaCorretta = ProveMatematiche.eseguiProva(difficolta); // Qui invoca il metodo delle prove matematiche

            if (rispostaCorretta) {
                punteggio += ProveMatematiche.PUNTI_PER_RISPOSTA_CORRETTA;
                gestioneUtente.getUtenteInSessione().setPunteggio(punteggio);
                difficolta++;
                gestioneUtente.getUtenteInSessione().setDifficolta(difficolta);
                System.out.println("Risposta corretta! Punteggio: " + punteggio + ", Difficoltà: " + difficolta);
            } else {
                errori++;
                System.out.println("Risposta sbagliata! Errori: " + errori);
            }
        }

        if (errori >= 3) {
            System.out.println("Hai raggiunto il limite di errori. Sei stato rimosso dal gioco.");
            GestioneUtente.esci();
        } else {
            System.out.println("Gioco completato con successo! Punteggio finale: " + punteggio);
        }
    }

    // Modifica del profilo dell'utente loggato
    public static void modificaProfilo(String nomeUtente, String password) {
       GestioneUtente.modifica(nomeUtente, password);
    }
}
