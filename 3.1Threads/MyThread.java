public class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            if (Thread.currentThread().getName().equals("t2")) {
                try {
                    for(char c='A';c<='Z';c++) {
                        notifyAll();
                        System.out.println(c);
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Thread.currentThread().getName().equals("t1")) {
                try {
                    for(int i=1; i<53;i++) {
                        notifyAll();
                        System.out.print(i++);
                        System.out.print(" ");
                        System.out.print(i);
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {

        MyThread obj = new MyThread();
        Thread t1 = new Thread(obj, "t1");
        Thread t2 = new Thread(obj, "t2");
        t1.start();
        t2.start();

    }
}