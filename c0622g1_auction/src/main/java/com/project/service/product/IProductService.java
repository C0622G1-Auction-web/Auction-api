package com.project.service.product;


import com.project.dto.product.*;
import com.project.model.product.Product;
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
    Optional<ProductDtoAdminList> findDtoById(Integer id);

    Optional<Product> findByProductId(Integer id);

    void saveProduct(ProductDto productDTO);

    void update(ProductDto productDTO);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find products list by List ids
     *
     * @param idList
     * @return product list
     */
    List<ProductDeleteDto> findByListId(List<Integer> idList);

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
     * <p>
     */

    Page<ProductDtoAdminList> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */
    void saveProduct(Product product);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */
    Optional<Product> findProductById(Integer productId);

    void update(Product product);

    Page<Product> getAll(Pageable pageable);

    void review(Integer id);

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

    /**
     * Created HungNV
     * Date created 13/12/2022
     * Function: get product by id
     *
     * @param id
     * @return product
     */
    Product getProduct(Integer id);

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     *
     * @param "user    id"
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    Page<IProductDto> showProductById(Integer id, Pageable pageable);

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function:cancel Sign up for auctions by user id
     *
     * @param "user id"
     * @return voi
     */

    void cancelProduct(Integer id);

}
