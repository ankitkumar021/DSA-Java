package DSA.designpattern.creational.factory;

public class OperatingSystemFactory {
    public Os getOs(String str) {
        if(str.equals("ios")){
            return new Ios();
        }
        else if(str.equals("windows")){
            return new Windows();
        }else{
            return new Android();
        }
    }
}
