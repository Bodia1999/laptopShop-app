package bohdan.papizhanskiy.laptops.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class GraphicCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    private String typeOfGraphicCard;

    private Integer volumeOfMemory;

    private String typeOfMemory;

    @OneToOne(mappedBy = "graphicCard")
    private Laptop laptop;
}
