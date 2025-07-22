package com.payment.ps.service;

import com.payment.ps.dto.PaymentDto;
import com.payment.ps.entity.Payment;
import com.payment.ps.mapper.PaymentConversion;
import com.payment.ps.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceimpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentConversion paymentConversion;

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
       // Convert DTO to entity
        Payment payment=paymentConversion.toEntity(paymentDto);

        Payment paymentNew=paymentRepository.save(payment);

        // Convert the saved entity back to DTO
        PaymentDto paymentDtoNew=paymentConversion.toDto(paymentNew);
        return paymentDtoNew;
    }
}
