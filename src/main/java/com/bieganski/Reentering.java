package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Reentering implements Runnable {
  private ReentrantLock reentrantLock;

  Reentering(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    reentrantLock.lock();
    try {
      doAction("Obtained lock");
      reentrantLock.lock();
      doAction("Obtained lock second time");
    } finally {
      realiseLock();
    }
  }

  private void realiseLock() {
    IntStream.range(0, reentrantLock.getHoldCount()).forEach(x -> {
      System.out.println("Realise lock: " + x);
      reentrantLock.unlock();
    });
  }

  private void doAction(String msg) {
    try {
      System.out.println(Thread.currentThread().getName() + ": " + msg);
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
