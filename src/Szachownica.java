import java.util.ArrayList;
import java.util.List;

public class Szachownica
{
    int x=1;
    int y=1;
    List<Integer> wspolrzedne;
    boolean pionyRozstawione = false;

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

                    for (int j = 0; j < 8; j++)
                    {
                        List<Integer> wspolrzedne = new ArrayList<Integer>();
                        wspolrzedne.add(i+1);
                        wspolrzedne.add(j+1);
                        if ((i + j) % 2 == 0) {
                            System.out.print("■ ");
                        } else {
                            System.out.print("□ ");
                        }
                        if (j == 7) {
                            z--;
                            System.out.print(notacja[z]);
                        }
                        //System.out.println("|"+wspolrzedne.get(0)+"=x "+wspolrzedne.get(1)+"=y|");
                    }

                System.out.println();
            }
            System.out.println("A B C D E F G H");
        }
        public void rozstawFiguryGraczy()
        {
            for (int i = 0; i < 8; i++) {
                Pion pionek = new Pion();
                System.out.print(pionek.getZnak()+" ");
            }
        }
}
