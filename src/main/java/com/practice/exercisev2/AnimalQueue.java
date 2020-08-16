package com.practice.exercisev2;

import java.util.*;

public class AnimalQueue {
	int order;
	LinkedList<Cat> cats;
	LinkedList<Dog> dogs;

	public AnimalQueue() {
		order = 0;
		dogs = new LinkedList<>();
		cats = new LinkedList<>();
	}
	public static void main(String[] args) {
		AnimalQueue q1 = new AnimalQueue();

		Cat cat = new Cat("Twinkle");
		q1.enqueue(cat);
		Dog dog = new Dog("Rocky");
		q1.enqueue(dog);
		cat = new Cat("Kitty");
		q1.enqueue(cat);
		dog = new Dog("Dodo");
		q1.enqueue(dog);

		System.out.println("dequeueAny: " + q1.dequeueAny().name);
		System.out.println("dequeueCat: " + q1.dequeueCat().name);
		System.out.println("dequeueDog: " + q1.dequeueDog().name);
	}

	void enqueue(Animal animal) {
		animal.order = ++order;

		if (animal instanceof Dog) {
			dogs.addLast((Dog)animal);
		} else if (animal instanceof Cat) {
			cats.addLast((Cat)animal);
		}
	}

	Cat dequeueCat() {
		return cats.poll();
	}

	Dog dequeueDog() {
		return dogs.poll();
	}

	Animal dequeueAny() {
		if (cats.size() == 0) {
			return dequeueDog();
		} else if (dogs.size() == 0) {
			return dequeueCat();
		}

		if (dogs.peek().order < cats.peek().order) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
}

class Animal {
	int order;
	String name;

	Animal(String n) {
		name = n;
		order = 0;
	}
}

class Dog extends Animal {
	Dog(String dn) {
		super(dn);
	}
}

class Cat extends Animal {
	Cat(String dn) {
		super(dn);
	}
}