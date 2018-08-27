import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OxTest {
    @Test
    public void shouldCreateOxObjectCorrectly(){
        Ox ox = new Ox();
        // " 012\n0---\n1---\n2---\n "
        assertEquals(" 012\n0---\n1---\n2---\n",ox.getTableString());
        assertEquals("X",ox.getCurrentPlayer());
        assertEquals(0,ox.getScoreX());
        assertEquals(0,ox.getScoreO());
        assertEquals(0,ox.getScoreDraw());
    }

    @Test
    public void put(){
        Ox ox = new Ox();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n",ox.getTableString());

        ox.put(0,0);
        assertEquals(" 012\n0X--\n1-X-\n2---\n",ox.getTableString());

        ox.put(1,2);
        assertEquals(" 012\n0X--\n1-XX\n2---\n",ox.getTableString());

        ox.switchPlayer();
        ox.put(2,0);
        assertEquals(" 012\n0X--\n1-XX\n2O--\n",ox.getTableString());

        assertEquals(false,ox.put(2,0));

        assertEquals(false,ox.put(3,0));
    }
    @Test
    public void putOver(){
        Ox ox = new Ox();
        assertFalse( ox.put(0,-1));
        assertFalse( ox.put(-2,-1));
    }
    @Test
    public void switchPlayer(){
        Ox ox = new Ox();
        ox.switchPlayer();
        assertEquals("O",ox.getCurrentPlayer());
        ox.switchPlayer();
        assertEquals("X",ox.getCurrentPlayer());
    }

    @Test
    public void checkWin1(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(" 012\n0XXX\n1---\n2---\n",ox.getTableString());
        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(0,1));
        assertEquals(true,ox.checkWin(0,2));

    }

    @Test
    public void checkWin2(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(0,1);
        assertEquals(" 012\n0XX-\n1---\n2---\n",ox.getTableString());
        assertEquals(false,ox.checkWin(0,0));
        assertEquals(false,ox.checkWin(0,1));
    }

    @Test
    public void checkWin3(){
        Ox ox = new Ox();
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertEquals(" 012\n0---\n1XXX\n2---\n",ox.getTableString());
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(1,2));
    }

    @Test
    public void checkWin4(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);
        assertEquals(" 012\n0X--\n1X--\n2X--\n",ox.getTableString());
        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(2,0));
    }

    @Test
    public void checkWin5(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(1,0);
        assertEquals(" 012\n0X--\n1X--\n2---\n",ox.getTableString());
        assertEquals(false,ox.checkWin(0,0));
        assertEquals(false,ox.checkWin(1,0));
    }

    @Test
    public void checkWin6(){
        Ox ox = new Ox();
        ox.put(0,1);
        ox.put(1,1);
        ox.put(2,1);
        assertEquals(" 012\n0-X-\n1-X-\n2-X-\n",ox.getTableString());
        assertEquals(true,ox.checkWin(0,1));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,1));
    }

    @Test
    public void checkWin7(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals(" 012\n0X--\n1-X-\n2--X\n",ox.getTableString());
        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,2));
    }
    @Test
    public void checkWin8(){
        Ox ox = new Ox();
        ox.put(0,2);
        ox.put(1,1);
        ox.put(2,0);
        assertEquals(" 012\n0--X\n1-X-\n2X--\n",ox.getTableString());
        assertEquals(true,ox.checkWin(0,2));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,0));
    }
    @Test
    public void checkWin9(){
        Ox ox = new Ox();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n",ox.getTableString());
        assertEquals(false,ox.checkWin(1,1));

    }
    @Test
    public void reset(){
        Ox ox = new Ox();
        ox.put(0,2);
        ox.put(1,1);
        ox.put(2,0);
        ox.reset();
        assertEquals(" 012\n0---\n1---\n2---\n",ox.getTableString());
        assertEquals("X",ox.getCurrentPlayer());
        assertEquals(0,ox.getTurnCount());
    }

    @Test
    public void getTurn(){
        Ox ox = new Ox();
        assertEquals(0,ox.getTurnCount());
        ox.put(0,0);
        assertEquals(1,ox.getTurnCount());
    }

    @Test
    public void isDraw(){
        Ox ox = new Ox();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.isDraw());

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.isDraw());

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.isDraw());
    }

    @Test
    public void getScoreX(){
        Ox ox = new Ox();
        assertEquals(0,ox.getScoreX());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(1,ox.getScoreX());
    }

    @Test
    public void getScoreO(){
        Ox ox = new Ox();
        ox.switchPlayer();
        assertEquals(0,ox.getScoreO());
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals(1,ox.getScoreO());
    }

    @Test
    public void getScoreDraw(){
        Ox ox = new Ox();
        assertEquals(0,ox.getScoreDraw());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.isDraw());

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.isDraw());

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertEquals(1,ox.getScoreDraw());
    }
}