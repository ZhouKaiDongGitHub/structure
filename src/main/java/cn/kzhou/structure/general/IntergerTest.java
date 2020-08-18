package cn.kzhou.structure.general;

public class IntergerTest {
    public static void main(String[] args) {
        MemoryCell<Integer> cell = new MemoryCell();
        cell.write(4);
        Object object = cell;
        //MemoryCell<String> cell1 = (MemoryCell<String>)cell;
        //cell1.read();
    }
}
