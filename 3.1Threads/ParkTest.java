class Park{
    boolean[] park = new boolean[3];
    // remaining vehicles in the parking lot
    private int state =3;

    public synchronized void CarIn(int i) {
        try {
            while(state==0) {
                System.out.println(state+" parking spaces left. Please wait");
                wait();
            }
            System.out.println(i+": Parking Successful");
            state--;
            System.out.println("Remaining spaces: "+state);
            notify();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void CarOut(int i) {
        try {
            while(state==3) {
                wait();
            }
            System.out.println(i+": Car exits.");
            state++;
            System.out.println("Remaining spaces: "+state);
            notify();
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
    }



}
class CarInThread extends Thread{
    Park park=new Park();
    public CarInThread(Park park) {
        this.park=park;
    }

    public void run() {
        super.run();
        for(int i=1;i<6;i++){
            park.CarIn(i);
        }
    }
}
class CarOutThread extends Thread{
    Park park=new Park();
    public CarOutThread(Park park) {
        this.park=park;
    }

    public void run() {
        super.run();
        for(int i=1;i<6;i++){
            park.CarOut(i);
        }
    }
}



public class ParkTest {
    public static void main(String[] args) {
        Park park = new Park();
        new CarInThread( park).start();
        new CarOutThread(park).start();
    }

}