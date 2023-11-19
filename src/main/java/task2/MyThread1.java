package task2;

public class MyThread1 extends Thread{
    private MyProgramState state;

    public MyThread1(MyProgramState state) {this.state = state;}

    @Override
    public void run() {
        while (!state.isFinish()){
            state.setSwitcher(!state.isSwitcher());
            if(!state.isSwitcher()){
                System.out.println("Pause.");
            }
            try {
                sleep(100);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
