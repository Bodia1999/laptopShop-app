package bohdan.papizhanskiy.laptops.specification;

import bohdan.papizhanskiy.laptops.dto.request.LaptopFilterRequest;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.dto.response.GraphicCardResponse;
import bohdan.papizhanskiy.laptops.entity.GraphicCard;
import bohdan.papizhanskiy.laptops.entity.Laptop;
import bohdan.papizhanskiy.laptops.service.GraphicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LaptopSpecification implements Specification<Laptop> {

    @Autowired
    private GraphicCardSpecification graphicCardSpecification;

    @Autowired
    private GraphicCardService graphicCardService;



    private LaptopFilterRequest laptopFilterRequest;


    public LaptopSpecification(LaptopFilterRequest laptopFilterRequest) {
        this.laptopFilterRequest = laptopFilterRequest;
    }

    @Override
    public Predicate toPredicate(Root<Laptop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Predicate byModel = findByModel(root, criteriaBuilder);
        if (byModel != null) predicates.add(byModel);
        Predicate byPrice = findByPrice(root, criteriaBuilder);
        if (byPrice != null) predicates.add(byPrice);
//


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


    private Predicate findByPrice(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        Double priceFrom = laptopFilterRequest.getPriceFrom();
        Double priceTo = laptopFilterRequest.getPriceTo();

        if (priceFrom == null && priceTo == null) {
            return null;
        }

        if (priceFrom == null) {
            laptopFilterRequest.setPriceFrom(0d);
        }

        if (priceTo == null) {
            laptopFilterRequest.setPriceTo(Double.MAX_VALUE);
        }

        return criteriaBuilder.between(root.get("price"), priceFrom, priceTo);
    }

    private Predicate findByModel(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        String model = laptopFilterRequest.getModel();
        if (model == null || model.trim().isEmpty()) {
            return null;
        }

        return criteriaBuilder.like(root.get("model"), '%' + model + '%');
    }
}
