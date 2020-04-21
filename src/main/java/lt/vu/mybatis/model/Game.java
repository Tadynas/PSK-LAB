package lt.vu.mybatis.model;

import java.util.List;

public class Game {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.COVER_LINK
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private String coverLink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.PRICE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.TITLE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.PUBLISHER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    private Integer publisherId;

    private Publisher publisher;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.ID
     *
     * @return the value of PUBLIC.GAME.ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.ID
     *
     * @param id the value for PUBLIC.GAME.ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.COVER_LINK
     *
     * @return the value of PUBLIC.GAME.COVER_LINK
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public String getCoverLink() {
        return coverLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.COVER_LINK
     *
     * @param coverLink the value for PUBLIC.GAME.COVER_LINK
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.PRICE
     *
     * @return the value of PUBLIC.GAME.PRICE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.PRICE
     *
     * @param price the value for PUBLIC.GAME.PRICE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.TITLE
     *
     * @return the value of PUBLIC.GAME.TITLE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.TITLE
     *
     * @param title the value for PUBLIC.GAME.TITLE
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.PUBLISHER_ID
     *
     * @return the value of PUBLIC.GAME.PUBLISHER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.PUBLISHER_ID
     *
     * @param publisherId the value for PUBLIC.GAME.PUBLISHER_ID
     *
     * @mbg.generated Mon Apr 06 12:40:26 EEST 2020
     */
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publisher getPublisher() { return publisher; }

    public void setPublisher(Publisher publisher) {this.publisher = publisher; }

    private List<User> usersWhoPurchased;

    public List<User> getUsersWhoPurchased() {return usersWhoPurchased; }

    public void setUsersWhoPurchased(List<User> usersWhoPurchased) {this.usersWhoPurchased = usersWhoPurchased; }
}