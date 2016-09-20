//: concurrency/MainThread.java
package concurrency; /* Added by Eclipse.py */

public class MainThread {
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		LiftOff launch2 = new LiftOff();
		System.out.println(new Thread(launch).getName());
		System.out.println(new Thread(launch2).getName());
	}
}
/*
 * Output: #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3),
 * #0(2), #0(1), #0(Liftoff!),
 */// :~
