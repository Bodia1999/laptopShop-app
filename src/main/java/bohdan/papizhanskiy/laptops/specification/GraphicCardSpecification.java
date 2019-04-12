//package bohdan.papizhanskiy.laptops.specification;
//
//import bohdan.papizhanskiy.laptops.dto.request.GraphicCardFilterRequest;
//import bohdan.papizhanskiy.laptops.entity.GraphicCard;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GraphicCardSpecification implements Specification<GraphicCard> {
//
//    private GraphicCardFilterRequest graphicCardFilterRequest;
//
//    public GraphicCardSpecification(GraphicCardFilterRequest graphicCardFilterRequest) {
//        this.graphicCardFilterRequest = graphicCardFilterRequest;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<GraphicCard> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        List<Predicate> predicates = new ArrayList<>();
//
//        Predicate byVolumeOfMemory = findByVolumeOfMemory(root, criteriaBuilder);
//        if (byVolumeOfMemory != null) predicates.add(byVolumeOfMemory);
//
//        Predicate byModelLike = findByModelLike(root, criteriaBuilder);
//        if (byModelLike!= null) predicates.add(byModelLike);
//
//        Predicate byNameLike = findByNameLike(root, criteriaBuilder);
//        if (byNameLike!= null) predicates.add(byNameLike);
//
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//
//    private Predicate findByNameLike(Root<GraphicCard> root, CriteriaBuilder criteriaBuilder) {
//        List<String> name = graphicCardFilterRequest.getName();
//        if (name == null || name.isEmpty()) {
//            return null;
//        }
//        return root.get("name").in(name.toArray());
//    }
//
//    private Predicate findByModelLike(Root<GraphicCard> root, CriteriaBuilder criteriaBuilder) {
//        List<String> model= graphicCardFilterRequest.getModel();
//        if (model == null || model.isEmpty()) {
//            return null;
//        }
//        return root.get("model").in( model .toArray());
//    }
//
//    private Predicate findByVolumeOfMemory(Root<GraphicCard> root, CriteriaBuilder criteriaBuilder) {
//        Integer volumeOfMemoryFrom = graphicCardFilterRequest.getVolumeOfMemoryFrom();
//        Integer volumeOfMemoryTo = graphicCardFilterRequest.getVolumeOfMemoryTo();
//
//        if (volumeOfMemoryFrom == null && volumeOfMemoryTo == null) {
//            return null;
//        }
//
//        if (volumeOfMemoryFrom == null) {
//            graphicCardFilterRequest.setVolumeOfMemoryFrom(0);
//        }
//
//        if (volumeOfMemoryTo == null) {
//            graphicCardFilterRequest.setVolumeOfMemoryTo(Integer.MAX_VALUE);
//        }
//
//        return criteriaBuilder.between(root.get("volumeOfMemory"), volumeOfMemoryFrom, volumeOfMemoryTo);
//    }
//
//
//}
