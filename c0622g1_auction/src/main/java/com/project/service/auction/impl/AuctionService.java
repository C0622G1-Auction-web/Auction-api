package com.project.service.auction.impl;

import com.project.dto.auction.ITransactionDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.dto.product.IAuctionProductDto;
import com.project.dto.AuctionDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.model.users.User;
import com.project.repository.auction.IAuctionRepository;
import com.project.service.auction.IAuctionService;
import com.project.service.product.IProductService;
import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionService implements IAuctionService {
    @Autowired
    private IAuctionRepository auctionRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.OK
     */

    @Override
    public Page<ITransactionDto> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable) {
        return auctionRepository.findAllTransaction(transactionSearchDto, pageable);
    }

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        auctionRepository.removeByListId(idList);
    }


    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    @Override
    public List<ITransactionDto> findByListId(List<Integer> idList) {
        return auctionRepository.findByListId(idList);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     *
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Page<Auction> getPageAuctionByProductId(Integer productId, Pageable pageable) {
        return auctionRepository.getPageAuctionByProductId(productId, pageable);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: create new auction
     *
     * @param auctionDto
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @Override
    public AuctionDto addAuction(AuctionDto auctionDto) {
        auctionDto.setAuctionTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        auctionRepository.addAuction(
                auctionDto.getCurrentPrice(),
                auctionDto.getProductId(),
                auctionDto.getUserId(),
                auctionDto.getAuctionTime());
//        Auction auction = auctionRepository.getAuctionFromProductId(auctionDto.getProductId());
//        AuctionDto newDto = new AuctionDto();
//        newDto.setFullName(auction.getUser().getFirstName() + " " + auction.getUser().getLastName());
//        BeanUtils.copyProperties(auction, newDto);
        return auctionDto;
    }

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    @Override
    public List<Integer> getAuctionIds(List<Integer> idList) {
        return auctionRepository.getAuctionIds(idList);
    }

    /**
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'userID'
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    @Override
    public Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable) {
        return auctionRepository.getPageAuctionProductByIdUser(userId, pageable);
    }

    @Override
    public Optional<Auction> getAuctionByProductId(Integer productId) {
        return auctionRepository.getAuctionFromProductId(productId);
    }

    public static String formatCurrency(String amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(Double.parseDouble(amount));
    }

    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Send Mail Successful Auction
     *
     * @param  maxCurrentPrice, userId, productId
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public void sendMailFirstAuction(Double maxCurrentPrice, Integer userId, Integer productId) throws MessagingException {
        User userFirstAuction = userService.findUserById(userId);
        System.out.println(userFirstAuction);
        Optional<Product> productOptional = productService.findByProductId(productId);
        Product productSuccessfulAuction = productOptional.get();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Phiên Đấu Giá Thành Công");
        mimeMessageHelper.setTo(userFirstAuction.getEmail());
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Phiên Đấu Giá</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088ff\">Phiên Đấu Giá Sản Phẩm " + productSuccessfulAuction.getName() + " </h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/Chị " + userFirstAuction.getFirstName()+" "+userFirstAuction.getLastName() + " </p>\n" +
                "<p>Cám ơn Anh/Chị đã tham gia đấu giá sản phẩm " + productSuccessfulAuction.getName() + " với mức giá " + formatCurrency(maxCurrentPrice.toString()) + " VNĐ</p>\n" +
                "<p>Sau khi có giá cao hơn chúng tôi sẽ cập nhật ngay cho Anh/Chị</p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu có thắc mắc, Anh/Chị vui lòng liên hệ số hotline. <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể.\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời.</p>\n" +
                "<p>Trân trọng.</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>\n";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Get Second Auction
     *
     * @param  productId
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Optional<Auction> getSecondAuction(Integer productId) {
        return auctionRepository.getSecondAuction(productId);
    }

    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Send Mail Second Auction
     *
     * @param  user, product, currentPrice
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public void sendMailSecondAuction(User user, Product product, Double currentPrice, Double maxCurrentPrice) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Phiên Đấu Giá Thành Công");
        mimeMessageHelper.setTo(user.getEmail());
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Thông Báo Đấu Giá</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088ff\">Thông Báo Tình Trạng Đấu Giá Sản Phẩm " + product.getName() + " </h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/Chị " + user.getFirstName() + " " + user.getLastName() + " </p>\n" +
                "<p>Hiện tại đã có người đưa ra mức giá " + formatCurrency(maxCurrentPrice.toString())+" VNĐ lớn hơn mức giá của Anh/Chị là "+ formatCurrency(currentPrice.toString())+" VNĐ </p>\n" +
                "<p>Để tiến hành đưa ra mức giá cao hơn, anh chị vui lòng truy cập vào trang lịch sử đấu giá</p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu có thắc mắc, Anh/Chị vui lòng liên hệ số hotline. <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể.\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời.</p>\n" +
                "<p>Trân trọng.</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>\n";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }
}
