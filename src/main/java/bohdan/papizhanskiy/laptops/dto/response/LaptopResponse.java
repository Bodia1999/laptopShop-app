package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Getter
@Setter
@NoArgsConstructor
public class LaptopResponse {
    private Long id;

    private Long makeId;
    private String makeName;

    private String model;

    private String imageDirection;

    private String descriptionImagePath1;
    @Type(type = "text")
    private String descriptionFirstParagraph;
    private String descriptionImagePath2;
    @Type(type = "text")
    private String descriptionSecondParagraph;
    private String descriptionImagePath3;
    @Type(type = "text")
    private String descriptionThirdParagraph;

    private Double price;


    private Long graphicCardId;
    public GraphicCardResponse graphicCard;

    private Long ramId;
    private RamResponse ram;

    private Long processorId;
    private ProcessorResponse processor;

    private Long memoryId;
    private MemoryResponse memory;

    private Long corpsId;
    private CorpsResponse corps;

    private Long screenId;
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
        makeId = laptop.getMake().getId();
        makeName = laptop.getMake().getName();
        imageDirection = laptop.getImageDirection();
        descriptionImagePath1 = laptop.getDescriptionImagePath1();
        descriptionImagePath1 = laptop.getDescriptionImagePath2();
        descriptionImagePath1 = laptop.getDescriptionImagePath3();

        price = laptop.getPrice();
        descriptionImagePath1 = laptop.getDescriptionImagePath1();
        descriptionImagePath2 = laptop.getDescriptionImagePath2();
        descriptionImagePath3 = laptop.getDescriptionImagePath3();
        descriptionFirstParagraph = laptop.getDescriptionFirstParagraph();
        descriptionSecondParagraph = laptop.getDescriptionSecondParagraph();
        descriptionThirdParagraph = laptop.getDescriptionThirdParagraph();
        graphicCardId = laptop.getGraphicCard().getId();
        graphicCard = new GraphicCardResponse(laptop.getGraphicCard());
        ramId = laptop.getRam().getId();
        ram = new RamResponse(laptop.getRam());
        screenId = laptop.getScreen().getId();
        screen = new ScreenResponse(laptop.getScreen());
        processorId = laptop.getProcessor().getId();
        processor = new ProcessorResponse(laptop.getProcessor());
        memoryId = laptop.getMemory().getId();
        memory = new MemoryResponse(laptop.getMemory());
        corpsId = laptop.getCorps().getId();
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
