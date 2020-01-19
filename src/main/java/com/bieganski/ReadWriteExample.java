package com.bieganski;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample implements Runnable {
  private Map<Integer, String> map;
  private ReentrantReadWriteLock.ReadLock readLock;
  private ReentrantReadWriteLock.WriteLock writeLock;

  ReadWriteExample(ReentrantReadWriteLock readWriteLock, Map<Integer, String> map) {
    this.readLock = readWriteLock.readLock();
    this.writeLock = readWriteLock.writeLock();
    this.map = map;
  }

  @Override
  public void run() {
    editPhilosopher();
    getPhilosopher();
  }
  private void getPhilosopher(){
    readLock.lock();
    System.out.println(Thread.currentThread().getName() + " " + map.get(new Random().nextInt(map.size())));
    readLock.unlock();
  }
  private void editPhilosopher(){
    writeLock.lock();
    int rand = new Random().nextInt(map.size());
    String philosopher = map.get(rand);
    map.put(rand, philosopher + "!");
    writeLock.unlock();
  }
}
