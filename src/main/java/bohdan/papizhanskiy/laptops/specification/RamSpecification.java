package bohdan.papizhanskiy.laptops.specification;

import bohdan.papizhanskiy.laptops.dto.request.RamFilterRequest;
import bohdan.papizhanskiy.laptops.entity.Ram;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RamSpecification implements Specification<Ram> {
    private RamFilterRequest ramFilterRequest;

    public RamSpecification(RamFilterRequest ramFilterRequest) {
        this.ramFilterRequest = ramFilterRequest;
    }

    @Override
    public Predicate toPredicate(Root<Ram> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    private Predicate findByName(Root<Ram> root, CriteriaBuilder criteriaBuilder) {
        String name = ramFilterRequest.getName();
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        return criteriaBuilder.like(root.get("name"), name);
    }

    private Predicate findByVolumeOfMemory(Root<Ram> root, CriteriaBuilder criteriaBuilder) {
        Integer volumeOfMemoryFrom = ramFilterRequest.getVolumeOfMemoryFrom();
        Integer volumeOfMemoryTo = ramFilterRequest.getVolumeOfMemoryTo();
        if (volumeOfMemoryFrom == null && volumeOfMemoryTo == null) {
            return null;
        }
        if (volumeOfMemoryFrom == null){
            ramFilterRequest.setVolumeOfMemoryFrom(0);
        }
        if (volumeOfMemoryTo == null){
            ramFilterRequest.setVolumeOfMemoryTo(Integer.MAX_VALUE);
        }
        return criteriaBuilder.between(root.get("volumeOfMemory"), volumeOfMemoryFrom,volumeOfMemoryTo);
    }
}
