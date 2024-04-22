package pizzashop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentTest {

  @Test
  void toStringTest() {
    Payment payment = new Payment(1, PaymentType.CASH, 20.0);
    String expectedString = "1,CASH,20.0";
    assertEquals(expectedString, payment.toString());
  }

  @Test
  void getSetTest() {
    Payment payment = new Payment(1, PaymentType.CASH, 20.0);
    payment.setTableNumber(2);
    payment.setType(PaymentType.CARD);
    payment.setAmount(30.0);

    assertEquals(2, payment.getTableNumber());
    assertEquals(PaymentType.CARD, payment.getType());
    assertEquals(30.0, payment.getAmount());
  }
}
