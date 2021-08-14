package com.system.design.systemdesign.shoppingcart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    Map<Long, List<OfferProduct>> productMap = new HashMap<>();
    Map<Long,Long> offerProductMapping = new HashMap<>();
    public void addOffer(long productID, long offerID, double price) {
        if( !productMap.containsKey( productID)){
            productMap.put( productID, new ArrayList<>());
        }
        productMap.get( productID).add( OfferProduct.builder().
                offerId( offerID).price( price).productId(productID).build());
        offerProductMapping.put( offerID, productID);
    }

    public void removeOffer(long offerID) {
        long productId = offerProductMapping.remove( offerID);
        List<OfferProduct> offerProducts = productMap.get(productId);
        offerProducts.remove(OfferProduct.builder().offerId(offerID).build());
    }

    public long getClosestOffer(long productID, double price) {
        List<OfferProduct> offerProducts = productMap.get( productID);
        long offerId = Long.MAX_VALUE;
        double priceDiff = Long.MIN_VALUE;
        for( OfferProduct offerProduct : offerProducts ){
            if( price - offerProduct.getPrice() > priceDiff ){
                offerId = offerProduct.offerId;
                priceDiff = price - offerProduct.getPrice();
            }
        }
        return offerId;
    }
}
