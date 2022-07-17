public class FooBar{
    private int n;
    private int flag;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (flag != 0) {
                this.wait();
            }
            System.out.print("Foo");
            flag++;
            this.notify();
        }
    }

    public synchronized void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (flag != 1) {
                this.wait();
            }
            System.out.print("Bar");
            System.out.println();
            flag--;
            this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
