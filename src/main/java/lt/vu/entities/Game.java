package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Game.findAll", query = "select g from Game as g")
})
@Table(name = "GAME")
@Getter @Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 64)
    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private float price;

    @Size(max = 256)
    @Column(name = "COVER_LINK")
    private String coverLink;

    @ManyToOne
    @JoinColumn(name="PUBLISHER_ID", referencedColumnName = "ID")
    private Publisher publisher;

    @ManyToMany(mappedBy = "purchasedGames")
    private List<User> usersWhoPurchased = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(title, game.title) &&
                Objects.equals(price, game.price) &&
                Objects.equals(coverLink, game.coverLink) &&
                Objects.equals(publisher, game.publisher) &&
                Objects.equals(usersWhoPurchased, game.usersWhoPurchased);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, coverLink, publisher, usersWhoPurchased);
    }
}
