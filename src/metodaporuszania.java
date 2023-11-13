import java.util.Arrays;


public abstract class metodaporuszania {

    public static boolean ruch(String input)
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

            if (zdekodowanyRuch != null && zdekodowanyRuch.length==3) {
                //logika sprawdzajaca ruch
                return true;
            } else {
                System.out.println(Kolory.BLACK_BACKGROUND + Kolory.YELLOW_BOLD_BRIGHT + "To nie jest prawidłowy ruch w notacji szachowej!" + Kolory.RESET);
                return false;
            }
        }

    }


    private static String[] dekoderRuchow (String input) //dekoduje input uzytkownika - [0] figura [1] oś a-h [2] - oś 1-8
    {
        String[] zdekodowanyRuch = new String[3];

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

        return zdekodowanyRuch;
    }

}
