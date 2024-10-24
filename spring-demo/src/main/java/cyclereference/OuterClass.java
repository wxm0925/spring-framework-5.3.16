package cyclereference;

/**
 * @author wenxiangmin
 * @ClassName OuterClass.java
 * @Description TODO
 * @createTime 2024年08月11日 11:34:00
 */
public class OuterClass {
	private String username="231";

	public void someMethod() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(OuterClass.this.username);
			}
		};

		runnable.run();
	}

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.someMethod();
	}
}
