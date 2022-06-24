package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Invoice findInvoiceByNumber (Integer number);
}
