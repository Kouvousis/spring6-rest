package gr.aueb.cf.schoolapp.core.filters;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public abstract class GenericFilters {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final String DEFAULT_SORT_COLUMN = "id";
    private static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;

    private int page;
    private int pageSize;
    private Sort.Direction sortDirection;
    private String sortBy;

    public int getPageSize() {
        return pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getPage() {
        return Math.max(page, 0);
    }

    public Sort.Direction getSortDirection() {
        return this.sortDirection == null ? DEFAULT_SORT_DIRECTION : this.sortDirection;
    }

    public String getSortBy() {
        return (this.sortBy == null || StringUtils.isBlank(this.sortBy)) ? DEFAULT_SORT_COLUMN : this.sortBy;
    }

    public Pageable getPageable() {
        return PageRequest.of(getPage(), getPageSize(), getSort());
    }

    public Sort getSort() {
        return Sort.by(this.getSortDirection(), this.getSortBy());
    }
}
