package com.emre.controller;

import com.emre.dto.request.ActivateStatusRequestDto;
import com.emre.dto.request.LoginCustomerRequestDto;
import com.emre.dto.request.RegisterCustomerRequestDto;
import com.emre.repository.entity.Customer;
import com.emre.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.emre.constant.EndPointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(REGISTER)
    public ResponseEntity<Customer> register(@RequestBody @Valid RegisterCustomerRequestDto dto) {
        return ResponseEntity.ok(customerService.register(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateStatusRequestDto dto) {
        customerService.activateStatus(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody @Valid LoginCustomerRequestDto dto) {
        customerService.login(dto);
        return ResponseEntity.ok("Giriş işlemi başarıyla gerçekleştirildi!");
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

}
