package lt.vu.mybatis.model;

public class UserGame {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USER_GAME.USER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USER_GAME.GAME_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private Integer gameId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USER_GAME.USER_ID
     *
     * @return the value of PUBLIC.USER_GAME.USER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USER_GAME.USER_ID
     *
     * @param userId the value for PUBLIC.USER_GAME.USER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USER_GAME.GAME_ID
     *
     * @return the value of PUBLIC.USER_GAME.GAME_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USER_GAME.GAME_ID
     *
     * @param gameId the value for PUBLIC.USER_GAME.GAME_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}