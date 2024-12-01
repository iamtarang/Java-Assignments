package Assignment6;

class CustomStack {

	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	int ptr = -1;

	public CustomStack() {
		this(DEFAULT_SIZE);
	}

	public CustomStack(int size) {
		this.data = new int[size];
	}

	public boolean isFull() {
		return ptr == data.length - 1;
	}

	public boolean isEmpty() {
		return ptr == -1;
	}

	public boolean push(int item) {
		if (isFull()) {
			System.out.println("Stack is full");
			return false;
		}

		ptr++;
		data[ptr] = item;
		return true;
	}

	public int pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Cannot pop from an empty stack.");
		}
		int removed = data[ptr];
		ptr--;
		return removed;
	}

	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Cannot peek from empty stack");
		}
		return data[ptr];
	}
}


public class StackThread extends Thread {
    private CustomStack stack;
    private boolean isPusher;

    public StackThread(CustomStack stack, boolean isPusher) {
        this.stack = stack;
        this.isPusher = isPusher;
    }

    @Override
    public void run() {
        if (isPusher) {
            for (int i = 0; i < 5; i++) {
                stack.push(i);
                System.out.println(Thread.currentThread().getName() + " pushed: " + i);
                try {
                    Thread.sleep(100);  // Small delay to simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                try {
                    int value = stack.pop();
                    System.out.println(Thread.currentThread().getName() + " popped: " + value);
                } catch (StackException e) {
                    System.out.println(Thread.currentThread().getName() + ": " + e.getMessage());
                }
                try {
                    Thread.sleep(100);  // Small delay to simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class StackTest {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);

        Thread pusher1 = new StackThread(stack, true);
        Thread pusher2 = new StackThread(stack, true);
        Thread popper1 = new StackThread(stack, false);
        Thread popper2 = new StackThread(stack, false);

        pusher1.start();
        pusher2.start();
        popper1.start();
        popper2.start();

        try {
            pusher1.join();
            pusher2.join();
            popper1.join();
            popper2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}