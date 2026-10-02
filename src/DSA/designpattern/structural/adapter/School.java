package DSA.designpattern.structural.adapter;

public class School {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork aw = new AssignmentWork();
        //  aw.setP(); we have to set it but we want it else gives null pointer
        aw.setP(p);
        aw.writeAssignment("I am ready to write an assignment");
    }
}
