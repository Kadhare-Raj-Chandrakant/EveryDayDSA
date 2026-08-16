/**
 * Time complexity: O(n) where n is the number of functions
 * Space complexity: O(n) for the count and results arrays
 */
class PromiseAll {
    public static Promise promiseAll(Function[] functions) {
        int count = functions.length;
        int[] results = new int[count];
        boolean[] resolved = new boolean[count];
        int resolvedCount = 0;
        long startTime = System.currentTimeMillis();

        return new Promise((resolve, reject) -> {
            for (int i = 0; i < count; i++) {
                try {
                    functions[i].call(resolve -> {
                        try {
                            results[i] = (int) resolve;
                            resolved[i] = true;
                            resolvedCount++;

                            if (resolvedCount == count) {
                                resolve(results);
                            }
                        } catch (Exception e) {
                            reject(e);
                        }
                    }, reject);
                } catch (Exception e) {
                    reject(e);
                }
            }
        });
    }

    public static void main(String[] args) {
        Function[] functions = new Function[] {
            () -> new Promise((resolve, reject) -> {
                try {
                    Thread.sleep(200);
                    resolve(5);
                } catch (InterruptedException e) {
                    reject(e);
                }
            }),
            () -> new Promise((resolve, reject) -> {
                try {
                    Thread.sleep(100);
                    reject("Error");
                } catch (InterruptedException e) {
                    reject(e);
                }
            }),
            () -> new Promise((resolve, reject) -> {
                try {
                    Thread.sleep(50);
                    resolve(4);
                } catch (InterruptedException e) {
                    reject(e);
                }
            }),
            () -> new Promise((resolve, reject) -> {
                try {
                    Thread.sleep(150);
                    resolve(10);
                } catch (InterruptedException e) {
                    reject(e);
                }
            }),
            () -> new Promise((resolve, reject) -> {
                try {
                    Thread.sleep(100);
                    resolve(16);
                } catch (InterruptedException e) {
                    reject(e);
                }
            })
        };

        Promise promise = promiseAll(functions);
        promise.then(results -> System.out.println(java.util.Arrays.toString(results)));
    }
}

interface Function {
    void call(Promise.Resolve resolve, Promise.Reject reject);
}

class Promise {
    public interface Resolve {
        void resolve(Object result);
    }

    public interface Reject {
        void reject(Exception e);
    }

    public Promise(Resolve resolve, Reject reject) {
        this.resolve = resolve;
        this.reject = reject;
    }

    public void then(Object result) {
        System.out.println("Resolved: " + result);
    }

    private Resolve resolve;
    private Reject reject;
}