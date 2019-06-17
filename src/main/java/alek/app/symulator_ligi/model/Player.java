package alek.app.symulator_ligi.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

public class Player {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;


    private Integer age;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @EqualsAndHashCode.Exclude

    private Team team;
    @Column(name = "Position")
    @Enumerated(EnumType.STRING)
    private Poisiton poisiton;

    private BigDecimal pension;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate date;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname) &&
                Objects.equals(age, player.age);
    }


}
