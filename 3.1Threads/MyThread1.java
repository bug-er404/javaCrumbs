public class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            if (Thread.currentThread().getName().equals("t3")) {
                try {
                    for(int i=0; i<10; i++)
                    {
                        System.out.print("B");
                        wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Thread.currentThread().getName().equals("t2")) {
                try {
                    for(int i=0; i<10; i++)
                    {
                        notify();
                        System.out.println("C");
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Thread.currentThread().getName().equals("t1")) {
                try {
                    for(int i=0; i<10; i++)
                    {
                        notifyAll();
                        System.out.print("A");
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
        Thread t3 = new Thread(obj, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}