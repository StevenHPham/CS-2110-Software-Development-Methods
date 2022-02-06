import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Homework 5 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 5 document.
 * 
 * @author YOURID
 *
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

    private LinkedList<String> toPrint;     // the printer's list of documents
    private Lock documentChangeLock;  // a ReentrantLock lock
    private Condition hasPrintTask;   // a condition object
    private boolean isOn;             // boolean variable describing if the 
    // queue is on (accepting jobs)

    //TODO:  Handle locking and conditions around the
    //       enqueueing and dequeuing of documents
    //       in this PrintQueue's document list (toPrint)
    //       Note: See example in the zip folder 'Thread Example 6 - Bank Deadlock' 


    /**
     * Constructor
     */
    public PrintQueue() {
        toPrint = new LinkedList<String>(); // create the list of documents
        isOn = true; // turn on the print queue
        documentChangeLock = new ReentrantLock();
        hasPrintTask = documentChangeLock.newCondition();
    }

    /**
     * enqueue
     * TODO: 
     */
    public void enqueue(String s) {
        documentChangeLock.lock(); //lock the thread as soon as the method is called. 
        try {
            toPrint.add(s); // add to the list of documents
            hasPrintTask.signalAll();
        }
        finally
        {
            documentChangeLock.unlock(); //unlock the thread
        }
    }  
  

    /**
     * dequeue
     * TODO: Write more comments
     */
    public String dequeue() {
        documentChangeLock.lock(); //same as enqueue
        try {
            return toPrint.remove(); // return the first document
        }
        finally {
            documentChangeLock.unlock(); //same as enqueue
        }
    }

    public void turnOff() { //change isOn to false to turn off
       isOn = false;
    }

  /**
   * if isOn is true (on), return true, else return false
   * @return
   */
    public boolean isOn() {
        if (isOn == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PrintQueue q = new PrintQueue();
        //q.enqueue("A");
        System.out.println(q);
    }


}
