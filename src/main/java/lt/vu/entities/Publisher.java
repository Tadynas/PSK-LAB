package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Publisher.findAll", query = "select p from Publisher as p")
})
@Table(name = "PUBLISHER")
@Getter @Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 64)
    @Column(name = "NAME")
    private String name;

    @Column(name = "FOUNDED")
    private Date founded;

    @Size(max = 256)
    @Column(name = "LOGO_LINK")
    private String logoLink;

    @Size(max = 256)
    @Column(name = "WEBSITE_LINK")
    private String websiteLink;

    @OneToMany(mappedBy = "publisher")
    private List<Game> publishedGames = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(founded, publisher.founded) &&
                Objects.equals(logoLink, publisher.logoLink) &&
                Objects.equals(websiteLink, publisher.websiteLink) &&
                Objects.equals(publishedGames, publisher.publishedGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, founded, logoLink, websiteLink, publishedGames);
    }
}
