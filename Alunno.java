import java.util.Scanner;

/**
 * Aggiungi qui una descrizione della classe Cilindro
 * 
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class Alunno extends Persona {
    protected String section;
    protected int[] votes;

    //Costruttore
    public Alunno(String surname, String name, String section) {
        super(surname, name);
        this.section = section;
        this.votes = new int[5];
    }

    //Prendo la sezione
    public void getSection(String section) {
        this.section = section;
    }

    //Prendo i voti
    public int[] getVotes() {
        return votes;
    }

    //Funzione per aggiungere i voti nell'array
    public void addVote(int index, int vote) {
        if (index >= 0 && index < votes.length) {
            votes[index] = vote;
        } else {
            System.out.println("Voto non valido");
        }
    }
        
    //Prendo i voti
    public void getVotes(Scanner scan) {
        for (int i = 0; i < votes.length; i++) {
            System.out.println("Inserire il voto " + (i + 1) + ": ");
            int vote = scan.nextInt();
            addVote(i, vote);
        }
    }

    //Booleano per bocciato/promosso
    public boolean isFailed() {
        for (int vote : votes) {
            if (vote <= 5) {
                return true;
            }
        }
        return false;
    }

    //Risultato promosso/Bocciato
    public String resultAlunno() {
        StringBuilder result = new StringBuilder("Voti dell'alunno:\n");
        for (int i = 0; i < getVotes().length; i++) {
            result.append("Inserire il voto ").append(i + 1).append(": ").append(getVotes()[i]).append("\n");
            //System.out.println("Inserire il voto " + (i + 1) + ": " + getVotes()[i] + "\n");
        }
        if (isFailed()) {
            // result.append("L'alunno "+ name +" " + surname + " è bocciato.");
            System.out.println("L'alunno "+ name +" " + surname + " è bocciato.");

        } else {
            // result.append("L'alunno " + name + " " + surname + " è promosso.");
            System.out.println("L'alunno "+ name +" " + surname + " è promosso.");

        }
        return result.toString();
    }

}
