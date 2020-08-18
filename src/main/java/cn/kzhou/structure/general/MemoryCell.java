package cn.kzhou.structure.general;

/**
 * 泛型类 MemoryCell
 */
public class MemoryCell < T>{
    private T storedValue;

    public void write(T x){
        storedValue = x;
    }

    public Object read(){
        return storedValue;
    }
}
