package gr.aueb.cf.schoolapp.core.filters;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import java.util.List;

@Getter
@Setter
public class Paginated<T> {

    private List<T> data;
    private long totalElements;
    private int totalPages;
    private int numberOfElements;
    private int currentPage;
    private int pageSize;

    public Paginated(Page<T> page) {
        this.data = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.numberOfElements = page.getNumberOfElements();
        this.currentPage = page.getNumber();
        this.pageSize = page.getSize();
    }
}
