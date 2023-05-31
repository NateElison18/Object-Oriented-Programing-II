/**
 *
 * Author: Nate Elison
 * Date: 5/30/23
 *
 * This program uses the Loan class, which now implements Serializable, to create two loans and save their data to a .dat file.
 * Then it calls the outputData method to display the total loan amounts of the two. The method reads the info from the .dat file.
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws IOException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData(new File("Exercise17_07.dat"));
    }

    public static void outputData(File file) throws IOException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        int count = 0;
        try {
            while (true) {
                Loan loan = (Loan) input.readObject();
                double loanAmount= loan.getLoanAmount();
                count++;
                System.out.printf("Loan %d total amount: $%.2f\n", count, loanAmount);
            }
        }
        catch (EOFException | ClassNotFoundException ex){
            input.close();
            System.out.println("All loan amounts displayed.");
        }
    }
}
