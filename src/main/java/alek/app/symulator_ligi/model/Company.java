package alek.app.symulator_ligi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Company")


public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal budget;
    private String city;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "company")
    @EqualsAndHashCode.Exclude

    private Set<CompanyTeam> companyTeams = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", city='" + city + '\'' +
                '}';
    }
}
