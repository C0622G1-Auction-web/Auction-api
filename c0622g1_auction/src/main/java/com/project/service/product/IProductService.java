package com.project.service.product;

import com.project.dto.product.ProductSearchByRoleAdminDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;
import com.project.model.product.dto.ProductDtoAdminList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return Optional product
     */
    Optional<Product> findById(Integer id);

    void saveProduct(ProductDTO ProductDTO);

    void update(ProductDTO ProductDTO);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find products list by List ids
     *
     * @param idList
     * @return product list
     */
    List<Product> findByListId(List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete products list by List ids
     *
     * @param idList
     */
    void removeByListId(List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to get products in page
     *
     * @param pageable
     * @return product page
     */
    Page<Product> getAll(Pageable pageable);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to search products by product name and category and seller name
     * and product initial price and auction status
     *
     * @param productSearchByRoleAdminDto
     * @param pageable
     * @return product page
     */
    Page<ProductDtoAdminList> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     */
    void review(Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     *
     * @param id
     */
    void doNotReview(Integer id);

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable);
}
