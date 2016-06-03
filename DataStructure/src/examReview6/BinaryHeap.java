package examReview6;

public class BinaryHeap {

	public static final int DEFAULT_CAPACITY = 100;
	private int currentSize;
	private Comparable[] array;

	public BinaryHeap() {
	}

	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	public boolean isFull() {
		return true;
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	public Comparable findMin() {
		return null;
	}

	public void insert(Comparable x) {
		if (isFull()) {
			// throw new Overflow();
		}
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
			array[hole] = array[hole / 2];
			array[hole] = x;
		}
	}

	public Comparable deleteMin() {
		if (isEmpty()) {
			return null;
		}
		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);

		return minItem;
	}

	private void percolateDown(int hole) {
		int child = 0;
		Comparable tmp = array[hole];
		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if(child != currentSize&&array[child+1].compareTo(array[child])<0){
				child++;
			}
			if(array[child].compareTo(tmp)<0){
				array[hole] = array[child];
			}
			else{
				break;
			}
		}
	}
	
	/*
	 * 初始建堆，n个结点，K = log2(N)，从0层开始
	 * 第i层交换的最大次数为k-i
	 * 第i层油2^i个结点
	 * 总交换次数O(n)
	 */
	private void buildHeap(){
		for(int i = currentSize/2;i>0;i--){
			percolateDown(i);
		}
	}

	private boolean isEmpty() {
		return false;
	}

	public static void heapsort(Comparable[]a){
		for(int i =a.length/2;i>=1;i--){
			percDown(a,i,a.length);
		}
		for(int i = a.length;i>1;i--){
			swapReferences(a,1,i);
			percDown(a,1,i-1);
		}
	}
	
	public static void swapReferences(Comparable[]a,int i, int j){
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void percDown(Comparable[]a,int i,int n){
		int child = 0;
		Comparable tmp = null;
		
		for(tmp = a[i]; leftChild(i)<n;i=child){
			child = leftChild(i);
			if(child != n-1&&a[child].compareTo(a[child+1])<0){
				child++;
			}
			if(tmp.compareTo(a[child])<0){
				a[i] = a[child];
			}else{
				break;
			}
			a[i] = tmp;
		}
		
	}
	
	private static int leftChild(int i){
		return 2*i+1;
	}
}
