package alek.app.symulator_ligi.repository;

import alek.app.symulator_ligi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {


    Optional<Team> findByName(String name);

}
