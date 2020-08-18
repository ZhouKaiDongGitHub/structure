package cn.kzhou.structure.general;

public class MemoryCellTest {

    public static void main(String[] args) {
        MemoryCell<String> m = new MemoryCell();
        m.write("xxx");
        System.out.println("Content x = " + m.read());
    }
}
