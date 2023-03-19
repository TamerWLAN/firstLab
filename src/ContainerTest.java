import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void pushBack() {
        var vector = new Container();
        vector.pushBack(5);
        assertEquals(1, vector.length());
        assertEquals(5, vector.at(0));
    }

    @Test
    public void insert() {
        var vector = new Container();
        vector.pushBack(5);
        vector.pushBack(2);

        vector.insert(100,1);

        assertEquals(3, vector.length());
        assertEquals(100, vector.at(1));
    }

    @Test
    public void at() {
        var vector = new Container();
        vector.pushBack(5);

        assertEquals(5,vector.at(0));
    }

    @Test
    public void pop() {
        var vector = new Container();
        vector.pushBack(5);

        var value = vector.pop();
        assertEquals(5, value);
        assertEquals(0, vector.length());
    }

    @Test
    public void deleteAt() {
        var vector = new Container();
        vector.pushBack(5);
        vector.pushBack(2);

        vector.deleteAt(0);

        assertEquals(1, vector.length());
        assertEquals(2, vector.at(0));
    }

    @Test
    public void inTrue() {
        var vector = new Container();
        vector.pushBack(5);

        assertTrue(vector.in(5));
    }

    @Test
    public void inFalse() {
        var vector = new Container();
        vector.pushBack(5);

        assertFalse(vector.in(2));
    }

    @Test
    public void length() {
        var vector = new Container();
        vector.pushBack(5);
        vector.pushBack(5);
        vector.pushBack(5);

        assertEquals(3, vector.length());
    }
}