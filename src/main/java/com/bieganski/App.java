package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class App{
	public static void main(String[] args){
		ReentrantLock reentrantLock = new ReentrantLock();
		new Thread(new TryLockWithOffset(reentrantLock), "First Thread").start();
		new Thread(new TryLockWithOffset(reentrantLock), "Second Thread").start();
	}
}
