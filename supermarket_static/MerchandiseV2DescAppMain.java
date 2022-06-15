import supermarket.MerchandiseV2;
import static supermarket.MerchandiseV2.getVIPDiscount;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandise = new MerchandiseV2
            ("小冰箱", "LITTLE_REFRIGERATOR9527", 40, 1099.9, 500);

        merchandise.describe();

        // >> TODO 使用import static来引入一个静态方法，就可以直接用静态变量名访问了
        // >> TODO import static也可以使用通配符*来引入一个类里所有静态变量
        System.out.println(getVIPDiscount());
    }
}
