package kai.study.dao;

import kai.study.models.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProducerDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProducerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Producer> readAll(){
        return jdbcTemplate.query("SELECT * FROM Producer", new BeanPropertyRowMapper<>(Producer.class));
    }

    public Producer read(String name){
        return jdbcTemplate.query("SELECT * FROM Producer WHERE producer_Name=?", new Object[]{name}, new BeanPropertyRowMapper<>(Producer.class))
                .stream().findAny().orElse(null);
    }

    public void update(String name, Producer updatedProducer){
        jdbcTemplate.update("UPDATE Producer SET country=? WHERE producer_Name=?", updatedProducer.getCountry(), name);
    }

    public void save(Producer producer){
        jdbcTemplate.update("INSERT INTO Producer VALUES (DEFAULT, ?)", producer.getCountry());
    }

    public void delete(String name){
        jdbcTemplate.update("DELETE FROM Producer WHERE producer_Name=?", name);
    }
}
