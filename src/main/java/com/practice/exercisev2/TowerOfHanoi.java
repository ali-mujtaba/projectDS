import java.util.*;

public class TowerOfHanoi {
	public static void main(String[] args) {
		Tower[] towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = scanner.nextInt();
		for (int i = n; i > 0; i--) {
			towers[0].add(i);
		}

		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}

class Tower {
	Stack<Integer> disks = new Stack<>();
	int index;

	Tower(int i) {
		index = i;
	}

	public void add(int x) {
		if (!disks.isEmpty() && disks.peek() <= x) {
			System.out.println("Disk placing not allowed!");
		} else {
			disks.push(x);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + this.index + " to " + t.index);
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}

}