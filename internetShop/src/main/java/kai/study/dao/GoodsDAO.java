package kai.study.dao;

import kai.study.models.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GoodsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Goods> readAll(){
        return jdbcTemplate.query("SELECT * FROM Goods", new BeanPropertyRowMapper<>(Goods.class));
    }

    public Goods read(int id){
        return jdbcTemplate.query("SELECT * FROM Goods WHERE goods_ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(Goods.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Goods updatedGoods){
        jdbcTemplate.update("UPDATE Goods SET name=?, price=?, producer_Name=?, " +
                "category_ID=?, availability=?, image=? WHERE goods_ID=?",
                updatedGoods.getName(), updatedGoods.getPrice(), updatedGoods.getProducer_Name(),
                updatedGoods.getCategory_ID(), updatedGoods.getAvailability(),
                updatedGoods.getImage(), id);
    }

    public void save(Goods goods){
        jdbcTemplate.update("INSERT INTO Goods VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)", goods.getName(),
                goods.getPrice(), goods.getProducer_Name(), goods.getCategory_ID(),
                goods.getAvailability(), goods.getImage());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Goods WHERE goods_ID=?", id);
    }
}
