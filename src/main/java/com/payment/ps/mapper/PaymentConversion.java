package com.payment.ps.mapper;


import com.payment.ps.dto.PaymentDto;
import com.payment.ps.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentConversion {
     PaymentDto toDto(Payment payment);
     Payment toEntity(PaymentDto paymentDto);
}
