package pizzashop.repository;

import pizzashop.model.Payment;

import java.util.List;

public class MockNullPaymentRepository implements IPaymentRepository{
    @Override
    public void add(Payment payment) {

    }

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public void writeAll() {

    }
}
