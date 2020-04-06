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
        @NamedQuery(name = "User.findAll", query = "select u from User as u")
})
@Table(name = "USER")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 64)
    @Column(name = "USERNAME")
    private String username;

    @Size(max = 64)
    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "USER_GAME",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GAME_ID"))
    private List<Game> purchasedGames = new ArrayList<>();;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(purchasedGames, user.purchasedGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, purchasedGames);
    }
}
