package bohdan.papizhanskiy.laptops.controller;

import bohdan.papizhanskiy.laptops.dto.request.GraphicCardFilterRequest;
import bohdan.papizhanskiy.laptops.dto.request.GraphicCardRequest;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.dto.response.GraphicCardResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.GraphicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/graphiccard")
public class GraphicCardController {

    @Autowired
    private GraphicCardService graphicCardService;

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<GraphicCardResponse> findAll() {
        return graphicCardService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GraphicCardResponse save(@RequestBody GraphicCardRequest graphicCardRequest) {
        return graphicCardService.save(graphicCardRequest);
    }

//    @PostMapping("/filter")
//    public DataResponse<GraphicCardResponse> findAllByFilter(@RequestBody GraphicCardFilterRequest graphicCardFilterRequest){
//        return graphicCardService.findByFilter(graphicCardFilterRequest);
//    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GraphicCardResponse update(@RequestBody GraphicCardRequest graphicCardRequest,@PathVariable Long id) throws WrongInputException {
        return graphicCardService.update(graphicCardRequest, id);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@RequestParam Long id) throws WrongInputException {
        graphicCardService.delete(id);
    }

    @PostMapping("/findOne")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GraphicCardResponse findOne(@RequestParam Long id)throws WrongInputException{
        return new GraphicCardResponse(graphicCardService.findOne(id));
    }
}
