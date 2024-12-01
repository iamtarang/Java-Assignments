package Assignment6;

class SharedResource {
	private int value;

	public SharedResource() {
		this.value = 0;
	}

	public void increment() {
		this.value++;
	}

	public int getValue() {
		return this.value;
	}
}

class Mutex {
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}

class Semaphore {
	private int permits;

	public Semaphore(int permits) {
		this.permits = permits;
	}

	public synchronized void acquire() throws InterruptedException {
		while (permits == 0) {
			wait();
		}
		permits--;
	}

	public synchronized void release() {
		permits++;
		notify();
	}
}

class ProcessWithMutex implements Runnable {
	private SharedResource resource;
	private Mutex mutex;

	public ProcessWithMutex(SharedResource resource, Mutex mutex) {
		this.resource = resource;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				mutex.lock();
				try {
					resource.increment();
					System.out.println(
							Thread.currentThread().getName() + " incremented. New value: " + resource.getValue());
					Thread.sleep(100); // Simulating some work
				} finally {
					mutex.unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ProcessWithSemaphore implements Runnable {
	private SharedResource resource;
	private Semaphore semaphore;

	public ProcessWithSemaphore(SharedResource resource, Semaphore semaphore) {
		this.resource = resource;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				semaphore.acquire();
				try {
					resource.increment();
					System.out.println(
							Thread.currentThread().getName() + " incremented. New value: " + resource.getValue());
					Thread.sleep(100); // Simulating some work
				} finally {
					semaphore.release();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class MutexAndSemaphoreDemo {
	public static void main(String[] args) {
		SharedResource mutexResource = new SharedResource();
		Mutex mutex = new Mutex();

		SharedResource semaphoreResource = new SharedResource();
		Semaphore semaphore = new Semaphore(2); // Allow 2 processes at a time

		Thread[] mutexThreads = new Thread[5];
		Thread[] semaphoreThreads = new Thread[5];

		System.out.println("Starting Mutex demonstration:");
		for (int i = 0; i < 5; i++) {
			mutexThreads[i] = new Thread(new ProcessWithMutex(mutexResource, mutex), "MutexThread-" + i);
			mutexThreads[i].start();
		}

		for (Thread t : mutexThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\nStarting Semaphore demonstration:");
		for (int i = 0; i < 5; i++) {
			semaphoreThreads[i] = new Thread(new ProcessWithSemaphore(semaphoreResource, semaphore),
					"SemaphoreThread-" + i);
			semaphoreThreads[i].start();
		}

		for (Thread t : semaphoreThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
