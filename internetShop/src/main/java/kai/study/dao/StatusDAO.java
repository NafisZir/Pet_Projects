package kai.study.dao;

import kai.study.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StatusDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StatusDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Status> readAll(){
        return jdbcTemplate.query("SELECT * FROM Status", new BeanPropertyRowMapper<>(Status.class));
    }

    public Status read(String name){
        return jdbcTemplate.query("SELECT * FROM Status WHERE status_Name=?", new Object[]{name}, new BeanPropertyRowMapper<>(Status.class))
                .stream().findAny().orElse(null);
    }

    public void update(String name, Status updatedStatus){
        jdbcTemplate.update("UPDATE Status SET status_Name=? WHERE status_Name=?", updatedStatus.getStatus_Name(), name);
    }

    public void save(Status status){
        jdbcTemplate.update("INSERT INTO Status VALUES (?)", status.getStatus_Name());
    }

    public void delete(Status status){
        jdbcTemplate.update("DELETE FROM Status WHERE status_Name=?", status.getStatus_Name());
    }
}
