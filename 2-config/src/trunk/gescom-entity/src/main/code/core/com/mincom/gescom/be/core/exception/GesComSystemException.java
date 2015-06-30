package com.mincom.gescom.be.core.exception;


public class GesComSystemException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GesComSystemException() {
		 
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public GesComSystemException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public GesComSystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public GesComSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }
}
