package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Publisher;

@Getter @Setter
public class GameDto {

    private String title;

    private float price;

    private String coverLink;

    private int publisherId;

    public GameDto(){}

    public GameDto(String title, float price, String coverLink, int publisherId)
    {
        this.title = title;
        this.price = price;
        this.coverLink = coverLink;
        this.publisherId = publisherId;
    }
}
