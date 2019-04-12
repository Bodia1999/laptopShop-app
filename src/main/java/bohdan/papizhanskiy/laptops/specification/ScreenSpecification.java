//package bohdan.papizhanskiy.laptops.specification;
//
//import bohdan.papizhanskiy.laptops.dto.request.ScreenFilterRequest;
//import bohdan.papizhanskiy.laptops.entity.Screen;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ScreenSpecification implements Specification<Screen> {
//    private ScreenFilterRequest screenFilterRequest;
//
//    public ScreenSpecification(ScreenFilterRequest screenFilterRequest) {
//        this.screenFilterRequest = screenFilterRequest;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<Screen> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        List<Predicate> predicates = new ArrayList<>();
//        Predicate byResolution = findByResolution(root, criteriaBuilder);
//        if (byResolution != null) predicates.add(byResolution);
//        Predicate bySize = findBySize(root, criteriaBuilder);
//        if (bySize != null) predicates.add(bySize);
//        Predicate byTypeOfScreen = findByTypeOfScreen(root, criteriaBuilder);
//        if (byTypeOfScreen != null) predicates.add(byTypeOfScreen);
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//
//    private Predicate findByTypeOfScreen(Root<Screen> root, CriteriaBuilder criteriaBuilder) {
//        List<String> type = screenFilterRequest.getType();
//        if (type == null || type.isEmpty()) {
//            return null;
//        }
//
//        return root.get("type").in(type.toArray());
//    }
//
//    private Predicate findBySize(Root<Screen> root, CriteriaBuilder criteriaBuilder) {
//        List<String> size = screenFilterRequest.getSize();
//        if (size == null || size.isEmpty()) {
//            return null;
//        }
//
//        return root.get("size").in(size.toArray());
//    }
//
//
//    private Predicate findByResolution(Root<Screen> root, CriteriaBuilder criteriaBuilder) {
//        List<String> resolution = screenFilterRequest.getResolution();
//
//        if (resolution == null || resolution.isEmpty()) {
//            return null;
//        }
//
//        return root.get("size").in(resolution.toArray());
//    }
//
//}
