package com.project.service.product.impl;

import com.project.dto.ProductSearchByRoleAdminDto;
import com.project.dto.product.IProductDto;
import com.project.dto.product.ProductDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param 'user id'
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Page<IProductDto> showProductById(Integer id, Pageable pageable) {
        return productRepository.showProductById(id, pageable);
    }

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param 'user id'
     * @return void
     */

    @Override
    public void cancelProduct(Integer id) {
        productRepository.cancelProduct(id);
    }



    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */

    @Override
    public void saveProduct(Product product) {
        productRepository.createProduct(product.getDescription(), product.getEndTime(), product.getInitialPrice(), product.getName(), product.getStartTime(), product.getCategory().getId(), product.getPriceStep().getId(), product.getUser().getId());

    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @Override
    public Optional<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }
    @Override
    public List<Product> findByListId(List<Integer> idList) {
        return productRepository.findByListId(idList);
    }

    @Override
    public void removeByListId(List<Integer> idList) {
        productRepository.removeByListId(idList);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.getAll(pageable);
    }

    @Override
    public Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable) {
        return productRepository.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void review(Integer id) {
        productRepository.reviewProduct(id);
    }

    @Override
    public void doNotReview(Integer id) {
        productRepository.doNotReviewProduct(id);
    }

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */


    @Override
    public Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.getAllAndSearch(productSearchDto, pageable);
    }
}
