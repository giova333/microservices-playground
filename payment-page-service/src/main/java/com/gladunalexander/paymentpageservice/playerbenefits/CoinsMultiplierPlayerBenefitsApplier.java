package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import com.gladunalexander.paymentpageservice.PaymentPageOption;
import com.gladunalexander.paymentpageservice.playerbenefits.data.CoinsMultiplierBenefitResponse;
import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;

public class CoinsMultiplierPlayerBenefitsApplier implements PlayerBenefitsApplier {

    @Override
    public void apply(PlayerBenefitResponse playerBenefitResponse, PaymentPage paymentPage) {
        if (!(playerBenefitResponse instanceof CoinsMultiplierBenefitResponse)) return;

        var coinsMultiplierBenefit = (CoinsMultiplierBenefitResponse) playerBenefitResponse;

        paymentPage.getOptions().forEach(paymentPageOption -> apply(paymentPageOption, coinsMultiplierBenefit));
    }

    private void apply(PaymentPageOption paymentPageOption, CoinsMultiplierBenefitResponse coinsMultiplierBenefit) {
        var newAmount = (long) Math.ceil(coinsMultiplierBenefit.getMultiplier() * paymentPageOption.getCoinsAmount());
        paymentPageOption.setCoinsAmount(newAmount);
    }
}
