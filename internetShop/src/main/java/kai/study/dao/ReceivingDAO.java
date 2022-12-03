package kai.study.dao;

import kai.study.models.Receiving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReceivingDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReceivingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Receiving> readAll(){
        return jdbcTemplate.query("SELECT * FROM Receiving", new BeanPropertyRowMapper<>(Receiving.class));
    }

    public Receiving read(String name){
        return jdbcTemplate.query("SELECT * FROM Receiving WHERE receive_Method=?", new Object[]{name}, new BeanPropertyRowMapper<>(Receiving.class))
                .stream().findAny().orElse(null);
    }

    public void update(Receiving updatedReceiving){
        jdbcTemplate.update("UPDATE Receiving SET receiving_Method=?, address=? WHERE receiving_Method=?", updatedReceiving.getReceiving_Method(),
                updatedReceiving.getAddress(), updatedReceiving.getReceiving_Method());
    }

    public void save(Receiving receiving){
        jdbcTemplate.update("INSERT INTO Receiving VALUES (?, ?)", receiving.getReceiving_Method(), receiving.getAddress());
    }

    public void delete(String name){
        jdbcTemplate.update("DELETE FROM Receiving WHERE receive_Method=?", name);
    }
}
