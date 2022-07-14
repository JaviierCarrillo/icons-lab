package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private Long altura;
    private String historia;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();

    /**@ManyToMany(cascade = CascadeType.ALL,
            targetEntity = PaisEntity.class
    )
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "icon_id"),
            inverseJoinColumns = @JoinColumn(name = "pais_id"))
    private List<PaisEntity> paises = new ArrayList<>();
    */
}
