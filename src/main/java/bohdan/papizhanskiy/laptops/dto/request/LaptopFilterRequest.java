package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class LaptopFilterRequest {
    private MakeFilterRequest makeFilterRequest;
    private String model;

    private Double priceFrom;

    private Double priceTo;



    private ScreenFilterRequest screenFilterRequest;


    private RamFilterRequest ramFilterRequest;


    private ProcessorFilterRequest processorFilterRequest;


    private MemoryFilterRequest memoryFilterRequest;


    private GraphicCardFilterRequest graphicCardFilterRequest;

    private CorpsFilterRequest corpsFilterRequest;

    private PaginationRequest pagination;
}
