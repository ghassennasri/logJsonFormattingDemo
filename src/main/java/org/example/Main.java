package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {
    static   Logger logger = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        int iteration = 0;

        while (true) {
            try {
                // Log an info message
                logger.info("Info: Iteration " + iteration);

                // Every 5 iterations, initiate a recursive method call that ends in an exception
                if (iteration % 5 == 0) {
                    try {
                        recursiveMethod(20); // Adjust the depth as needed
                    } catch (Exception e) {
                        logger.error("An error occurred", e);
                    }
                }

                // Increment the iteration counter
                iteration++;

                // Wait for 1 second (1000 milliseconds) before the next iteration
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                // Exit the loop if the thread is interrupted
                break;
            }
        }
    }

    private static void recursiveMethod(int depth) {
        if (depth == 0) {
            throw new RuntimeException("Exception at recursion depth");
        } else {
            recursiveMethod(depth - 1);
        }
    }
}
