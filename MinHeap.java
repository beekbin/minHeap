
public class MinHeap {
	protected int[] m_container;
	protected int m_capacity;
	protected int m_num;

	public MinHeap(int capacity) {
		m_capacity = capacity;
		m_num = 0;
		m_container = new int[m_capacity+1];
	}

	public int add(int val) {
		if(m_num == m_capacity) {
			if(m_container[1] >= val) {
				return -1;
			}

			m_container[1] = val;
			sinkDown();
		} else {
			m_num += 1;
			m_container[m_num] = val;
			buildUp();
		}

		return 0;
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
