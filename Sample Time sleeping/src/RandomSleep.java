
public class RandomSleep {
	static long getMillis() {
	    return (long) (Math.random() * 70_000 + 75_000);
	}
}