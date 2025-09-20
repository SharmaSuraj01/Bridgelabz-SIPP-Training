import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    
    private ListManager listManager = new ListManager();
    
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }
    
    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        
        assertTrue(listManager.removeElement(list, 10));
        assertEquals(1, list.size());
        assertFalse(list.contains(10));
        
        assertFalse(listManager.removeElement(list, 30));
    }
    
    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));
        
        list.add(1);
        list.add(2);
        assertEquals(2, listManager.getSize(list));
    }
}