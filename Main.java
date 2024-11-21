import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String scelta;
    while(true){
        // Stampa del menù
        System.out.println("\n--- Menu Gestionale ---");
        System.out.println("1. Login");
        System.out.println("2. Registrazione");
        System.out.println("3. Visualizza Utenti");
        System.out.println("4. Inizia Gioco");
        System.out.println("5. Modifica Profilo");
        System.out.println("6. Esci");
        System.out.print("Inserisci la tua scelta: ");
        scelta=scanner.nextLine();
        Menu.menuPrincipal(scelta);

    }
}}