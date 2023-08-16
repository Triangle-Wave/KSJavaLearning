package org.example.ExcelTest;

import lombok.Data;

/**
 * @author TWAVE
 * @date 2023/8/15 11:55
 */
@Data
public class ExcelEntity {
    String orderId;
    String customerId;
    String orderDate;
    String orderStatus;
    String receiverName;
    String receiverPhone;
    String receiverAddress;
    String productDetail;
    String others;
}
