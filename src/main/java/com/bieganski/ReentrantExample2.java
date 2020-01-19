package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample2 implements Runnable {
  private ReentrantLock reentrantLock = new ReentrantLock();

  public ReentrantExample2(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    
  }
}
