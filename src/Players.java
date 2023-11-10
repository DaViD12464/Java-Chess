import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Players {

    public static String add_players(String prompt)
            throws IOException
    {
        System.out.println(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();

    }
}

