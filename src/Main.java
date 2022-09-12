import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static double hoofdsom = 0;
    private static double rente = 0;
    private static int looptijd = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isFoutAntwoord;
        do {
            isFoutAntwoord = false;
            try {
                System.out.println("""
                        Kies gewenste hypotheekvorm om te berekenen.
                        1. lineair
                        2. Annuiteit
                        3. Spaar
                        4. Bereken elke vorm""");
                switch (sc.nextInt()) {
                    case 1 -> {
                        getData();
                        lineair();
                    }
                    case 2 -> {
                        getData();
                        annuiteit();
                    }
                    case 3 -> {
                        getData();
                        spaar();
                    }
                    case 4 -> {
                        getData();
                        lineair();
                        annuiteit();
                        spaar();
                    }
                    default -> {
                        isFoutAntwoord = true;
                        System.out.println("Keuze is ongeldig, maak een keuze uit: 1 t/m 4");
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Keuze is ongeldig, maak een keuze uit: 1 t/m 4\"");
                sc.nextLine();
                isFoutAntwoord = true;
            }

        }
        while (isFoutAntwoord);
    }

    public static void getData() {
        Scanner sc = new Scanner(System.in);
        // Ask for lening data:
        do {
            System.out.print("Voer het gewenst lening bedrag in: ");
            try {
                hoofdsom = sc.nextDouble();
                if (hoofdsom < 0) {
                    System.out.println("Invoer mag niet negatief zijn");
                }
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Fout!" + hoofdsom + " is geen geldig bedrag.");
            }
        }
        while (hoofdsom <= 0);
        // ask for interest percentage
        do {
            System.out.print("Voer het rente percentage in. B.v. \"4,0\" ");
            try {
                rente = sc.nextDouble();
                if (rente < 0) {
                    System.out.println("Invoer mag niet negatief zijn");
                }
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Invoer mag geen decimaal punt bevatten.Invoeren met komma.");
            }
        }
        while (rente <= 0);
        // ask for number of payments
        do {
            System.out.print("Voer de looptijd in.(Integer)");
            try {
                looptijd = sc.nextInt();
                if (looptijd < 0) {
                    System.out.println("Invoer mag niet negatief zijn");
                }
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Invoer is geen integer.");
            }
        }
        while (looptijd <= 0);
    }

    public static void lineair() {
        Hypotheek lineair = new Lineair("Lin12345", "Lineaire", hoofdsom, rente, looptijd);
    }

    public static void annuiteit() {
        Hypotheek annuiteit = new Annuiteit("Anu123456", "Annuiteiten", hoofdsom, rente, looptijd);
    }

    public static void spaar() {
        Hypotheek spaar = new Spaar("Spa12345", "Spaar", hoofdsom, rente, looptijd);
    }

}

