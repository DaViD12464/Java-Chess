public class Szachownica
{
    boolean pionyRozstawione = false;

    public Szachownica()
    {
        rysujSzachownice();
    }

    int[] notacja = {1, 2, 3, 4, 5, 6, 7, 8};
    int z = 8;
    public void rysujSzachownice()
        {
            System.out.print("A B C D E F G H\n");
            for (int i=0; i<8; i++)
            {
                pionyRozstawione = false;
                if (i == 1 || i == 6)
                {
                    rozstawFiguryGracza1();
                    pionyRozstawione = true;
                    z--;
                    System.out.print(notacja[z]);
                }
                if (!pionyRozstawione) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 == 0) {
                            System.out.print("■ ");
                        } else {
                            System.out.print("□ ");
                        }
                        if (j == 7) {
                            z--;
                            System.out.print(notacja[z]);
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("A B C D E F G H");
        }
        public void rozstawFiguryGracza1()
        {
            for (int i = 0; i < 8; i++) {
                Pion pionek = new Pion();
                System.out.print(pionek.getZnak()+" ");
            }
        }
}
