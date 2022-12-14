package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.auction.Auction;
import com.project.model.product.AuctionStatus;
import com.project.model.product.Category;
import com.project.model.product.PriceStep;
import com.project.model.product.ReviewStatus;
import com.project.model.product.dto.ProductDTO;
import com.project.model.users.User;
import com.project.model.users.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_editProduct {

}
