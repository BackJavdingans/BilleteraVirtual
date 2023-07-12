package Alkemy.BilleteraVirtual.entities;

import Alkemy.BilleteraVirtual.enums.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE User SET eliminado = true WHERE id ?")
@Where(clause = "eleminado = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @NotNull
    private Double transactionLimit;

    @NotNull
    private Double balance;

    private LocalDate creationDate;

    private LocalDate updateDate;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN")
    private Boolean eliminado;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



}
