package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.UserGame;
import org.mybatis.cdi.Mapper;

@Mapper
public interface UserGameMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER_GAME
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    int insert(UserGame record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER_GAME
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    List<UserGame> selectAll();
}