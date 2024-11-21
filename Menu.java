import java.util.Scanner;

public class Menu {

    private static Registro_Utenti registro = Registro_Utenti.getInstanceOfRegistro();
    private static GestioneUtente gestioneUtente = GestioneUtente.getInstance();

    private static Scanner scannerNum = new Scanner(System.in);
    private static Scanner scannerStr = new Scanner(System.in);
    private static String nomeUtente, password;

    // Metodo principale che gestisce il flusso dell'applicazione
    public static void menuPrincipal(String scelta) {
        switch (scelta) {
            case "1": // Login
                System.out.println("Login");
                System.out.print("Inserisci nome untente:");
                nomeUtente = scannerStr.nextLine();
                System.out.print("Inserisci password:");
                password = scannerStr.nextLine();
                login(nomeUtente, password);
                break;

            case "2": // Registrazione
                System.out.println("Registrazione");
                System.out.print("Inserisci nome untente:");
                nomeUtente = scannerStr.nextLine();
                System.out.print("Inserisci password:");
                password = scannerStr.nextLine();
                registrazione(nomeUtente, password);
                break;

            case "3": // Visualizza Utenti
                visualizzaUtenti();
                break;

            case "4": // Inizia Gioco
                iniziaGioco();
                break;

            case "5": // Modifica Profilo
                System.out.println("Modifica");
                System.out.print("Inserisci nome untente da modificare:");
                nomeUtente = scannerStr.nextLine();

                System.out.print("Inserisci password da modificare:");
                password = scannerStr.nextLine();
                modificaProfilo(nomeUtente, password);
                break;

            case "6": // Esci
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
        GestoreProve gioco = new GestoreProve();
        gioco.rigeneraProve(3, difficolta);


        System.out.println("Iniziando il gioco per " + gestioneUtente.getUtenteInSessione().getNomeUtente());

        // finche il gioco non è finito e non sono squalificato
        while (!gioco.finito() && !gioco.getSqualificato()) {
            Prova prova = gioco.getCurrentProva(); // Qui invoca il metodo delle prove matematiche
            System.out.println("Domanda:" + prova.getDomande());
            float risposta = scannerNum.nextFloat();

            gioco.rispondi(risposta);
        }

        punteggio = punteggio + gioco.getPunteggioTotale();
        if (gioco.getSqualificato()) {
            System.out.println("Hai raggiunto il limite di errori. Sei stato rimosso dal gioco.");
            GestioneUtente.esci();
        } else {
            System.out.println("Gioco completato con successo! Punteggio finale: " + punteggio);
        }
        GestioneUtente.incrementaPunteggio(punteggio);
        if (punteggio < 5) {
            GestioneUtente.decrementaDifficoltà();
        } else {
            GestioneUtente.incrementaDifficoltà();
        }
    }

    // Modifica del profilo dell'utente loggato
    public static void modificaProfilo(String nomeUtente, String password) {
        if (gestioneUtente.getUtenteInSessione() == null) {
            System.out.println("Per modificare, devi prima effettuare il login.");
            return;
        }
        GestioneUtente.modifica(nomeUtente, password);
    }
}
