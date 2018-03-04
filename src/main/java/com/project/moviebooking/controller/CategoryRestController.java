package com.project.moviebooking.controller;


import com.project.moviebooking.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/", headers = "Accept=application/json")
    @ResponseBody
    public boolean testSave(@RequestBody SignUpRequest userInfo) {
        String phone = userInfo.getPhone();
        String countryCode = userInfo.getCountryCode();
        String email = userInfo.getEmail();

        Account account = new Account();
        account.setId("10000000000"); //still, for the reason of simplicity...
        account.setPhone(phone);
        account.setCountryCode(CountryCode.China);
        account.setEmail(email);
        accountService.save(account);
        return true;
    }

}
