package kai.study.dao;

import kai.study.models.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderingDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ordering> readAll(){
        return jdbcTemplate.query("SELECT * FROM Ordering", new BeanPropertyRowMapper<>(Ordering.class));
    }

    public Ordering read(int id){
        return jdbcTemplate.query("SELECT * FROM Ordering WHERE order_ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(Ordering.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Ordering updatedOrdering){
        jdbcTemplate.update("UPDATE Ordering SET goods_ID=?, client_ID=?, count=?," +
                "price=?, receive_Method=?, pay_Method=? WHERE order_ID=?", updatedOrdering.getGoods_ID(),
                updatedOrdering.getClient_ID(), updatedOrdering.getCount(), updatedOrdering.getPrice(),
                updatedOrdering.getReceive_Method(), updatedOrdering.getPay_Method(), id);
    }

    public void save(Ordering ordering){
        jdbcTemplate.update("INSERT INTO Ordering VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)", ordering.getGoods_ID(),
                ordering.getClient_ID(), ordering.getCount(), ordering.getPrice(), ordering.getReceive_Method(),
                ordering.getPay_Method());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Ordering WHERE order_ID=?", id);
    }
}
