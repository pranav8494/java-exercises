package com.pp.designPattern.creational.singleton;

/**
 * Lazy initialization method to implement Singleton pattern creates the
 * instance in the global access method. 
 * 
 * </br></br>This implementation is fine for
 * single-threaded env but in case of multi-threaded env, if multiple threads
 * access getInstance at the same time, multiple instances will be created which
 * beats the purpose.
 * 
 * @author pranav8494
 *
 */
public class LazyInitializedSingleton {
	
	private static LazyInitializedSingleton instance;
	
	// private constructor to restrict object instantiation.
	private LazyInitializedSingleton(){}
	
	public static LazyInitializedSingleton getInstance(){
		if(instance == null){
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}
