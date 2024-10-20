import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Random;

//??
public class Loto {

    public BigDecimal factorial(int n){
        BigDecimal fact = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigDecimal.valueOf(i));
        }
        return fact;
    }

    public BigDecimal chances(int n, int k) {

        BigDecimal fact1 = factorial(n);
        BigDecimal fact2 = factorial(k);
        BigDecimal fact3 = factorial(n - k);

        fact1 = fact1.divide(fact2);
        fact1 = fact1.divide(fact3);

        fact1 = BigDecimal.valueOf(1).divide(fact1, 10, BigDecimal.ROUND_HALF_UP);

        return fact1;
    }

    public void simulare(){
        Random rand = new Random();
        int[] numere = new int[7];
        int j = 0;

        System.out.println("Numerele extase sunt ");
        while(j < 6){
            numere[j] = rand.nextInt(50); //genereaza numere random intre 0 si 49
            System.out.print(numere[j] + " ");
            j++;
        }

        long nr = 0;
        for(int i = 0; i < 6; i++){
            nr = nr | (1L << numere[i]);
        }

        System.out.println();
        for(int i = 0; i <= 49; i++){
            if(((1L << i) & nr) != 0){
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args){
        System.out.println("Introduceti 2 numere tipul de joc ");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        Loto loto = new Loto();
        System.out.println("Sansele de castig sunt " + loto.chances(n, k));
        loto.simulare();
    }
}
