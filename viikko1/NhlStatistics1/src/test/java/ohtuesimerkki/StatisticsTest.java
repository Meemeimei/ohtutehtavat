package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchWorks() {
        Player a = stats.search("maaaaan");
        Player b = stats.search("malianaisfjha");
        Player c = stats.search("Lemieux");
        Player d = stats.search("Gretzky");
        assertEquals(null, a);
        assertEquals(null, b);
        assertEquals(new Player("Lemieux", "PIT", 45, 54).toString(), c.toString());
        assertEquals(new Player("Gretzky", "EDM", 35, 89).toString(), d.toString());
    }

    @Test
    public void collectingTeamsWorks() {
        List<Player> teamA = stats.team("EDM");
        List<Player> teamB = stats.team("PIT");
        List<Player> expectedTeamA = new ArrayList<>();
        List<Player> expectedTeamB = new ArrayList<>();
        expectedTeamA.add(new Player("Semenko", "EDM", 4, 12));
        expectedTeamB.add(new Player("Lemieux", "PIT", 45, 54));
        expectedTeamA.add(new Player("Kurri", "EDM", 37, 53));
        expectedTeamA.add(new Player("Gretzky", "EDM", 35, 89));

        assertEquals(expectedTeamA.toString(), teamA.toString());
        assertEquals(expectedTeamB.toString(), teamB.toString());
    }

    @Test
    public void topScorersWorks() {
        ArrayList<Player> top = new ArrayList<>();

        top.add(new Player("Gretzky", "EDM", 35, 89));
        top.add(new Player("Lemieux", "PIT", 45, 54));
        top.add(new Player("Yzerman", "DET", 42, 56));
        top.add(new Player("Kurri", "EDM", 37, 53));
        top.add(new Player("Semenko", "EDM", 4, 12));

        assertEquals(top.toString(), stats.topScorers(4).toString());

    }
}
