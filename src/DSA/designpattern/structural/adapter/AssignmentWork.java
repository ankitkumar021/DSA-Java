package DSA.designpattern.structural.adapter;

//The Adapter design pattern is a structural design pattern that allows incompatible interfaces to work together
//by acting as a bridge between them.
//use -case is payment gateway integration adapting different payment provider (paypal,razorpay)
//to work with common interface.


//so here we have  a class file(PilotPen) and
//we have to use his class file as per my req with the help of adapter(penAdapter)
public class AssignmentWork {
    private Pen p ;
    public Pen getP() {
        return p;
    }
    public void setP(Pen p) {
        this.p = p;
    }
    public void writeAssignment(String str){
        p.write(str);
    }
}
