package StudentRegistration.App.Section;

import org.springframework.beans.factory.annotation.Autowired;

public class SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }
}
