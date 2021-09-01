package com.gladunalexander.paymentpageservice;

import com.gladunalexander.paymentpageservice.playerbenefits.PlayerBenefitsFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentPageService {

    private final PaymentPageRepository paymentPageRepository;
    private final PlayerBenefitsFacade playerBenefitsFacade;

    public Optional<PaymentPage> getPaymentPageForPlayer(String playerId) {
        var paymentPage = paymentPageRepository.findByName(PaymentPage.DEFAULT_NAME);
        paymentPage.ifPresent(page -> playerBenefitsFacade.applyPlayerBenefits(playerId, page));
        return paymentPage;
    }

    @Transactional
    public PaymentPage save(PaymentPage paymentPage) {
        log.info("Saving payment page {}", paymentPage);
        return paymentPageRepository.save(paymentPage);
    }

    @Transactional
    public void deleteByName(String name) {
        paymentPageRepository.findByName(name)
                             .ifPresent(paymentPageRepository::delete);
    }
}
