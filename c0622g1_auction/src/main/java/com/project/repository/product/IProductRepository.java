package com.project.repository.product;


import com.project.dto.product.*;
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
import java.util.Optional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Create by: HungNV
     * Date created: 14/12/2022
     * Function: create new product
     *
     * @param name, initialPrice,  id,  category,  description,  stepPrice,  startTime,  endTime, registerDay
     * @return Optional<Product>
     */
    @Modifying
    @Query(value = "insert into product (name,initial_price,user_id,category_id, description, price_step_id,start_time, end_time, register_day, auction_status_id, review_status_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,1,1)", nativeQuery = true)
    void saveProduct(String name, Double initialPrice, Integer user, Integer category, String description, Integer stepPrice, String startTime, String endTime, String registerDay);


    /**
     * Create by: HungNV
     * Date created: 16/12/2022
     * Function: get last id
     *
     * @return Optional<Product>
     */
    @Query(value = "select last_insert_id()", nativeQuery = true)
    Integer getLastId();

    /**
     * Create by: HungNV
     * Date created: 14/12/2022
     * Function: update product
     *
     * @param name, initialPrice,  id,  category,  description,  stepPrice,  startTime,  endTime, registerDay, productId
     * @return Optional<Product>
     */
    @Modifying
    @Query(value = "update product set name = ?1,initial_price =?2,user_id=?3,category_id=?4, description=?5, price_step_id=?6,start_time=?7, end_time=?8, register_day=?9 where id=?10 ", nativeQuery = true)
    void updateProduct(String name, Double initialPrice, Integer id, Integer category, String description, Integer stepPrice, String startTime, String endTime, String registerDay, int productId);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     *
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


    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */
    @Query(value = "select p.id,p.delete_status,p.description,p.end_time,p.initial_price,p.name,p.register_day,p.start_time,p.auction_status_id,p.category_id,p.price_step_id,p.review_status_id,p.user_id "+
            "from product p\n " +
            "where p.id = :productId and p.delete_status = 0 and p.auction_status_id < 4", nativeQuery = true)

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
    @Query(value = "select id, name from product where id in :idList and delete_status = 0", nativeQuery = true)
    List<ProductDeleteDto> findByListId(@Param("idList") List<Integer> idList);

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
    @Query(value = "select " +
            "pt.id as id, " +
            "pt.delete_status as deleteStatus, " +
            "pt.description , " +
            "pt.end_time as endTime, " +
            "pt.initial_price as initialPrice, " +
            "pt.name, " +
            "pt.register_day as registerDay, " +
            "pt.start_time as startTime, " +
            "aus.name as auctionStatus, " +
            "cy.name as category, " +
            "pp.step as priceStep," +
            "rs.id as reviewStatusId, " +
            "rs.name as reviewStatus, " +
            "ur.id as userId , " +
            "ur.email as userEmail , " +
            "concat(ur.first_name,' ',ur.last_name) as userName " +
            "from `product` pt " +
            "join `category` cy on pt.category_id = cy.id " +
            "join `user` ur on pt.user_id = ur.id " +
            "join `auction_status` aus on pt.auction_status_id = aus.id " +
            "join `price_step` pp on pt.price_step_id = pp.id " +
            "join `review_status` rs on pt.review_status_id = rs.id " +
            "where pt.delete_status = 0 " +
            "and pt.name like %:#{#productSearchByRoleAdminDto.productName}% " +
            "and cy.name like %:#{#productSearchByRoleAdminDto.categoryName}% " +
            "and (concat(ur.first_name,' ',ur.last_name) like %:#{#productSearchByRoleAdminDto.sellerName}%) " +
            "and (pt.initial_price >= :#{#productSearchByRoleAdminDto.minPrice} " +
            "and pt.initial_price <= :#{#productSearchByRoleAdminDto.maxPrice}) " +
            "and aus.name like %:#{#productSearchByRoleAdminDto.auctionStatusName}% "
            , nativeQuery = true)
    Page<ProductDtoAdminList> searchByRoleAdmin(@Param("productSearchByRoleAdminDto") ProductSearchByRoleAdminDto productSearchByRoleAdminDto,
                                                Pageable pageable);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return Optional product
     */
    @Query(value = "select " +
            "pt.id as id, " +
            "pt.delete_status as deleteStatus, " +
            "pt.description , " +
            "pt.end_time as endTime, " +
            "pt.initial_price as initialPrice, " +
            "pt.name, " +
            "pt.register_day as registerDay, " +
            "pt.start_time as startTime, " +
            "aus.name as auctionStatus, " +
            "cy.name as category, " +
            "pp.step as priceStep," +
            "rs.id as reviewStatusId, " +
            "rs.name as reviewStatus, " +
            "ur.id as userId , " +
            "ur.email as userEmail , " +
            "concat(ur.first_name,' ',ur.last_name) as userName " +
            "from `product` pt " +
            "join `category` cy on pt.category_id = cy.id " +
            "join `user` ur on pt.user_id = ur.id " +
            "join `auction_status` aus on pt.auction_status_id = aus.id " +
            "join `price_step` pp on pt.price_step_id = pp.id " +
            "join `review_status` rs on pt.review_status_id = rs.id " +
            "where pt.delete_status = 0 " +
            "and pt.id = :id "
            , nativeQuery = true)
    Optional<ProductDtoAdminList> findDtoById(@Param("id") Integer id);


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
    @Query(value = "SELECT * " +
            "FROM product " +
            "WHERE product.review_status_id = 2 " +
            "    AND product.delete_status = 0 " +
            "    AND product.auction_status_id < 4 " +
            "    AND product.category_id like %:#{#productSearchDto.categoryID}%" +
            "    AND product.auction_status_id like %:#{#productSearchDto.productAuctionStatus}%" +
            "    AND product.name like %:#{#productSearchDto.name}%" +
            "    AND (product.initial_price < :#{#productSearchDto.rangePrice} " +
            "         OR product.initial_price = :#{#productSearchDto.rangePrice}) " +
            "ORDER BY product.start_time DESC",
            nativeQuery = true)
    Page<Product> getAllAndSearch(@Param("productSearchDto") ProductSearchDto productSearchDto, Pageable pageable);

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param 'user id'
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    @Query(value = "select user.id as user , product.id as id ,product.`name` as name, product.description as description, " +
            "product.register_day as registerDay , review_status.`name` as reviewStatus , product.delete_status as isDelete, product.auction_status_id as auctionStatus  " +
            "from `product` " +
            "join `user` on product.user_id = user.id " +
            "join `review_status` on review_status.id = product.review_status_id " +
            "join `auction_status` on product.auction_status_id = auction_status.id " +
            "where product.user_id = :id ",
            countQuery = " select count(*) from `product`",nativeQuery = true)
    Page<IProductDto> showProductById(@Param("id") Integer id, Pageable pageable);

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: cancel Sign up for auctions by user id
     * @param 'user id'
     * @return voice
     */
    @Modifying
    @Transactional
    @Query(value = " UPDATE  product set delete_status = 1 where product.id = :id ", nativeQuery = true)
    void cancelProduct(@Param("id") Integer id);
}
