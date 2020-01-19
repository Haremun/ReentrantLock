package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample implements Runnable {
  private ReentrantLock reentrantLock;
  private int sleepTime = 1000;

  LockExample(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  LockExample(ReentrantLock reentrantLock, int sleepTime) {
    this.reentrantLock = reentrantLock;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    reentrantLock.lock();
    try {
      doAction("Obtained a lock");
    } finally {
      doAction("Realised a lock");
      reentrantLock.unlock();
    }
  }

  private void doAction(String msg) {
    try {
      System.out.println(Thread.currentThread().getName() + ": " + msg);
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
