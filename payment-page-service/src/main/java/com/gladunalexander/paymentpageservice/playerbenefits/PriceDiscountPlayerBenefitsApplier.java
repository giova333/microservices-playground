package com.gladunalexander.paymentpageservice.playerbenefits;

import com.gladunalexander.paymentpageservice.PaymentPage;
import com.gladunalexander.paymentpageservice.PaymentPageOption;
import com.gladunalexander.paymentpageservice.playerbenefits.data.PlayerBenefitResponse;
import com.gladunalexander.paymentpageservice.playerbenefits.data.PriceDiscountBenefitResponse;

public class PriceDiscountPlayerBenefitsApplier implements PlayerBenefitsApplier {

    @Override
    public void apply(PlayerBenefitResponse playerBenefitResponse, PaymentPage paymentPage) {
        if (!(playerBenefitResponse instanceof PriceDiscountBenefitResponse)) return;

        var priceDiscountBenefit = (PriceDiscountBenefitResponse) playerBenefitResponse;

        paymentPage.getOptions().forEach(paymentPageOption -> apply(paymentPageOption, priceDiscountBenefit));
    }

    private void apply(PaymentPageOption paymentPageOption, PriceDiscountBenefitResponse priceDiscountBenefit) {
        var priceDiscount = paymentPageOption.getPrice() * priceDiscountBenefit.getDiscount();
        var newPrice = paymentPageOption.getPrice() - priceDiscount;
        var roundedPrice = Math.round(newPrice * 100.0) / 100.0;
        paymentPageOption.setPrice(roundedPrice);
    }
}
