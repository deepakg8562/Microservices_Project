package com.example.ShoppingCartProduct.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ProductInfoBuilder implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details", Collections.singletonMap("description", "TLDR "));
	}

}