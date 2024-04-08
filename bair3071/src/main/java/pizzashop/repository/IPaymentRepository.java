package pizzashop.repository;

import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public interface IPaymentRepository {

    public void add(Payment payment);

    public List<Payment> getAll();

    public void writeAll();
}
