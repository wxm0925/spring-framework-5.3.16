package jdbcdemo;

/**
 * @author wenxiangmin
 * @ClassName LookupKeyHolder.java
 * @Description TODO
 * @createTime 2024年05月26日 21:47:00
 */
public class LookupKeyHolder {
	private static ThreadLocal<String> ds = new ThreadLocal<>();

	public static String get() {
		String key = ds.get();
		return key;
	}

	public static void clear() {
		ds.remove();
	}

	public static void set(String key) {
		ds.set(key);
	}
}
