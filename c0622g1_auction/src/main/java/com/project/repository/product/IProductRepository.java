package com.project.repository.product;


import com.project.model.product.ImgUrlProduct;
import com.project.dto.ProductSearchByRoleAdminDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.project.dto.ProductDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;

import java.util.Optional;


import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param user id
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    @Query(value = "select product.`name` as nameProduct, product.description as description, " +
            "product.register_day as registerDay , review_status.`name` as review , product.delete_status as isDelete " +
            "from product " +
            "join user on product.user_id = user.id " +
            "join review_status on review_status.id = product.review_status_id " +
            "where product.user_id = :id ",
            countQuery = "count (*)from product " +
                    "join user on product.user_id = user.id " +
                    "join review_status on review_status.id = product.review_status_id " +
                    "where product.user_id = :id  ", nativeQuery = true)
    Page<ProductDto> showProductById(@Param("id") Integer id, Pageable pageable);


    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: cancel Sign up for auctions by user id
     * @param user id
     * @return voice
     */
    @Modifying
    @Transactional
    @Query(value = " UPDATE  product set delete_status = 1 where product.id = :id ", nativeQuery = true)
    void cancelProduct(@Param("id") Integer id);
     * Created by: SonPT
     * Date created: 13-12-2022
     * @param: description, end_time, initial_price, name, register_day, start_time, category_id, price_step_id, user_id
     * Function: create Product
     */
    @Modifying
    @Query(value = "INSERT INTO product " +
            "(`description`, `end_time`, `initial_price`, `name`, `start_time`, `category_id`, `price_step_id`, `user_id`) VALUES " +
            "( :description, :end_time, :initial_price, :name, :start_time, :category_id, :price_step_id, :user_id);",
            nativeQuery = true)
    void createProduct(@Param("description") String description, @Param("end_time") String endTime,
                          @Param("initial_price") Double initialPrice, @Param("name") String name,
                          @Param("start_time") String startTime, @Param("category_id") Integer categoryId,
                          @Param("price_step_id") Integer priceStepId, @Param("user_id") Integer user_id);
     /** Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */
    @Query(value = "select p.*"+
            "from product p\n" +
            "where p.id=:productId and p.delete_status = 0 and p.auction_status_id = 2", nativeQuery = true)
    Optional<Product> findProductById(@Param("productId") Integer productId);
    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to get products in page
     *
     * @param pageable
     * @return product page
     */
    @Query(value = "select * from product where delete_status = 0 ", nativeQuery = true)
    Page<Product> getAll(Pageable pageable);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete product by List ids
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update product set delete_status = 1 where id in :idList", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by List ids
     *
     * @param idList
     * @return product list
     */
    @Modifying
    @Query(value = "select * from product where id in :idList and delete_status = 0", nativeQuery = true)
    List<Product> findByListId(@Param("idList") List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     */
    @Modifying
    @Query(value = "update product set review_status_id = 2 where id = :id ", nativeQuery = true)
    void reviewProduct(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     *
     * @param id
     */
    @Modifying
    @Query(value = "update product set review_status_id = 3 where id = :id ", nativeQuery = true)
    void doNotReviewProduct(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to search product by product name and category and seller name
     * and product initial price and auction status
     *
     * @param productSearchByRoleAdminDto
     * @param pageable
     * @return product page
     */
    @Query(value = "select pt.* from product pt \n" +
            "join category cy on pt.category_id = cy.id \n" +
            "join user ur on pt.user_id = ur.id \n" +
            "join auction_status aus on pt.auction_status_id = aus.id \n" +
            "where pt.delete_status = 0 \n" +
            "and pt.name like %:#{#productSearchByRoleAdminDto.productName}% \n" +
            "and cy.name like %:#{#productSearchByRoleAdminDto.categoryName}% \n" +
            "and (ur.first_name like %:#{#productSearchByRoleAdminDto.sellerName}% \n" +
            "   or ur.last_name like %:#{#productSearchByRoleAdminDto.sellerName}% \n" +
            "   or %:#{#productSearchByRoleAdminDto.sellerName}% like ur.first_name \n" +
            "   or %:#{#productSearchByRoleAdminDto.sellerName}% like  ur.last_name) \n" +
            "and (pt.initial_price >= %:#{#productSearchByRoleAdminDto.minPrice}% \n" +
            "    and pt.initial_price <= %:#{#productSearchByRoleAdminDto.maxPrice}%) \n" +
            "and aus.name like %:#{#productSearchByRoleAdminDto.auctionStatusName}% ",
            nativeQuery = true)
    Page<Product> searchByRoleAdmin(@Param("productSearchByRoleAdminDto") ProductSearchByRoleAdminDto productSearchByRoleAdminDto,
                                    Pageable pageable);


    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return Optional product
     */
    @Query(value = "select * from product where id = :id and delete_status = 0", nativeQuery = true)
    Optional<Product> findById(@Param("id") Integer id);


    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * order DESC start day
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    @Query(value = "SELECT " +
            "id, " +
            "name, " +
            "delete_status, " +
            "description, " +
            "end_time, " +
            "start_time, " +
            "register_day, " +
            "initial_price, " +
            "auction_status_id, " +
            "category_id, " +
            "price_step_id, " +
            "review_status_id, " +
            "user_id " +
            "FROM product " +
            "WHERE product.review_status_id = 2 " +
            "    AND product.delete_status = 0 " +
            "    AND product.category_id like %:#{#productSearchDto.categoryID}%" +
            "    AND product.auction_status_id like %:#{#productSearchDto.productAuctionStatus}%" +
            "    AND product.name like %:#{#productSearchDto.name}%" +
            "    AND (product.initial_price > :#{#productSearchDto.rangePrice} " +
            "         OR product.initial_price = :#{#productSearchDto.rangePrice}) " +
            "ORDER BY product.start_time DESC",
            nativeQuery = true)
    Page<Product> getAllAndSearch(@Param("productSearchDto") ProductSearchDto productSearchDto, Pageable pageable);

}
