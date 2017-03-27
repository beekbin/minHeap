
import java.util.*;

public class DemoMain {

	public static void testMinHeap(ArrayList<Integer> cases, int capacity) {
		MinHeap mh = new MinHeap(capacity);
		for(int i = 0; i < cases.size(); i ++) {
			mh.add(cases.get(i));
		}

		System.out.println("capacity=" + capacity);
		while(mh.size() > 0) {
			System.out.print(" " + mh.poll());
		}
		System.out.println("" );

		return;
	}

	public static void main(String[] argc) {
		ArrayList<Integer> cases = new ArrayList<Integer>();

		cases.add(35);
		cases.add(1);
		cases.add(23);
		cases.add(12);
		cases.add(4);
		cases.add(2);
		cases.add(15);
		cases.add(24);
		cases.add(26);
		cases.add(33);

		testMinHeap(cases, 3);
		testMinHeap(cases, 5);
		testMinHeap(cases, cases.size());
	}
}
