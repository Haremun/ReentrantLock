package com.bieganski;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class App {
  public static void main(String[] args) {
//		ReentrantLock reentrantLock = new ReentrantLock(true);
//		new Thread(new TryLockWithOffset(reentrantLock), "First Thread").start();
//		new Thread(new TryLockWithOffset(reentrantLock), "Second Thread").start();

//    ReentrantLock reentrantLock = new ReentrantLock(true);
//    int threadsCount = 250;
//    ExecutorService service = Executors.newFixedThreadPool(threadsCount);
//    IntStream.range(0, threadsCount).forEach(x -> service.execute(new LockExample(reentrantLock, 5)));
//    service.shutdown();

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Map<Integer, String> philosophers = new HashMap<>();
    philosophers.put(1, "Aristotle");
    philosophers.put(2, "Immanuel Kant");
    philosophers.put(3, "Plato");
    philosophers.put(4, "Confucius");
    philosophers.put(5, "David Hume");
    philosophers.put(6, "Socrates");
    philosophers.put(7, "Al-Ghazali");
    philosophers.put(8, "Sun Tzu");
    philosophers.put(0, "Epicure");
    int threadsCount = 5;
    ExecutorService service = Executors.newFixedThreadPool(threadsCount);
    IntStream.range(0, threadsCount).forEach(x -> service.execute(new ReadWriteExample(readWriteLock, philosophers)));
    service.shutdown();

  }
}
