// JAVA program implementing Queue data structure


import java.io.*;
class arrQueue {

	int queue[], front, rear, size;
	BufferedReader qbr = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		arrQueue aq = new arrQueue();
		aq.queueDef();
		aq.queueOps();

	}

	void queueOps() throws IOException {

		System.out.println("\nEnter your choice of action: \n 1. Enqueue  2. Dequeue  3. Peek  4. Display  5. Exit");
		int c = Integer.parseInt(qbr.readLine());

		switch (c) {
		case 1: enqueue();
			break;

		case 2: dequeue();
			break;

		case 3: peek();
			break;

		case 4: dispQueue();
			break;

		case 5: break;
		default: System.out.println("Invalid choice. Try Again\n");
			break;
		}

		if (c != 5)
			queueOps();
	}

	void queueDef() throws IOException {
		System.out.println("Enter the size of the queue: ");
		size = Integer.parseInt(qbr.readLine());
		front = rear = -1;
		queue = new int[size];
	}

	void dispQueue() {

		int tf = front;
		System.out.print("Queue: ");
		while (tf < rear) {
			System.out.print(queue[tf] + " ");
			tf++;
		}

		System.out.println();
	}

	void enqueue() throws IOException {
		if (rear == -1) {
			front = 0;
			rear = 0;
		}

		if (rear >= size)
			System.out.println("Queue is Full!");
		else {
			System.out.println("Enter the element to be inserted: ");
			int x = Integer.parseInt(qbr.readLine());
			queue[rear] = x;
			rear++;
			dispQueue();
		}
	}

	void dequeue() {
		if (front == rear) {
			System.out.println("Queue is Empty!");

		} else {

			System.out.println("Element removed: " + queue[front]);
			front++;
			if (front >= rear)
				front = rear = -1;
			dispQueue();
		}
	}

	void peek() {
		if (front == rear)
			System.out.println("Queue is Empty!");

		else
			System.out.println("Element at the front: " + queue[front]);
	}
}