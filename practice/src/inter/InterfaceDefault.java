package inter;

public interface InterfaceDefault {
    default void defaultPrint() {
        System.out.println("InterfaceDefault print");
    }
}
