package lk.backend.controller;

import lk.backend.entity.AppUser;
import lk.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "procumentary/" + "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.login(appUser));
    }

}
