package bohdan.papizhanskiy.laptops.controller;


import bohdan.papizhanskiy.laptops.dto.request.ScreenRequest;
import bohdan.papizhanskiy.laptops.dto.response.ScreenResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;


    @GetMapping
    public List<ScreenResponse> findAll() {
        return screenService.findAll();
    }


    @PostMapping
    public ScreenResponse save(@RequestBody ScreenRequest screenRequest) throws Exception {
        return screenService.save(screenRequest);
    }

    @DeleteMapping
    public void delete(Long id) throws WrongInputException {
        screenService.delete(id);
    }

    @PutMapping
    public ScreenResponse update(ScreenRequest screenRequest, Long id) throws Exception {
        return screenService.update(screenRequest, id);
    }
}
