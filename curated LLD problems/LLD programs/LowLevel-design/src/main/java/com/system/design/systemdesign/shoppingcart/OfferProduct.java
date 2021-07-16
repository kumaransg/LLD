package com.system.design.systemdesign.shoppingcart;

import lombok.*;

import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OfferProduct {
    long productId;
    long offerId;
    double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferProduct that = (OfferProduct) o;
        return offerId == that.offerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId);
    }
}
