package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Clob;

@Getter
@Setter
@NoArgsConstructor
public class LaptopResponse {
    private Long id;

    private String makeName;

    private String model;

    private Double price;

    private Clob description;

    public GraphicCardResponse graphicCard;

    private RamResponse ram;

    private ProcessorResponse processor;

    private MemoryResponse memory;

    private CorpsResponse corps;

    private ScreenResponse screen;

    private Boolean availabilityOfWIFI;

    private Boolean availabilityOfBluetooth;

    private Boolean availabilityOfUSBTypeC;

    private Boolean availabilityOfUSBSecondGeneration;

    private Boolean availabilityOfUSBThirdGeneration;

    private Boolean availabilityOfHDMI;

    private Boolean availabilityOfLAN;

    private Boolean availabilityOfAUX;


    public LaptopResponse(Laptop laptop) {
        id = laptop.getId();
        model = laptop.getModel();
        makeName = laptop.getMake().getName();
        price = laptop.getPrice();
        description = laptop.getDescription();
        graphicCard = new GraphicCardResponse(laptop.getGraphicCard());
        screen = new ScreenResponse(laptop.getScreen());
        ram = new RamResponse(laptop.getRam());
        processor = new ProcessorResponse(laptop.getProcessor());
        memory = new MemoryResponse(laptop.getMemory());
        corps = new CorpsResponse(laptop.getCorps());
        availabilityOfWIFI = laptop.getAvailabilityOfWIFI();
        availabilityOfBluetooth = laptop.getAvailabilityOfBluetooth();
        availabilityOfUSBTypeC = laptop.getAvailabilityOfUSBTypeC();
        availabilityOfUSBSecondGeneration = laptop.getAvailabilityOfUSBSecondGeneration();
        availabilityOfUSBThirdGeneration = laptop.getAvailabilityOfUSBThirdGeneration();
        availabilityOfHDMI = laptop.getAvailabilityOfHDMI();
        availabilityOfLAN = laptop.getAvailabilityOfLAN();
        availabilityOfAUX = laptop.getAvailabilityOfAUX();


    }
}
