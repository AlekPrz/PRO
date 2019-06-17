package alek.app.symulator_ligi.model.dto;

import alek.app.symulator_ligi.model.Poisiton;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerWithNewContract {

    private Long id;

    private BigDecimal pension;
    private BigDecimal newPension;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate newDate;
}
