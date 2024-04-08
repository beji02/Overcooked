package pizzashop.repository;

import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import java.util.List;

public class Mock1PaymentRepository implements IPaymentRepository{
    @Override
    public void add(Payment payment) {

    }

    @Override
    public List<Payment> getAll() {
        List<Payment> paymentList = List.of(new Payment(1, PaymentType.CASH, 35.5));
        return paymentList;
    }

    @Override
    public void writeAll() {

    }
}
