/**
 * 
 */
package com.mincom.gescom.be.core.exception;

public class GesComPersistenceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GesComPersistenceException() {
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public GesComPersistenceException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public GesComPersistenceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public GesComPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }
}
