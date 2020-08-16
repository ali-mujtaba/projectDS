/*

Question 3.7

*/
package com.practice.exercise;

public class AnimalShelter {
	ShelterNode front, rear;

	public static void main(String[] args) {
		AnimalShelter shelter1 = new AnimalShelter();

		shelter1.enqueue("DOG");
		shelter1.enqueue("DOG");
		shelter1.enqueue("CAT");
		shelter1.enqueue("DOG");
		shelter1.enqueue("CAT");
		shelter1.enqueue("DOG");
		shelter1.enqueue("CAT");
		shelter1.enqueue("CAT");
		shelter1.enqueue("DOG");
		shelter1.displayShelter();

		System.out.println(shelter1.dequeueAny().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueAny().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueDog().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueCat().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueCat().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueCat().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueDog().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueDog().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueCat().data);
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueDog());
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueCat());
		shelter1.displayShelter();
		System.out.println(shelter1.dequeueAny());
		shelter1.displayShelter();
	}

	public void enqueue(String a) {
		ShelterNode newAnimal = new ShelterNode(a);
		if (this.rear == null) {
			this.rear = newAnimal;
			this.front = newAnimal;
			return;
		}

		this.rear.next = newAnimal;
		this.rear = this.rear.next;
	}

	public String peek() {
		if (this.front == null) {
			return null;
		}
		return this.front.data;
	}

	public ShelterNode dequeueAny() {
		if (this.front == null) {
			return null;
		}

		ShelterNode temp = this.front;
		this.front = this.front.next;

		if (this.front == null) {
			this.rear = null;
		}

		return temp;
	}

	public ShelterNode dequeueDog() {
		AnimalShelter bufferShelter = new AnimalShelter();

		while (this.peek() != null) {
			if (this.peek().equals("DOG")) {
				break;
			}
			bufferShelter.enqueue(this.dequeueAny().data);
		}
		ShelterNode selectedAnimal;

		if (this.peek() == null) {
			selectedAnimal = bufferShelter.dequeueAny();

			while (bufferShelter.peek() != null) {
				this.enqueue(bufferShelter.dequeueAny().data);
			}

			return selectedAnimal;
		}


		selectedAnimal = this.dequeueAny();
		while (this.peek() != null) {
			bufferShelter.enqueue(this.dequeueAny().data);
		}

		while (bufferShelter.peek() != null) {
			this.enqueue(bufferShelter.dequeueAny().data);
		}
		return selectedAnimal;
	}

	public ShelterNode dequeueCat() {
		AnimalShelter bufferShelter = new AnimalShelter();

		while (this.peek() != null) {
			if (this.peek().equals("CAT")) {
				break;
			}
			bufferShelter.enqueue(this.dequeueAny().data);
		}

		ShelterNode selectedAnimal;

		if (this.peek() == null) {
			selectedAnimal = bufferShelter.dequeueAny();
			while (bufferShelter.peek() != null) {
				this.enqueue(bufferShelter.dequeueAny().data);
			}

			return selectedAnimal;
		}

		selectedAnimal = this.dequeueAny();
		while (peek() != null) {
			bufferShelter.enqueue(this.dequeueAny().data);
		}

		while (bufferShelter.peek() != null) {
			this.enqueue(bufferShelter.dequeueAny().data);
		}
		return selectedAnimal;
	}
	public void displayShelter() {
		ShelterNode current = this.front;
		System.out.print("Queue: ");
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}
}


class ShelterNode {
	String data;
	ShelterNode next;

	ShelterNode(String d) {
		this.data = d;
		this.next = null;
	}
}