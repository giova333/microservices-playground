package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;

public interface PlayerBenefitsApplier {

    void apply(PlayerBenefitResponse playerBenefitResponse, PaymentPage paymentPage);
}
