package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample implements Runnable {
  private ReentrantLock reentrantLock;

  LockExample(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
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
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
