import java.util.Scanner;

public class Vocala {

    private String cuvant;

    public Vocala(String cuvant){
        this.cuvant = cuvant;
    }

    public int getNumarVocale(){
        char vocale[] = {'A', 'E', 'I', 'O', 'U','a', 'e', 'i', 'o', 'u'};
        int cnt = 0;
        for (int i=0; i<cuvant.length(); i++)
            for (int j=0; j<vocale.length; j++)
                if (vocale[j]==cuvant.charAt(i))
                    cnt++;
        return cnt;
    }

    public int getIndex(String oVocala){
        int poz = -1;
        char voc = oVocala.charAt(0);
        for(int i = 0; i < cuvant.length(); i++){
            if(cuvant.charAt(i) == voc){
                poz = i;
            }
        }
        return poz;
    }

    public static void main(String[] args){

        String contineVocale = "Abc edf io";
        Vocala vocala = new Vocala(contineVocale);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Introduceti o vocala");
        String oVocala = myObj.nextLine();

        System.out.println("Numarul e vocale este " + vocala.getNumarVocale());
        System.out.println("Indexul la care se afla vocala ceruta este " + vocala.getIndex(oVocala));
    }

}