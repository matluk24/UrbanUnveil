package it.unicam.cs.ids.urbanunveil.Utilities;

public class NotInWaitingStateException extends Exception {

	public NotInWaitingStateException()  {
		System.err.print("The content you have requested is not WAITING to be APPROVED nor REFUSED");
	}
}
