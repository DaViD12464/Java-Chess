import java.util.Arrays;


public abstract class metodaporuszania {

    public static boolean ruch(String input, Szachownica szachownica)
    {
        if(input.equalsIgnoreCase("O-O"))
        {
            //logika roszady krotkiej
            return true;
        }
        if(input.equalsIgnoreCase("O-O-O"))
        {
            //logika roszady dlugiej
            return true;
        }
        else {
            String[] zdekodowanyRuch = dekoderRuchow(input);

            if (zdekodowanyRuch.length==3 && (zdekodowanyRuch[1].charAt(0) >= '1' && zdekodowanyRuch[1].charAt(0) <= '8') && (zdekodowanyRuch[2].charAt(0) >= '1' && zdekodowanyRuch[2].charAt(0) <= '8')) {
                if(zdekodowanyRuch[0].equals("P"))
                {
                    // trzeba zrobić przypisanie wartosci od [A-H] do liczb ktorymi bedzie mozna operowac na pozycjonowaniu na szachownicy os X
                    //oraz przypisanie liczb [1-8] do pozycjonowania po osi Y
                    //potem przypisac wartosc wg zdekodowanej tablicy - wybrac odpowiedni pionek oraz przypisac mu nowa pozycje (stara zastapic polem defaultowym dla pol bialych/czarnych)
                    return true;
                }

            } else {
                System.out.println(Kolory.BLACK_BACKGROUND + Kolory.YELLOW_BOLD_BRIGHT + "To nie jest prawidłowy ruch w notacji szachowej!" + Kolory.RESET);
            }
            return false;
        }

    }


    private static String[] dekoderRuchow (String input) //dekoduje input uzytkownika - [0] figura [1] oś a-h [2] - oś 1-8
    {
        String[] zdekodowanyRuch = new String[3];
        String[] notacjapionowa = {"A","B","C","D","E","F","G","H"};

        if(input.length()==3)
        {
            for (int i = 0; i < 3; i++) {
                zdekodowanyRuch[i] = String.valueOf(input.charAt(i));
            }
            System.out.println("Dekodowany ruch (len.3): " + Arrays.toString(zdekodowanyRuch)); //do sprawdzenia dekodowania - potem usunac
        }
        if(input.length()==2)
        {
            for (int i = 1; i <= 2; i++) {
                zdekodowanyRuch[0] = "P";
                zdekodowanyRuch[i] = String.valueOf(input.charAt(i-1));
            }
            System.out.println("Dekodowany ruch (len.2): " + Arrays.toString(zdekodowanyRuch)); //do sprawdzenia dekodowania - potem usunac

        }

        for (var element : notacjapionowa)
        {
            if(element.equals(zdekodowanyRuch[1]))
            {   System.out.println("przed" +zdekodowanyRuch[1]); // usunac pokazuje dekodowana litere alfabetu
                zdekodowanyRuch[1] = String.valueOf(element.charAt(0)+1 - 'A');

                System.out.println("po"+zdekodowanyRuch[1]); // usunac pokazuje wynik dekodowanej litery w zakresie A=0-H=7
            }


        }
        
        return zdekodowanyRuch;
    }


}
