package bohdan.papizhanskiy.laptops.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Make make;

    private String model;

    private Double price;

    @OneToOne
    private Screen screen;

    @OneToOne//(mappedBy = "laptop")
    private Ram ram;

    @OneToOne//(mappedBy = "laptop")
    private Processor processor;

    @OneToOne//(mappedBy = "laptop")
    private Memory memory;

    @OneToOne
    private GraphicCard graphicCard;

    @OneToOne
    private Corps corps;


//    @ManyToMany(mappedBy = "laptops")
//    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "laptop")
    private List<ProductForOrder> productForOrder = new ArrayList<>();

    private Boolean availabilityOfWIFI;

    private Boolean availabilityOfBluetooth;

    private Boolean availabilityOfUSBTypeC;

    private Boolean availabilityOfUSBSecondGeneration;

    private Boolean availabilityOfUSBThirdGeneration;

    private Boolean availabilityOfHDMI;

    private Boolean availabilityOfLAN;

    private Boolean availabilityOfAUX;


}
