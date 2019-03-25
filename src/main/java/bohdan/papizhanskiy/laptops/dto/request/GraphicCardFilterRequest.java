package bohdan.papizhanskiy.laptops.dto.request;

import javafx.scene.control.Pagination;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GraphicCardFilterRequest {

    private List<String> name = new ArrayList<>();

    private List<String> model = new ArrayList<>();

    private Integer volumeOfMemoryFrom;
    private Integer volumeOfMemoryTo;

    private PaginationRequest pagination;
}
