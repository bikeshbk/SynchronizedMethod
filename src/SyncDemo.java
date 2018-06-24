class Table {
    synchronized void printTable(String msg) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " : " + msg);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class SyncDemo{
    public static void main(String agrs[]){
        Table t = new Table();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                t.printTable("First Thread");
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                t.printTable("Second Thread");
            }
        };
        thread1.start();
        thread2.start();
    }
}