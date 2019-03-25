package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CorpsFilterRequest {

    private Double weightFrom;
    private Double weightTo;

    private String colorOfCorps;

    private List<String> materialOfCorps = new ArrayList<>();

    private PaginationRequest pagination;
}
