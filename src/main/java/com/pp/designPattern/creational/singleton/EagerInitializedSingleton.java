package com.pp.designPattern.creational.singleton;

/**
 * For eager initialization, this singleton class will be created when classes
 * are loaded. The instance is created even if it is not used. Preferred way if
 * the class is not using too much resource.
 * 
 * @author pranav8494
 *
 */
public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client application to use the constructor.
	// Only possible way is through getIntance method.
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}
