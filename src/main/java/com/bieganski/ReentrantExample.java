package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample implements Runnable {
  private ReentrantLock reentrantLock;

  ReentrantExample(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    reentrantLock.lock();
    try {
      doAction("Obtained lock");
    } finally {
      doAction("Realised lock");
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
