package tx02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tx02.User;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(User user) {
        String sql = "INSERT INTO t_user VALUES (?,?)";
        return jdbcTemplate.update(sql,user.getId(), user.getName());
    }

    public int update(User user) {
        String sql = "UPDATE t_user SET name=? WHERE id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM t_user WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public User findById(int id) {
        String sql = "SELECT * FROM t_user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM t_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> findByName(String name) {
        String sql = "SELECT * FROM t_user WHERE name=?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(User.class));
    }
}
