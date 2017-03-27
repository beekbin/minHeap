
/*The elements of this MinHeap is int. 
  1. If other type of elements want to be processed, two things need to do:
      (1) declear the array of m_container of the desired type array;
      (2) change the compare statements in add(), buildUp(), and sinkDown();
  2. This is a minHeap, which means that the top the elements is the smallest
      in the collection. It can be used to find the Top-K values.
  
*/
public class MinHeap {
	protected int[] m_container;
	protected int m_capacity;
	protected int m_num;

	public MinHeap(int capacity) {
		m_capacity = capacity;
		m_num = 0;
		m_container = new int[m_capacity+1];
	}

	/*try to add a new element into the heap. 
	  @Input: val, the new element;
	  @Output: boolean, whether the new element is added into current heap.
	      false: if the number of elements is equal to the capacity, and
	             if this new element is not bigger than the top of the heap,
		     then, this element won't be able to add to current heap.
	      true: the new element is added to the heap for now.
	*/
	public boolean add(int val) {
		if(m_num == m_capacity) {
			if(m_container[1] >= val) {
				return false;
			}

			m_container[1] = val;
			sinkDown();
		} else {
			m_num += 1;
			m_container[m_num] = val;
			buildUp();
		}

		return true;
	}

	public int size() {
		return m_num;
	}

	protected void swap(int i, int j) {
		int tmp = m_container[i];
		m_container[i] = m_container[j];
		m_container[j] = tmp;
	}

	protected void sinkDown() {
		int i = 1;
		int j = 2 * i;
		while(j <= m_num) {
			if(j + 1 <= m_num) {
				if(m_container[j+1] < m_container[j]) {
					j = j + 1;
				}
			}

			if(m_container[i] > m_container[j]) {
				swap(i, j);
				i = j;
				j = 2 * i;
			} else {
				break;
			}
		}

		return;
	}

	protected void buildUp() {
		int j = m_num;
		int i = j/2;
		while(i > 0) {
			if(m_container[i] > m_container[j]) {
				swap(i, j);
				j = i;
				i = j/2;
			} else {
				break;
			}
		}

		return;
	}

	public int poll() {
		if(m_num < 1) {
			return -1;
		}

		int result = m_container[1];
		m_container[1] = m_container[m_num--];

		sinkDown();

		return result;
	}
}
