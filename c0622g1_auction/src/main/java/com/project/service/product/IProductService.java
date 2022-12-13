package com.project.service.product;

import com.project.dto.ProductSearchByRoleAdminDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findByListId(List<Integer> idList);

    void removeByListId(List<Integer> idList);

    Page<Product> getAll(Pageable pageable);

    Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);
}
