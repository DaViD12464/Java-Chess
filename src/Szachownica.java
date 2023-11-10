public class Szachownica
{
    public Szachownica()
    {
        rysujSzachownice();
    }

    public void rysujSzachownice()
        {
            System.out.print(" _ _ _ _ _ _ _ _\n");

            for (int i=0; i<8; i++)
            {
                for (int j=0; j<8; j++)
                {
                    System.out.print("■");
                    if (j==7)
                    {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
//         _ _ _ _ _ _ _ _
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
//        |_|_|_|_|_|_|_|_|
        public void rozstawFiguryGracza1()
        {
            Wieza wieza1 = new Wieza();
            Wieza wieza2 = new Wieza();
            Goniec goniec1 = new Goniec();
            Goniec goniec2 = new Goniec();
            Kon kon1 = new Kon();
            Kon kon2 = new Kon();
            Hetman hetman = new Hetman();
            Krol krol = new Krol();
        }
}
