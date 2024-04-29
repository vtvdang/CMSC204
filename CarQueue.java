import java.io.*;
import java.util.*;
import java.util.random.*;
public class CarQueue implements Runnable{
/*
 * Add a CarQueue class that maintains a queue of random directions that the car should go.  
 * 
There is an addToQueue method that 
has a class that implements runnable, 
define the run method 
(add random directions into the queue and then sleep),
 creates an instance of the runnable object,
 creates a thread and starts the thread. 
 
/** Adds 0,1,2 or 3 to queue
	     *  0 = up
	     *  1 = down
	     *  2 = right
	     *  3 = left
	     
It also has a deleteQueue method that returns an Integer;

In your constructor, place 5 or 6 numbers in the queue so that when the animation starts there will be something to retrieve from the queue
@author Vivian Dang

 */
    public void run() {}
	    private List<Integer> carQueue;
	    private Random rand;

	    // Constructor
	    public CarQueue() {
	        carQueue = new ArrayList<>();
	        rand = new Random();
	        carQueue.add(rand.nextInt(4));
	        carQueue.add(rand.nextInt(4));
	        carQueue.add(rand.nextInt(4));
	        carQueue.add(rand.nextInt(4));
	        carQueue.add(rand.nextInt(4));    
	    }

	    public void addToQueue() {
	        Runnable runnableObj = new Runnable() {
	        	@Override
	            public void run() {
	                while(carQueue.size() > 0 || carQueue.size() < 0) {
	                    int number = rand.nextInt(4);
	                    carQueue.add(number);
	                    System.out.println(number);
	                }
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                        Thread.currentThread().interrupt();
	                    }
	                }
	        };

	        Thread t = new Thread(runnableObj);
	        t.start();
	    }
      
	    public int deleteQueue() {
	        if (!carQueue.isEmpty()) {
	            return carQueue.remove(0);
	        } else {
	            return -1;
	        }
	    }

		
	}
