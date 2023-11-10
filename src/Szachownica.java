public class Szachownica
{
    public Szachownica()
    {
        rysujSzachownice();
    }

    int[] notacja = {1, 2, 3, 4, 5, 6, 7, 8};
    int z = 8;
    public void rysujSzachownice()
        {
            for (int i=0; i<8; i++)
            {
                for (int j=0; j<8; j++)
                {
                    if ((i + j) % 2 == 0) {
                        System.out.print("■ ");
                    } else {
                        System.out.print("□ ");
                    }
                    if (j==7)
                    {
                        z--;
                        System.out.print(notacja[z]);
                    }
                }
                System.out.println();
            }
            System.out.println("A B C D E F G H");
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
