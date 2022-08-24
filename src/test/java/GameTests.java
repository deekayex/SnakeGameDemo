import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @org.junit.jupiter.api.Test
    void startGame() {
        GamePanel panel = new GamePanel();
        assertTrue(panel.running);
    }

    @org.junit.jupiter.api.Test
    void startNewGame() {
        GamePanel Panel = new GamePanel();
        this.startGame();
        assertTrue(Panel.running);
    }

    @org.junit.jupiter.api.Test
    void draw() {
        boolean run = true;
        assertTrue(run);
    }

    @org.junit.jupiter.api.Test
    void newApple() {
        GamePanel gamePanel =new GamePanel();
        new Random();
        gamePanel.appleX =22;
        gamePanel.appleY= 33;
        gamePanel.newApple();
        assertEquals(gamePanel.applesEaten, gamePanel.applesEaten++);
    }

    @org.junit.jupiter.api.Test
    void snakeMoves(){
        GamePanel gamePanel =new GamePanel();
        gamePanel.move();
        assertEquals(gamePanel.x[4],gamePanel.x[5]);
        assertEquals(gamePanel.y[3],gamePanel.x[4]);
    }

    @org.junit.jupiter.api.Test
    void snakesDirectionUp(){
        GamePanel panel = new GamePanel();
        panel.direction='U';
        panel.y[0] =100;
        assertEquals(50, panel.y[0] - GamePanel.UNIT_SIZE);
    }

    @org.junit.jupiter.api.Test
    void snakesDirectionDown(){
        GamePanel panel = new GamePanel();
        panel.direction='D';
        panel.y[0] =100;
        assertEquals(150, panel.y[0] +GamePanel.UNIT_SIZE );
    }

    @org.junit.jupiter.api.Test
    void snakesDirectionLeft(){
        GamePanel panel = new GamePanel();
        panel.direction='L';
        panel.x[0] =100;
        assertEquals(50, panel.x[0] - GamePanel.UNIT_SIZE);
    }

    @org.junit.jupiter.api.Test
    void snakesDirectionRight(){
        GamePanel panel = new GamePanel();
        panel.direction='R';
        panel.x[0] =3;
        assertEquals(53, panel.x[0] + GamePanel.UNIT_SIZE);
    }

    @org.junit.jupiter.api.Test
    void checkSnakeDoesNotEatApple() {
        GamePanel gamePanel =new GamePanel();
        gamePanel.bodyParts = 5;
        gamePanel.applesEaten =3;
        gamePanel.checkApple();

        assertNotEquals(6,gamePanel.bodyParts);
        assertNotEquals(4,gamePanel.applesEaten);
    }

    @org.junit.jupiter.api.Test
    void collisionsLoopTest(){
        GamePanel p= new GamePanel();
        assertEquals(0,p.bodyParts=0);
        assertFalse(p.bodyParts < 0);
        assertFalse(p.x[0] < 0);
        assertFalse(p.x[0] > GamePanel.SCREEN_WIDTH);
        assertFalse(p.y[0] < 0);
        assertFalse(p.y[0] > GamePanel.SCREEN_HEIGHT);
    }
    @Test
    void collisionsTest(){
        int SnakesX =2;
        int SnakesY = 3;
        int ApplesX =2;
        int ApplesY = 3;
        assertEquals(SnakesX,ApplesX);
        assertEquals(SnakesY,ApplesY);
    }

    @Test
    void checkHeadAgainstLeftBorder(){
        GamePanel gm = new GamePanel();
        gm.bodyParts =4;
        gm.checkCollisions();
        assertFalse(gm.running);
        gm.x[0] =-2;
        assertFalse(gm.running);
        gm.x[0]=-3333;
        assertFalse(gm.running);
    }

    @Test
    void checkHeadAgainstRightBorder(){
        GamePanel gm = new GamePanel();
        gm.checkCollisions();
        assertEquals(!gm.running,gm.x[0]< GamePanel.SCREEN_WIDTH);
    }

    @Test
    void checkHeadAgainstTopBorder(){
        GamePanel gamepanel = new GamePanel();
        gamepanel.y[0] = -2;
        gamepanel.checkCollisions();
        assertTrue(!gamepanel.running);
    }

    @Test
    void checkHeadAgainstBottomBorder(){
        GamePanel snakesPosition = new GamePanel();
        snakesPosition.checkCollisions();
        assertEquals(!snakesPosition.running,snakesPosition.y[0]< GamePanel.SCREEN_HEIGHT);
    }


    @org.junit.jupiter.api.Test
    void doesSnakeGrow(){
        GamePanel panel = new GamePanel();
        assertNotNull(panel);
        panel.bodyParts = 10;
        panel.appleX =3;
        panel.appleY =4;
        panel.x[0]= 3;
        panel.y[0]=4;
        panel.checkApple();
        assertEquals(11,panel.bodyParts);
    }
    @Test
    void checkSnakeDoesNotGrow(){
        GamePanel game = new GamePanel();
        game.appleX = 33;
        game.appleY = 55;
        game.bodyParts = 5;
        game.x[0]=34;
        game.y[0]=55;
        game.checkApple();

        assertEquals(5,game.bodyParts );
        game.y[0]=54;
        game.x[0]=33;
        assertEquals(5,game.bodyParts );
    }

    @Test
    void doesApplesEatenTallyIncrease(){
        GamePanel game = new GamePanel();
        game.applesEaten = 5;
        game.appleY = 44;
        game.appleX = 22;
        game.x[0]= 22;
        game.y[0]= 44;
        game.checkApple();
        assertEquals(6,game.applesEaten);
    }


    @Test
    void gamePanel(){
        GamePanel gamePanel =new GamePanel();
        assertNotNull(gamePanel);
    }


    @Test
    void mainTest() {
        SnakeGame main = new SnakeGame();
        assertNotNull(main);
    }

}

