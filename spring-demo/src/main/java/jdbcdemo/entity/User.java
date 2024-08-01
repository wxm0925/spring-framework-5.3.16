package jdbcdemo.entity;

/**
 * @author wenxiangmin
 * @ClassName User.java
 * @Description 1
 * @createTime 2024年05月26日 21:19:00
 */
public class User {
	private Long id;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
