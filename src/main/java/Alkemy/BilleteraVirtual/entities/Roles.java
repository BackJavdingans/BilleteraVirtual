package Alkemy.BilleteraVirtual.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {

    @Id
    @Column(name = "idRol")
    private Integer id;

}
