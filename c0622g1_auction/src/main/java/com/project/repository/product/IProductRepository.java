package com.project.repository.product;

import com.project.controller.dto.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return
     */
    @Query(value = "select product.id, product.name, product.initial_price, product.start_time, product.end_time, product.delete_status\n" +
            "from product\n" +
            "where DATE (product.end_time) > NOW()\n" +
            "    AND product.delete_status = 0\n" +
            "    AND product.category_id like %#{#productSearchDto.categoryID}%\n" +
            "    AND product.name like %:#{#productSearchDto.name}%\n" +
            "    AND (product.initial_price > :#{#productSearchDto.rangePrice} OR product.initial_price = :#{#productSearchDto.rangePrice})",
            nativeQuery = true)
    Page<Product> getAllAndSearch(@Param("productSearchDto") ProductSearchDto productSearchDto, Pageable pageable);
}
