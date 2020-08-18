package cn.kzhou.structure.general;

public class CaseInComparator implements Comparator<String> {

    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}
