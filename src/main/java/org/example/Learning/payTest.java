package org.example.Learning;

public class payTest {
    // 收银策略接口
    public interface CashStrategy {
        double calculate(double price);
    }

    // 正常收银策略
    public static class NormalCashStrategy implements CashStrategy {
        @Override
        public double calculate(double price) {
            return price;
        }
    }

    // 打折收银策略
    public static class DiscountCashStrategy implements CashStrategy {
        private double discountRate; // 折扣率

        public DiscountCashStrategy(double discountRate) {
            this.discountRate = discountRate;
        }

        @Override
        public double calculate(double price) {
            return price * discountRate;
        }
    }

    // 返利收银策略
    public static class RebateCashStrategy implements CashStrategy {
        private double condition; // 返利条件
        private double returnAmount; // 返利金额

        public RebateCashStrategy(double condition, double returnAmount) {
            this.condition = condition;
            this.returnAmount = returnAmount;
        }

        @Override
        public double calculate(double price) {
            if (price >= condition) {
                return price - Math.floor(price / condition) * returnAmount;
            }
            return price;
        }
    }

    // 收银上下文类
    public static class Cashier {
        private CashStrategy strategy;

        public void setStrategy(CashStrategy strategy) {
            this.strategy = strategy;
        }

        public double calculatePrice(double price) {
            return strategy.calculate(price);
        }
    }

    public static void main(String[] args) {
        double price = 1000;
        Cashier cashier = new Cashier();

        // 正常收银
        cashier.setStrategy(new NormalCashStrategy());
        double totalPrice = cashier.calculatePrice(price);
        System.out.println("正常收银总价：" + totalPrice);

        // 商品打折
        cashier.setStrategy(new DiscountCashStrategy(0.8));
        totalPrice = cashier.calculatePrice(price);
        System.out.println("打折后总价：" + totalPrice);

        // 返利模式
        cashier.setStrategy(new RebateCashStrategy(300.0, 100.0));
        totalPrice = cashier.calculatePrice(price);
        System.out.println("返利后总价：" + totalPrice);
    }
}
