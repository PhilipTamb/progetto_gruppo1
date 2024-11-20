public class Menu {

    public static Registro_Utenti registro = Registro_Utenti.getInstanceOfRegistro();
    public static Utente utenteCorrente = null;

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
        Utente utente = registro.cercaPerNomeUtente(nomeUtente);
        if (utente != null && utente.getPassword().equals(password)) {
            utenteCorrente = utente;
            System.out.println("Login effettuato con successo! Benvenuto " + utenteCorrente.getNomeUtente());
        } else {
            System.out.println("Credenziali errate o utente non registrato.");
        }
    }

    // Registrazione di un nuovo utente
    public static void registrazione(String nomeUtente, String password) {
        // Controlla se l'utente esiste già nel registro
        if (registro.cercaPerNomeUtente(nomeUtente) != null) {
            System.out.println("Il nome utente è già registrato. Scegli un altro nome.");
        } else {
            // Crea il nuovo utente
            Utente nuovoUtente = new Utente(nomeUtente, password, 0, 1);
            registro.aggiungiUtente(nuovoUtente);
            System.out.println("Registrazione completata con successo.");
        }
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
        if (utenteCorrente == null) {
            System.out.println("Per giocare, devi prima effettuare il login.");
            return;
        }

        int difficolta = utenteCorrente.getDifficolta();
        int punteggio = utenteCorrente.getPunteggio();
        int errori = 0;

        System.out.println("Iniziando il gioco per " + utenteCorrente.getNomeUtente());

        while (difficolta <= 3 && errori < 3) {
            boolean rispostaCorretta = ProveMatematiche.eseguiProva(difficolta); // Qui invoca il metodo delle prove matematiche

            if (rispostaCorretta) {
                punteggio += ProveMatematiche.PUNTI_PER_RISPOSTA_CORRETTA;
                utenteCorrente.setPunteggio(punteggio);
                difficolta++;
                utenteCorrente.setDifficolta(difficolta);
                System.out.println("Risposta corretta! Punteggio: " + punteggio + ", Difficoltà: " + difficolta);
            } else {
                errori++;
                System.out.println("Risposta sbagliata! Errori: " + errori);
            }
        }

        if (errori >= 3) {
            System.out.println("Hai raggiunto il limite di errori. Sei stato rimosso dal gioco.");
            utenteCorrente = null; // Rimuovi l'utente dal gioco
        } else {
            System.out.println("Gioco completato con successo! Punteggio finale: " + punteggio);
        }
    }

    // Modifica del profilo dell'utente loggato
    public static void modificaProfilo(String nomeUtente, String password) {
        if (utenteCorrente == null) {
            System.out.println("Devi essere loggato per modificare il profilo.");
            return;
        }

        System.out.println("Stai modificando il profilo di " + utenteCorrente.getNomeUtente());

        // Modifica nome utente
        if (nomeUtente != null && !nomeUtente.isEmpty()) {
            utenteCorrente.setNomeUtente(nomeUtente);
            System.out.println("Nome utente modificato con successo!");
        }

        // Modifica password
        if (password != null && !password.isEmpty()) {
            utenteCorrente.setPassword(password);
            System.out.println("Password modificata con successo!");
        }
    }
}
