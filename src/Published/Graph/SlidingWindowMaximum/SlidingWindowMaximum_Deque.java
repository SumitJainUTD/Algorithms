package Published.Graph.SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_Deque {

    public void slidingWindow(int [] nums, int k){

        Deque<Integer> deque = new LinkedList<>();

        //Step 1: handle first k elements in sliding window
        for (int i = 0; i <k ; i++) {
            //remove all the elements which are smaller than the current elements
            while(deque.isEmpty()==false && nums[deque.peekLast()]<=nums[i])
                deque.removeLast();
            //add new element at the end
            deque.addLast(i);
        }

        //Step 2: handle rest of the element, one at a time nums[k] to nums[n-1]
        for (int i = k; i <nums.length ; i++) {

            //before we do anything, print the first element in deque
            //since its a maximum among previous k elements
            System.out.print(nums[deque.peekFirst()] + " ");

            //Now remove the elements which are out for next window (next k elements)
            while(deque.isEmpty()==false && deque.peekFirst()<=i-k)
                deque.removeFirst();

            //Add the next element in the window = index i
            //remove all the elements which are smaller than the next element = index i
            while(deque.isEmpty()==false && nums[deque.peekLast()]<=nums[i])
                deque.removeLast();
            //add new element at the end
            deque.addLast(i);
        }
    }


    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k = 3;
        SlidingWindowMaximum_Deque s = new SlidingWindowMaximum_Deque();
        s.slidingWindow(nums, k);
    }
}
