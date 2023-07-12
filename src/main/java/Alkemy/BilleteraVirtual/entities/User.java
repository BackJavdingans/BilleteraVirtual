package Alkemy.BilleteraVirtual.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE User SET eliminado = true WHERE id ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public Integer Id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private LocalDate creationDate;

    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Roles roles;

    @Column(name = "eliminado", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean deleted;


}
