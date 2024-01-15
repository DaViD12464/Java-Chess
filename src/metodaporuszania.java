import Figury.*;

import java.util.Arrays;


public abstract class metodaporuszania {


    public static boolean ruch(String input, Szachownica szachownica, String kolej)
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

            if (zdekodowanyRuch.length==3 && (zdekodowanyRuch[1].charAt(0) >= '0' && zdekodowanyRuch[1].charAt(0) <= '7') && (zdekodowanyRuch[2].charAt(0) >= '0' && zdekodowanyRuch[2].charAt(0) <= '7')) {
                String figura = zdekodowanyRuch[0];
                switch (figura)
                {
                    case " O ":
                    {
                        String name = "Pion" + zdekodowanyRuch[1];
                        // if czy bicie czy ruch
                        Pion.ruch(Integer.parseInt(zdekodowanyRuch[1]), Integer.parseInt(zdekodowanyRuch[2]), name);
                        // Pion.bicie
                    }
                    case " R ":
                    {
                        Wieza.ruch();
                    }
                    case " N ":
                    {
                        Kon.ruch();
                    }
                    case " B ":
                    {
                        Goniec.ruch();
                    }
                    case " Q ":
                    {
                        Hetman.ruch();
                    }
                    case " K ":
                    {
                        Krol.ruch();
                    }

                }

            } else {
                InvalidMove();
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
                zdekodowanyRuch[0] = " O ";
                zdekodowanyRuch[1] = String.valueOf(input.charAt(0));
                zdekodowanyRuch[2] = String.valueOf(input.charAt(1));

            System.out.println("Dekodowany ruch (len.2): " + Arrays.toString(zdekodowanyRuch)); //do sprawdzenia dekodowania - potem usunac

        }

        for (var element : notacjapionowa)
        {
            if(element.equals(zdekodowanyRuch[1]))
            {   System.out.println("przed " +zdekodowanyRuch[1]); // usunac pokazuje dekodowana litere alfabetu
                zdekodowanyRuch[1] = String.valueOf(element.charAt(0) - 'A');
                System.out.println("po "+zdekodowanyRuch[1]); // usunac pokazuje wynik dekodowanej litery w zakresie A=0-H=7
            }
        }

        return zdekodowanyRuch;
    }

    public static void InvalidMove()
    {
        System.out.println(Kolory.BLACK_BACKGROUND + Kolory.YELLOW_BOLD_BRIGHT + "To nie jest prawidłowy ruch w notacji szachowej!" + Kolory.RESET);
    }

}
