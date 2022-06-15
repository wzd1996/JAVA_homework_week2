import supermarket.LittleSuperMarket;
import supermarket.MerchandiseV2;

public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        // 创建一个小超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket(
                "友家小超市", "浦东新区世纪大道667号",
                100, 200, 200);
        System.out.println("VIP的折上折的折扣最终为：" + MerchandiseV2.getDiscountOnDiscount(littleSuperMarket));

    }
}
