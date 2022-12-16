package com.project.repository.product;

import com.project.dto.product.ProductSearchDto;
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
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * order DESC start day
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    @Query(value = "SELECT * " +
            "FROM product " +
            "WHERE product.review_status_id = 2 " +
            "    AND product.delete_status = 0 " +
            "    AND product.category_id like %:#{#productSearchDto.categoryID}%" +
            "    AND product.auction_status_id like %:#{#productSearchDto.productAuctionStatus}%" +
            "    AND product.name like %:#{#productSearchDto.name}%" +
            "    AND (product.initial_price > :#{#productSearchDto.rangePrice} " +
            "         OR product.initial_price = :#{#productSearchDto.rangePrice}) " +
            "ORDER BY product.start_time DESC" ,
            nativeQuery = true)
    Page<Product> getAllAndSearch(@Param("productSearchDto") ProductSearchDto productSearchDto, Pageable pageable);

}
