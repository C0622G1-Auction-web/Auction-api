package com.project.automatic_task.component;

import com.project.automatic_task.dto.IPaymentCheckDto;
import com.project.automatic_task.dto.IProductTimeDto;
import com.project.automatic_task.dto.ITopAuctionDetailDto;
import com.project.automatic_task.service.IScheduleService;
import com.project.model.product.PriceStep;
import com.project.model.product.Product;
import com.project.model.users.User;
import com.project.service.product.IProductService;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class ScheduleTask {

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;



    /**
     * Create by GiangLBH
     * Date created: 25/12/2022
     * Function: check start time of Product to open Auction
     */
    @Scheduled(fixedRate  = 5000)
    public void openAuction() throws InterruptedException, MessagingException {
        System.out.println("Kiểm tra các sản phẩm bắt đầu đấu giá");
        List<IProductTimeDto> productTimeDtoList = scheduleService.checkStartTime();
        if (!productTimeDtoList.isEmpty()) {
            for (IProductTimeDto productTimeDto : productTimeDtoList) {
                scheduleService.openAuction(productTimeDto.getId());
                // Gửi mail
                Product product = productService.findByProductId(productTimeDto.getId()).get();
                sendMailOpenAuction(product.getUser().getEmail());
            }
        }
    }

    /**
     * Create by GiangLBH
     * Date created: 25/12/2022
     * Function: check end time of Product to close Auction
     */
    @Scheduled(fixedDelay =  10000)
    public void closeAuction() throws InterruptedException, MessagingException {
        System.out.println("Kiểm tra các sản phẩm kết thúc đấu giá");
        List<IProductTimeDto> productTimeDtoList = scheduleService.checkEndTime();
        if (!productTimeDtoList.isEmpty()) {
            for (IProductTimeDto productTimeDto : productTimeDtoList) {
                // Tìm người đấu giá cao nhất
                ITopAuctionDetailDto topAuction = scheduleService.findSuccessAuction(productTimeDto.getId());
                if (topAuction != null) {
                    // Thiết lập trạng thái đấu giá thành công cho sản phẩm
                    scheduleService.setSuccessProduct(productTimeDto.getId());

                    // Thiết lập auction cao nhất thành thành công
                    scheduleService.setSuccessAuction(topAuction.getAuctionId());
                    //Tạo payment cho auction thành công
                    scheduleService.createPayment(topAuction.getAuctionId());
                    // Gửi mail cho người mua thanh toán
                    Product product = productService.findByProductId(productTimeDto.getId()).get();
                    sendMailPay(product.getUser().getEmail());


                } else {
                    // Thiết lập trạng thái đấu giá thất bại
                    scheduleService.setFailureProduct(productTimeDto.getId());
                    // Gửi mail cho người bán

                }
            }
        }
    }

    /**
     * Create by GiangLBH
     * Date created: 25/12/2022
     * Function: check payment status and lock account at end time payment (every hour)
     */
    @Scheduled(cron = "0 */1 * * * *")
    public void lockAccountNoPay() throws InterruptedException  {
        System.out.println("Kiểm tra tình trạng thanh toán");

        List<IPaymentCheckDto> paymentCheckDtos = scheduleService.getPaymentOutOfEndDate();
        if (!paymentCheckDtos.isEmpty()) {
            for (IPaymentCheckDto paymentCheckDto : paymentCheckDtos) {
                // Thiết lập trạng thái thanh toán thất bại
                scheduleService.setFailurePayment(paymentCheckDto.getPaymentId());
                // Khoá tài khoản người mua
                scheduleService.lockAccount(paymentCheckDto.getBuyerId());
                // Gửi mail cho người mua và bán
                User buyer = userService.findUserById(paymentCheckDto.getBuyerId());
                User seller = userService.findUserById(paymentCheckDto.getSellerId());

                try {
                    // Gửi mail cho người mua
                    sendMail(buyer.getEmail());
                    // Gửi mail cho người bán
                    sendMailSeller(seller.getEmail());
                } catch (MessagingException e) {
                    //write log error
                }
            }
        }
    }

    public void sendMail(String email) throws MessagingException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Khóa tài khoản đấu giá C06");
        mimeMessageHelper.setTo(email);
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Khóa Tài Khoản</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088FF\">Tài Khoản Của Anh/Chị Đã Bị Khóa</h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/ Chị</p>\n" +
                "<p>Vì Anh/Chị đã vi phạm quy chế đấu giá, cụ thể là không thanh toán sản phẩm sau khi đấu giá thành công. Nên tài khoản của Anh/ Chị hiện tại đã bị vô hiệu hóa.</p>\n" +
                "<p>Để Mở khóa vui lòng liên hệ Admin của trang chủ Đấu Giá C06.</p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu có thắc mắc, Anh/Chị vui lòng liên hệ số hotline <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời</p>\n" +
                "<p>Trân trọng</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendMailPay(String email) throws MessagingException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Thông báo đấu giá C06");
        mimeMessageHelper.setTo(email);
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Đấu Giá Thành Công</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088FF\">Đấu Giá Thành Công</h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/Chị</p>\n" +
                "<p>Chúc mừng Anh/Chị đã đấu giá thành công sản phẩm</p>\n" +
                "<p>Để nhận được sản phẩm. Vui lòng Anh/Chị vào giỏ hàng để tiến hành thanh toán</p>\n" +
                "<p>Trong vòng 24h nếu sản phẩm chưa được thanh toán. Chúng tôi sẽ tiến hành khóa tài khoản của Anh/Chị vì vi phạm quy chế đấu giá</p>\n" +
                "<p>Anh/Chị vui lòng đọc lại quy chế đấu giá để biết nội quy trang web của chúng tôi</p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu có thắc mắc, Anh/Chị vui lòng liên hệ số hotline. <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể.\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời.</p>\n" +
                "<p>Trân trọng.</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendMailOpenAuction(String email) throws MessagingException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Khóa tài khoản đấu giá C06");
        mimeMessageHelper.setTo(email);
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Sản Phẩm Lên Sàn</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088FF\">Sản Phẩm Của Anh/Chị Đã Đến Giờ Đấu Giá</h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/Chị</p>\n" +
                "<p>Sản phẩm của Anh/Chị đã đến giờ cho phép đấu giá.</p>\n" +
                "<p>Để theo dõi tình trạng đấu giá. Anh/Chị vui lòng vào trang lịch sử đơn hàng xem cập nhất mới nhất.</p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu có thắc mắc, Anh/Chị vui lòng liên hệ số hotline. <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể.\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời.</p>\n" +
                "<p>Trân trọng.</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendMailSeller(String email) throws MessagingException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Đấu giá C06 thông báo");
        mimeMessageHelper.setTo(email);
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Khóa Tài Khoản</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088FF\">Tài Khoản Của Anh/Chị Đã Bị Khóa</h1>\n" +
                "<p style=\"margin-bottom: 50px\">Xin chào Anh/ Chị</p>\n" +
                "<p>Sản phẩm của Anh/ chị đã được đấu giá thành công! Nhưng bên mua không thanh toán, </p>\n" +
                "<p>nên chúng tôi đã thu hồi, Chúng tôi rất xin lỗi vì sự bất tiện này. </p>\n" +
                "<p style=\"margin-bottom: 50px\">Nếu bạn muốn đấu giá lại Anh/Chị vui lòng liên hệ số hotline <strong style=\" color: orangered\">0909.999.999</strong>\n" +
                "    để được hỗ trợ sớm nhất có thể\n" +
                "</p>\n" +
                "<p>Chúc Anh/Chị có một ngày tuyệt vời</p>\n" +
                "<p>Trân trọng</p>\n" +
                "<p>Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\", height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }
}
