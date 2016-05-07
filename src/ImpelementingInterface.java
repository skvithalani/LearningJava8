/**
 * Created by salonivithalani on 5/4/16.
 */

interface Callable{
    void call();
    default void stdCall(){
        System.out.println("in std call");
    }
}

class AndroidPhone implements Callable{

    @Override
    public void call() {
        System.out.println("in android call");
    }
}
public class ImpelementingInterface {
    public static void main(String[] args){
        Callable androidPhone = new AndroidPhone();
        androidPhone.call();
        androidPhone.stdCall();
    }
}
