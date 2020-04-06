package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.User;
import org.mybatis.cdi.Mapper;

@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    int updateByPrimaryKey(User record);
}