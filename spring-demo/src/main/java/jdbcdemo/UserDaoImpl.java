package jdbcdemo;

import jdbcdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2024年05月26日 21:20:00
 */
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	@Qualifier("defaultRoutingDataSource")
	private DataSource dataSource;


	@Override
	@DS(value = "master")
	public List<User> getAllUser() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		List<User> query = jdbcTemplate.query("select * from m_user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setUsername(rs.getString(2));
				return user;
			}
		});
		return query;
	}

	@Override
	@DS(value = "slave")
	public List<User> getSlaveAllUser() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		List<User> query = jdbcTemplate.query("select * from st_user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setUsername(rs.getString(3));
				return user;
			}
		});
		return query;
	}
}
