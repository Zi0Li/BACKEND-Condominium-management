package br.com.smartcondo.records;

import br.com.smartcondo.models.Kiosk;
import br.com.smartcondo.models.Reservation;

import java.util.List;

public record ReservationAndKioskDTO(List<Reservation> reservation, Kiosk kiosk) {

    public ReservationAndKioskDTO(List<Reservation> reservation, Kiosk kiosk) {
        this.reservation = reservation;
        this.kiosk = kiosk;
    }

    @Override
    public String toString() {
        return "ReservationAndKioskDTO{" +
                "reservation=" + reservation +
                ", kiosk=" + kiosk +
                '}';
    }
}
