package com.emre.service;

import com.emre.dto.request.ActivateStatusRequestDto;
import com.emre.dto.request.LoginCustomerRequestDto;
import com.emre.dto.request.RegisterCustomerRequestDto;
import com.emre.exception.ErrorType;
import com.emre.exception.YemekSepetiException;
import com.emre.mapper.ICustomerMapper;
import com.emre.repository.ICustomerRepository;
import com.emre.repository.entity.Customer;
import com.emre.repository.entity.EStatus;
import com.emre.utility.CodeGenerator;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public Customer register(RegisterCustomerRequestDto dto) {
        Optional<Customer> optionalCustomer = customerRepository.findOptionalByEmail(dto.getEmail());
        if (optionalCustomer.isPresent())
            throw new YemekSepetiException(ErrorType.USERNAME_DUPLICATE);
        Customer customer = ICustomerMapper.INSTANCE.fromDtoToSaveCustomer(dto);
        customer.setActivationCode(CodeGenerator.generateCode());
        return save(customer);
    }

    public Boolean activateStatus(ActivateStatusRequestDto dto) {
        Optional<Customer> optionalCustomer = customerRepository.findOptionalByCustomerId(dto.getCustomerId());
        if (optionalCustomer.isEmpty()) throw new YemekSepetiException(ErrorType.USERNAME_DUPLICATE);
        if (!optionalCustomer.get().getActivationCode().equals(dto.getActivateCode()))
            throw new YemekSepetiException(ErrorType.ACTIVATE_CODE_ERROR);
        optionalCustomer.get().setStatus(EStatus.ACTIVE);
        update(optionalCustomer.get());
        return true;
    }

    public Boolean login(LoginCustomerRequestDto dto) {
        Optional<Customer> customer = customerRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (customer.isEmpty()) throw new YemekSepetiException(ErrorType.LOGIN_ERROR);
        else if (customer.get().getStatus().equals(EStatus.PENDING))
            throw new YemekSepetiException(ErrorType.USER_NOTACTIVE);
        return true;
    }
}
