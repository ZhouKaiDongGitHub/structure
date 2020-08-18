package cn.kzhou.structure.tree;

public class Node {
    private Integer studentNumber;
    private String name;
    private Integer age;
    public Node left;
    public Node rigth;

    public Node(){ }

    public Node(Integer studentNumber,String name,Integer age){
        this.studentNumber = studentNumber;
        this.name = name;
        this.age = age;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Node{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
