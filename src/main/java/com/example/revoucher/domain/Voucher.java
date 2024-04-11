package com.example.revoucher.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public abstract class Voucher {
	public UUID id;
	public Long amount;
	public Long discount;
	public VoucherType type;

	protected Voucher(Long amount, Long discount, VoucherType type) { // 자식만 생성자에 접근할 수 있도록 접근제한자를 protected으로 제한
		validateDiscount();
		this.id = UUID.randomUUID();
		this.amount = amount;
		this.discount = discount;
		this.type = type;
	}

	public abstract void validateDiscount();

	public abstract Long getDiscountedAmount();
}
