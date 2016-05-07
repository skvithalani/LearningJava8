interface Demo{
    void show(int i, String s);
    default void hide (){
        System.out.println("I am default hide method.  .Hey there");
    }
}

//class DemoImpl implements Demo{
//    @Override
//    public void show() {
//        System.out.println("in DemoImpl");
//    }
//}

public class LambdaInAnonymousClass {
    public static void main(String[] args){
//        Demo demo = new Demo() {
//            @Override
//            public void show() {
//                System.out.println("in Demo anonymous");
//            }
//        };

        Demo demo = (i, s) -> {
            System.out.println("in Demo Lambda " + i);
            System.out.println(s);
        }; //This is implementation of Demo Interface

        demo.show(6, "Hello");
        demo.hide();
    }
}
