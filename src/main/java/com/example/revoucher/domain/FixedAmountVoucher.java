package com.example.revoucher.domain;

import static com.example.revoucher.common.ErrorMesaage.INVALID_DISCOUNT;
import static com.example.revoucher.domain.VoucherType.*;

public class FixedAmountVoucher extends Voucher {

	public FixedAmountVoucher(Long amount, Long discount) {
		super(amount, discount, FIXED);
	}

	@Override
	public void validateDiscount() {
		if (discount > amount || discount < 1) {
			throw new IllegalArgumentException(INVALID_DISCOUNT);
		}
	}

	@Override
	public Long getDiscountedAmount() {
		return amount - discount;
	}
}
