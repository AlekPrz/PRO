package alek.app.symulator_ligi.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CompanyTeam {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id")
    @EqualsAndHashCode.Exclude
    private Team team;
    private BigDecimal cost;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate date;
/*


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyTeam that = (CompanyTeam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(date, that.date);
    }
*/

    @Override
    public String toString() {
        return "CompanyTeam{" +
                "id=" + id +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }
}
