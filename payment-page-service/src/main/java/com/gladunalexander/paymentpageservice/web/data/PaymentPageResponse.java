package com.gladunalexander.paymentpageservice.web.data;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PaymentPageResponse {
    Long id;
    String name;
    List<PaymentPageOptionResponse> options;
}
