package com.gladunalexander.paymentpageservice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface PaymentPageRepository extends CrudRepository<PaymentPage, Long> {

    Optional<PaymentPage> findByName(String name);
}
