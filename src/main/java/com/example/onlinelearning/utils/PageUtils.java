package com.example.onlinelearning.utils;

import org.springframework.data.domain.*;

import java.util.List;

public class PageUtils {
    /* Trả về yêu cầu phản hồi trang với vị trí trang, kích thước trang, thuộc tính sắp xếp
    String sort, String sortColumn: -> sắp xếp tăng dần hay giảm dần cột nào đó  */ 
    public static Pageable createPageable(int page, int size, String sort, String sortColumn) {        
        Sort sortable = Sort.by(sortColumn).descending();
        if (sort.trim().equalsIgnoreCase("asc"))
            sortable = Sort.by(sortColumn).ascending();
        return PageRequest.of(page, size, sortable);
    }

    /* */
    public static <T> Page<T> convertListToPage(List<T> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }
}
