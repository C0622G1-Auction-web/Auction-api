package com.project.controller.users;

import com.project.dto.IUserDto;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserRestController {


    @Autowired
    private IUserService userService;

    /**
     * Created by: BacBC,
     * Date created: 13/12/2022
     * Function: find user by id
     *
     * @param id
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getInfoUser(@PathVariable("id") Integer id){
        IUserDto userDto = userService.findIdUser(id);
        if(userDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }



}
