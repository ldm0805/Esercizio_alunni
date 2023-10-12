import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String surname, name, section;
        String response;

        do {
            try {
                // Inserimento dati
                System.out.println("Inserire il cognome dell'alunno: ");
                surname = scan.nextLine();
                System.out.println("Inserire il nome dell'alunno: ");
                name = scan.nextLine();
                System.out.println("Inserire la sezione dell'alunno: ");
                section = scan.nextLine();

                // Creazione oggetto e stampa dati alunno.
                Alunno alunnoObj = new Alunno(name, surname, section);
                System.out.println("Alunno: " + alunnoObj.name + " " + alunnoObj.surname + " della sezione " + alunnoObj.section);

                // Inserimento voti
                alunnoObj.getVotes(scan);

                // Stampa promosso o bocciato
                System.out.println(alunnoObj.resultAlunno());
                
                //Inserimento nuovo alunno 
                System.out.println("Vuoi inserire un nuovo alunno? (si/no): ");
                scan.nextLine();
                response = scan.nextLine();
                
            } catch (Exception e) {
                System.err.println("\nErrore!!! " + e.getMessage());
                response = "No"; // Termina il ciclo in caso di errore.
            }
        } while (response.equalsIgnoreCase("si"));

        scan.close();
    }
}
