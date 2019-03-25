package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MemoryFilterRequest {

    private String name;
    private List<String> typeOfMemory = new ArrayList<>();
    private Integer volumeOfMemoryFrom;
    private Integer volumeOfMemoryTo;

    private PaginationRequest pagination;
}
