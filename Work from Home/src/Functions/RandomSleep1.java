package Functions;
public class RandomSleep1 {
	static long getMillis() {
	    return (long) (Math.random() * 48_000 + 80_000);
	}
}