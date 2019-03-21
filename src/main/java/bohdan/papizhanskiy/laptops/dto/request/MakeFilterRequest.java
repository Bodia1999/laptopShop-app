package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakeFilterRequest {
    private String name;
    private PaginationRequest pagination;
}
