/**
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class Main {
    public static Function createHelloWorld() {
        return (args) -> "Hello World";
    }

    @FunctionalInterface
    interface Function {
        String apply(Object... args);
    }

    public static void main(String[] args) {
        Function f = createHelloWorld();
        System.out.println(f.apply()); // "Hello World"
        System.out.println(f.apply(new Object[]{}, null, 42)); // "Hello World"
    }
}