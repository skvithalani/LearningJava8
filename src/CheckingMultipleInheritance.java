import java.util.Objects;

interface IDemo2{
    void show();
    void hide();
    default void mymethod(){
        System.out.println("in mymethod in IDEMO2");
    };
}
interface IDemo1 {
    void hide();
    default void mymethod(){
        System.out.println("in mymethod IDEMO!");
    };
    default void newmethod(){
        System.out.println("in newmethod of idemo1");
    }

    //this is allowed as it will be overriden in implementing class and class is always extendind Object class
    boolean equals(Object o);
    //overriding java.lang.Object's methods is not allowed in interface
//    default boolean equals(Object o){
//        return true;
//    }
}
abstract class AbsDemo{
    public void show(){
        System.out.println("in show");
    }

    public void mymethod(){
        System.out.println("in ABSDEMO");

    }
    abstract protected void hide();
}

public class CheckingMultipleInheritance extends AbsDemo implements IDemo2, IDemo1 {

    @Override
    public void hide() {
        System.out.println("in hide");
    }

    public static void main(String[] args){
        CheckingMultipleInheritance c = new CheckingMultipleInheritance();
        c.mymethod();
        c.newmethod();
    }
}
