package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MakeFilterRequest {
    private String name;
    private PaginationRequest pagination;
}
