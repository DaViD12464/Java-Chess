public class Szachownica
{
    public void rysujSzachownice()
        {
            System.out.print(" _ _ _ _ _ _ _ _\n");

            for (int i=0; i<8; i++)
            {
                for (int j=0; j<8; j++)
                {
                    System.out.print("|_");
                    if (j==7)
                    {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
}
