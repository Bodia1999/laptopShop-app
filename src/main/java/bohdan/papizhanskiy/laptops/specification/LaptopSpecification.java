package bohdan.papizhanskiy.laptops.specification;

import bohdan.papizhanskiy.laptops.dto.request.*;
import bohdan.papizhanskiy.laptops.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopSpecification implements Specification<Laptop> {


    private LaptopFilterRequest laptopFilterRequest;


    public LaptopSpecification(LaptopFilterRequest laptopFilterRequest) {
        this.laptopFilterRequest = laptopFilterRequest;
    }

    @Override
    public Predicate toPredicate(Root<Laptop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Predicate byMake = findByMake(root, criteriaBuilder);
        if (byMake != null) predicates.add(byMake);
        Predicate byModel = findByModel(root, criteriaBuilder);
        if (byModel != null) predicates.add(byModel);
        Predicate byPrice = findByPrice(root, criteriaBuilder);
        if (byPrice != null) predicates.add(byPrice);
        Predicate byRamName = findByRamName(root, criteriaBuilder);
        if (byRamName != null) {
            predicates.add(byRamName);
        }
        Predicate byRamVolumeOfMemory = findByRamVolumeOfMemory(root, criteriaBuilder);
        if (byRamVolumeOfMemory != null) predicates.add(byRamVolumeOfMemory);
        Predicate byWorkingFrequency = findByRamWorkingFrequency(root, criteriaBuilder);
        if (byWorkingFrequency != null) predicates.add(byWorkingFrequency);
        Predicate byGraphicCardNameLike = findByGraphicCardNameLike(root, criteriaBuilder);
        if (byGraphicCardNameLike != null) predicates.add(byGraphicCardNameLike);
        Predicate byGraphicCardModelLike = findByGraphicCardModelLike(root, criteriaBuilder);
        if (byGraphicCardModelLike != null) predicates.add(byGraphicCardModelLike);
        Predicate byGraphicCardVolumeOfMemory = findByGraphicCardVolumeOfMemory(root, criteriaBuilder);
        if (byGraphicCardVolumeOfMemory != null) predicates.add(byGraphicCardVolumeOfMemory);
        Predicate byCorpsWeight = findByCorpsWeight(root, criteriaBuilder);
        if (byCorpsWeight != null) predicates.add(byCorpsWeight);
        Predicate byMaterialOfCorps = findByMaterialOfCorps(root, criteriaBuilder);
        if (byMaterialOfCorps != null) predicates.add(byMaterialOfCorps);
        Predicate byColorOfCorps = findByColorOfCorps(root, criteriaBuilder);
        if (byColorOfCorps != null) predicates.add(byColorOfCorps);
        Predicate byMemoryName = findByMemoryName(root, criteriaBuilder);
        if (byMemoryName != null) predicates.add(byMemoryName);
        Predicate byMemoryTypeOfMemory = findByMemoryTypeOfMemory(root, criteriaBuilder);
        if (byMemoryTypeOfMemory != null) predicates.add(byMemoryTypeOfMemory);
        Predicate byMemoryVolume = findByMemoryVolume(root, criteriaBuilder);
        if (byMemoryVolume != null) predicates.add(byMemoryVolume);
        Predicate byProcessorName = findByProcessorName(root, criteriaBuilder);
        if (byProcessorName != null) predicates.add(byProcessorName);
        Predicate byProcessorModel = findByProcessorModel(root, criteriaBuilder);
        if (byProcessorModel != null) predicates.add(byProcessorModel);
        Predicate byProcessorQuantityOfCores = findByProcessorQuantityOfCores(root, criteriaBuilder);
        if (byProcessorQuantityOfCores != null) predicates.add(byProcessorQuantityOfCores);
        Predicate byProcessorWorkingFrequency = findByProcessorWorkingFrequency(root, criteriaBuilder);
        if (byProcessorWorkingFrequency != null) predicates.add(byProcessorWorkingFrequency);
        Predicate byScreenResolution = findByScreenResolution(root, criteriaBuilder);
        if (byScreenResolution != null) predicates.add(byScreenResolution);
        Predicate byScreenSize = findByScreenSize(root, criteriaBuilder);
        if (byScreenSize != null) predicates.add(byScreenSize);
        Predicate byTypeOfScreen = findByTypeOfScreen(root, criteriaBuilder);
        if (byTypeOfScreen != null) predicates.add(byTypeOfScreen);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private Predicate findByMake(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        MakeFilterRequest filter = laptopFilterRequest.getMakeFilterRequest();
//        MakeFilterRequest filter = laptopFilterRequest.getMakeFilterRequest();
        if (filter == null) return null;
        String makeName = filter.getName();
        if (makeName == null || makeName.isEmpty()) {
            return null;
        }
        Join<Laptop, Make> makeJoin = root.join("make");
//        return makeJoin.get("name").in(makeName.toArray());
        return criteriaBuilder.like(makeJoin.get("name"), '%' + makeName + '%');
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
        String filter = laptopFilterRequest.getModel();

        if (filter == null || filter.trim().isEmpty()) {
            return null;
        }

        return criteriaBuilder.like(root.get("model"), '%' + filter + '%');
    }


    private Predicate findByRamName(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        RamFilterRequest filter = laptopFilterRequest.getRamFilterRequest();
        if (filter == null) return null;
        String name = filter.getName();
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        Join<Laptop, Ram> ramJoin = root.join("ram");
        return criteriaBuilder.like(ramJoin.get("name"), '%' + name + '%');

    }

    //
    private Predicate findByRamVolumeOfMemory(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        RamFilterRequest filter = laptopFilterRequest.getRamFilterRequest();
        if (filter == null) return null;
        Integer volumeOfMemoryFrom = filter.getVolumeOfMemoryFrom();
        Integer volumeOfMemoryTo = filter.getVolumeOfMemoryTo();
        if (volumeOfMemoryFrom == null && volumeOfMemoryTo == null) {
            return null;
        }
        if (volumeOfMemoryFrom == null) {
            laptopFilterRequest.getRamFilterRequest().setVolumeOfMemoryFrom(0);
        }
        if (volumeOfMemoryTo == null) {
            laptopFilterRequest.getRamFilterRequest().setVolumeOfMemoryTo(Integer.MAX_VALUE);
        }
        Join<Laptop, Ram> ramJoin = root.join("ram");
        return criteriaBuilder.between(ramJoin.get("volumeOfMemory"), laptopFilterRequest.getRamFilterRequest().getVolumeOfMemoryFrom(), laptopFilterRequest.getRamFilterRequest().getVolumeOfMemoryTo());
    }

    //
    private Predicate findByProcessorQuantityOfCores(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ProcessorFilterRequest filter = laptopFilterRequest.getProcessorFilterRequest();
        if (filter == null) return null;
        Integer quantityOfCoresFrom = filter.getQuantityOfCoresFrom();
        Integer quantityOfCoresTo = filter.getQuantityOfCoresTo();
        if (quantityOfCoresFrom == null && quantityOfCoresTo == null) {
            return null;
        }

        if (quantityOfCoresFrom == null) {
            laptopFilterRequest.getProcessorFilterRequest().setWorkingFrequencyFrom(0);
        }
        if (quantityOfCoresTo == null) {
            laptopFilterRequest.getProcessorFilterRequest().setWorkingFrequencyTo(Integer.MAX_VALUE);
        }
        Join<Laptop, Processor> processorJoin = root.join("processor");
        return criteriaBuilder.between(processorJoin.get("quantityOfCores"), laptopFilterRequest.getProcessorFilterRequest().getQuantityOfCoresFrom(), laptopFilterRequest.getProcessorFilterRequest().getQuantityOfCoresTo());
    }

    private Predicate findByRamWorkingFrequency(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        RamFilterRequest filter = laptopFilterRequest.getRamFilterRequest();
        if (filter == null) return null;
        Integer workingFrequencyFrom = filter.getWorkingFrequencyFrom();
        Integer workingFrequencyTo = filter.getWorkingFrequencyTo();
        if (workingFrequencyFrom == null && workingFrequencyTo == null) {
            return null;
        }
        if (workingFrequencyFrom == null) {
            laptopFilterRequest.getRamFilterRequest().setWorkingFrequencyFrom(0);
        }
        if (workingFrequencyTo == null) {
            laptopFilterRequest.getRamFilterRequest().setWorkingFrequencyTo(Integer.MAX_VALUE);
        }
        Join<Laptop, Ram> ramJoin = root.join("ram");
        return criteriaBuilder.between(ramJoin.get("workingFrequency"), laptopFilterRequest.getRamFilterRequest().getVolumeOfMemoryFrom(), laptopFilterRequest.getRamFilterRequest().getWorkingFrequencyTo());
    }
    //
//

    private Predicate findByGraphicCardNameLike(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        GraphicCardFilterRequest filter = laptopFilterRequest.getGraphicCardFilterRequest();
        if (filter == null) return null;
        List<String> name = filter.getName();
        if (name == null || name.isEmpty()) {
            return null;
        }
        Join<Laptop, GraphicCard> graphicCardJoin = root.join("graphicCard");
        return graphicCardJoin.get("name").in(name.toArray());
    }

    private Predicate findByGraphicCardModelLike(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        GraphicCardFilterRequest filter = laptopFilterRequest.getGraphicCardFilterRequest();
        if (filter == null) return null;
        List<String> model = filter.getModel();
        if (model == null || model.isEmpty()) {
            return null;
        }
        Join<Laptop, GraphicCard> graphicCardJoin = root.join("graphicCard");
        return graphicCardJoin.get("model").in(model.toArray());
    }

    private Predicate findByGraphicCardVolumeOfMemory(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        GraphicCardFilterRequest filter = laptopFilterRequest.getGraphicCardFilterRequest();
        if (filter == null) return null;
        Integer volumeOfMemoryFrom = filter.getVolumeOfMemoryFrom();
        Integer volumeOfMemoryTo = filter.getVolumeOfMemoryTo();

        if (volumeOfMemoryFrom == null && volumeOfMemoryTo == null) {
            return null;
        }

        if (volumeOfMemoryFrom == null) {
            laptopFilterRequest.getGraphicCardFilterRequest().setVolumeOfMemoryFrom(0);
        }

        if (volumeOfMemoryTo == null) {
            laptopFilterRequest.getGraphicCardFilterRequest().setVolumeOfMemoryTo(Integer.MAX_VALUE);
        }

        Join<Laptop, GraphicCard> graphicCardJoin = root.join("graphicCard");
        return criteriaBuilder.between(graphicCardJoin.get("volumeOfMemory"), volumeOfMemoryFrom, volumeOfMemoryTo);
    }


    private Predicate findByCorpsWeight(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        CorpsFilterRequest filter = laptopFilterRequest.getCorpsFilterRequest();
        if (filter == null) return null;
        Double weightFrom = filter.getWeightFrom();
        Double weightTo = filter.getWeightTo();
        if (weightFrom == null && weightTo == null) {
            return null;
        }
        if (weightFrom == null) {
            laptopFilterRequest.getCorpsFilterRequest().setWeightFrom(0.0);
        }
        if (weightTo == null) {
            laptopFilterRequest.getCorpsFilterRequest().setWeightTo(Double.MAX_VALUE);
        }

        Join<Laptop, Corps> corpsJoin = root.join("corps");
        return criteriaBuilder.between(corpsJoin.get("weight"), weightFrom, weightTo);
    }

    private Predicate findByColorOfCorps(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        CorpsFilterRequest filter = laptopFilterRequest.getCorpsFilterRequest();
        if (filter == null) return null;
        String colorOfCorps = filter.getColorOfCorps();
        if (colorOfCorps == null || colorOfCorps.trim().isEmpty()) {
            return null;
        }
        Join<Laptop, Corps> corpsJoin = root.join("corps");
        return criteriaBuilder.like(corpsJoin.get("colorOfCorps"), colorOfCorps);
    }

    private Predicate findByMaterialOfCorps(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        CorpsFilterRequest filter = laptopFilterRequest.getCorpsFilterRequest();
        if (filter == null) return null;
        List<String> materialOfCorps = filter.getMaterialOfCorps();
        if (materialOfCorps == null || materialOfCorps.isEmpty()) {
            return null;
        }

        Join<Laptop, Corps> corpsJoin = root.join("corps");
        return corpsJoin.get("materialOfCorps").in(materialOfCorps.toArray());
    }


    private Predicate findByMemoryName(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        MemoryFilterRequest filter = laptopFilterRequest.getMemoryFilterRequest();
        if (filter == null) return null;
        String memoryName = filter.getName();
        if (memoryName == null || memoryName.trim().isEmpty()) {
            return null;
        }
        Join<Laptop, Memory> memoryJoin = root.join("memory");
        return criteriaBuilder.like(memoryJoin.get("name"), '%' + memoryName + '%');
    }

    private Predicate findByMemoryVolume(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        MemoryFilterRequest filter = laptopFilterRequest.getMemoryFilterRequest();
        if (filter == null) return null;
        Integer volumeOfMemoryFrom = filter.getVolumeOfMemoryFrom();
        Integer volumeOfMemoryTo = filter.getVolumeOfMemoryTo();
        if (volumeOfMemoryFrom == null && volumeOfMemoryTo == null) {
            return null;
        }

        if (volumeOfMemoryFrom == null) {
            laptopFilterRequest.getMemoryFilterRequest().setVolumeOfMemoryFrom(0);
        }
        if (volumeOfMemoryTo == null) {
            laptopFilterRequest.getMemoryFilterRequest().setVolumeOfMemoryTo(Integer.MAX_VALUE);
        }
        Join<Laptop, Memory> memoryJoin = root.join("memory");
        return criteriaBuilder.between(memoryJoin.get("volumeOfMemory"), volumeOfMemoryFrom, volumeOfMemoryTo);
    }

    private Predicate findByMemoryTypeOfMemory(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        MemoryFilterRequest filter = laptopFilterRequest.getMemoryFilterRequest();
        if (filter == null) return null;
        List<String> typeOfMemory = filter.getTypeOfMemory();
        if (typeOfMemory == null || typeOfMemory.isEmpty()) {
            return null;
        }
        Join<Laptop, Memory> memoryJoin = root.join("memory");
        return memoryJoin.get("typeOfMemory").in(typeOfMemory.toArray());
    }


    private Predicate findByProcessorName(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ProcessorFilterRequest filter = laptopFilterRequest.getProcessorFilterRequest();
        if (filter == null) return null;
        List<String> processor = filter.getName();
        if (processor == null || processor.isEmpty()) {
            return null;
        }
        Join<Laptop, Processor> processorJoin = root.join("processor");
        return processorJoin.get("name").in(processor.toArray());
    }

    private Predicate findByProcessorModel(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ProcessorFilterRequest filter = laptopFilterRequest.getProcessorFilterRequest();
        if (filter == null) return null;
        String model = filter.getModel();
        if (model == null || model.trim().isEmpty()) {
            return null;
        }
        Join<Laptop, Processor> processorJoin = root.join("processor");
        return criteriaBuilder.like(processorJoin.get("model"), model);
    }

    private Predicate findByProcessorWorkingFrequency(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ProcessorFilterRequest filter = laptopFilterRequest.getProcessorFilterRequest();
        if (filter == null) return null;
        Integer workingFrequencyFrom = filter.getWorkingFrequencyFrom();
        Integer workingFrequencyTo = filter.getWorkingFrequencyTo();
        if (workingFrequencyFrom == null && workingFrequencyTo == null) {
            return null;
        }

        if (workingFrequencyFrom == null) {
            laptopFilterRequest.getProcessorFilterRequest().setWorkingFrequencyFrom(0);
        }
        if (workingFrequencyTo == null) {
            laptopFilterRequest.getProcessorFilterRequest().setWorkingFrequencyTo(Integer.MAX_VALUE);
        }
        Join<Laptop, Processor> processorJoin = root.join("processor");
        return criteriaBuilder.between(processorJoin.get("workingFrequency"), workingFrequencyFrom, workingFrequencyTo);
    }


    private Predicate findByTypeOfScreen(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ScreenFilterRequest filter = laptopFilterRequest.getScreenFilterRequest();
        if (filter == null) return null;
        List<String> type = filter.getType();
        if (type == null || type.isEmpty()) {
            return null;
        }
        Join<Laptop, Screen> screenJoin = root.join("screen");
        return screenJoin.get("type").in( type.toArray());
    }

    private Predicate findByScreenSize(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ScreenFilterRequest filter = laptopFilterRequest.getScreenFilterRequest();
        if (filter==null)return null;

        List<String> size = filter.getSize();
        if (size == null || size.isEmpty()) {
            return null;
        }
        Join<Laptop, Screen> screenJoin = root.join("screen");
        return screenJoin.get("size").in(size.toArray());
    }


    private Predicate findByScreenResolution(Root<Laptop> root, CriteriaBuilder criteriaBuilder) {
        ScreenFilterRequest filter = laptopFilterRequest.getScreenFilterRequest();
        if (filter == null) return null;
        List<String> resolution = filter.getResolution();

        if (resolution == null || resolution.isEmpty()) {
            return null;
        }
        Join<Laptop, Screen> screenJoin = root.join("screen");
        return screenJoin.get("size").in(resolution.toArray());
    }


}
