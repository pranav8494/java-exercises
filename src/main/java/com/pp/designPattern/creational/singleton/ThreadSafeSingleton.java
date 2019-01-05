package com.pp.designPattern.creational.singleton;

/**
 * Making global access method Synchronized makes a singleton thread safe.
 * 
 * <br/>
 * <br/>
 * But this comes with a cost on performance associated with the synchronized
 * method.
 * 
 * @author pranav8494
 *
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	// private constructor for singleton.
	private ThreadSafeSingleton() {
	}

	/**
	 * Get the singleton instance. Here <b>double checked locking</b> is used to reduce
	 * the cost of synchronized and it'll be done only for first call.
	 * 
	 * @return
	 */
	public static ThreadSafeSingleton getInstance() {
		if (instance == null) {
			// double checked locking with synchronized within the null check.
			synchronized (ThreadSafeSingleton.class) {
				instance = new ThreadSafeSingleton();
			}
		}
		return instance;
	}

}
