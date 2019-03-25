package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ScreenFilterRequest {

    private List<String> type = new ArrayList<>();;

    private List<String> resolution = new ArrayList<>();;

    private List<String> size = new ArrayList<>();

    private  PaginationRequest pagination;
}
