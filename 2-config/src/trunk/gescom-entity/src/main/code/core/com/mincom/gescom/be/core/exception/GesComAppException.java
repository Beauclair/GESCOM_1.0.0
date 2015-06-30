/**
 * 
 */
package com.mincom.gescom.be.core.exception;

public class GesComAppException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GesComAppException() {
		 
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public GesComAppException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public GesComAppException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public GesComAppException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }

}
