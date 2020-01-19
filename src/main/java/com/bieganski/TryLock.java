package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
  private ReentrantLock reentrantLock;

  TryLock(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    reentrantLock.tryLock();
    if (reentrantLock.getHoldCount() > 0) {
      try {
        System.out.println(Thread.currentThread().getName() + " Obtained a lock");
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        System.err.println(ex.getMessage());
      } finally {
        reentrantLock.unlock();
      }
    }
  }
}
