package com.bieganski;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithOffset implements Runnable {
  private ReentrantLock reentrantLock;

  TryLockWithOffset(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    try {
      //Throws interrupted exception
      doAction();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void doAction() throws InterruptedException {
    //Lock waits some time for lock
    reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS);
    if (reentrantLock.isHeldByCurrentThread()) {
      try {
        System.out.println(Thread.currentThread().getName() + " is doing stuff");
        Thread.sleep(500);
      } finally {
        reentrantLock.unlock();
      }
    }
  }
}
