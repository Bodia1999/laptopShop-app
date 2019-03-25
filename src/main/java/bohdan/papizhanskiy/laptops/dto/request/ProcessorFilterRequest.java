package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProcessorFilterRequest {

    private List<String> name = new ArrayList<>();

    private String model;

    private Integer workingFrequencyFrom;
    private Integer workingFrequencyTo;

    private Integer quantityOfCoresFrom;
    private Integer quantityOfCoresTo;

    private PaginationRequest pagination;
}
