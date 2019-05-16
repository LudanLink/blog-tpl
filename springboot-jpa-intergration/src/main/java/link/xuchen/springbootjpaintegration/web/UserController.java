package link.xuchen.springbootjpaintegration.web;

import link.xuchen.springbootjpaintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/16 1:56 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity findAll() {
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

}
