//package com.project.util.annotation;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(validatedBy = AuctionPriceValidator.class)
////Nếu muốn tạo annotation cho class thì dùng type
////Nếu muốn tạo annotation cho thuộc tính thì dùng field
////Nếu muốn tạo annotation cho phương thức thì dùng method
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface CheckAuctionPrice {
//    String message() default "Giá Đấu Phải Là Số Dương";
//    Class<?> [] group() default {};
//    Class<? extends Payload > [] payload() default {};
//}
