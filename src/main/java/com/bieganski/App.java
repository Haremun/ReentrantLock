package com.bieganski;

import java.util.concurrent.locks.ReentrantLock;

public class App{
	public static void main(String[] args){
		ReentrantLock reentrantLock = new ReentrantLock();
		new Thread(new ReentrantExample(reentrantLock), "First Thread").start();
		new Thread(new ReentrantExample(reentrantLock), "Second Thread").start();
	}
}
