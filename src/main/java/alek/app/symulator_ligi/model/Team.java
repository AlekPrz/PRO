package alek.app.symulator_ligi.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Team")


public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "[A-Z ]+", message = "Pole musi mieć duże litery!!!!!")
    private String name;
    @Size(min = 3, max = 4, message = "Pole musi mieć od 3-4 liter")

    private String shortNameOfTeam;
    private String colours;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate creationDate;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "team")
    @EqualsAndHashCode.Exclude

    private Set<CompanyTeam> companyTeams = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "team")
    @EqualsAndHashCode.Exclude

    private Set<Player> player = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortNameOfTeam='" + shortNameOfTeam + '\'' +
                ", colours='" + colours + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name) &&
                Objects.equals(shortNameOfTeam, team.shortNameOfTeam) &&
                Objects.equals(colours, team.colours) &&
                Objects.equals(creationDate, team.creationDate);
    }


}
