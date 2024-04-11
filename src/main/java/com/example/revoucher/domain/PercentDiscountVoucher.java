package com.example.revoucher.domain;

import static com.example.revoucher.common.ErrorMesaage.INVALID_DISCOUNT;
import static com.example.revoucher.domain.VoucherType.*;

public class PercentDiscountVoucher extends Voucher {
	private static int MIN_PERCENT = 1;
	private static int MAX_PERCENT = 99;

	public PercentDiscountVoucher(Long amount, Long discount) {
		super(amount, discount, PERCENT);
	}

	@Override
	public void validateDiscount() {
		if (discount > MAX_PERCENT || discount < MIN_PERCENT) {
			throw new IllegalArgumentException(INVALID_DISCOUNT);
		}
	}

	@Override
	public Long getDiscountedAmount() {
		return amount - (amount * (discount / 100));
	}
}
