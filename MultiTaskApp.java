public class MultiTaskApp {

    public static void main(String[] args) {
        // Thread 1: Display numbers
        Thread numThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number Thread: " + i);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        });
        // Thread 2: Display Letters
        Thread lettThread = new Thread(() -> {
            for (char letter = 'A'; letter <= 'E'; letter++) {
                System.out.println("Letter Thread: " + letter);
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        });
        // Thread 3: Background activity
        Thread backgroundThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Background Task: Running " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        });
        // Start all three threads
        numThread.start();
        lettThread.start();
        backgroundThread.start();

        System.out.println("All task have started");
    }
}