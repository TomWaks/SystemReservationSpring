package com.tomwaks.systemreservation.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationRequestDto {

    private long id;
    private Date rentalFrom;

    private Date rentalTo;

    private float totalCost;

    private long hostId;

    private long tenantId;

    private long flatId;

    @Override
    public String toString() {
        return rentalFrom + " "+ rentalTo;
    }


    public static final class ReservationRequestDtoBuilder {
        private Date rentalFrom;
        private Date rentalTo;
        private float totalCost;
        private long hostId;
        private long tenantId;
        private long flatId;

        private ReservationRequestDtoBuilder() {
        }

        public static ReservationRequestDtoBuilder aReservationRequestDto() {
            return new ReservationRequestDtoBuilder();
        }

        public ReservationRequestDtoBuilder withRentalFrom(Date rentalFrom) {
            this.rentalFrom = rentalFrom;
            return this;
        }

        public ReservationRequestDtoBuilder withRentalTo(Date rentalTo) {
            this.rentalTo = rentalTo;
            return this;
        }

        public ReservationRequestDtoBuilder withTotalCost(float totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public ReservationRequestDtoBuilder withHostId(long hostId) {
            this.hostId = hostId;
            return this;
        }

        public ReservationRequestDtoBuilder withTenantId(long tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ReservationRequestDtoBuilder withFlatId(long flatId) {
            this.flatId = flatId;
            return this;
        }

        public ReservationRequestDto build() {
            ReservationRequestDto reservationRequestDto = new ReservationRequestDto();
            reservationRequestDto.setRentalFrom(rentalFrom);
            reservationRequestDto.setRentalTo(rentalTo);
            reservationRequestDto.setTotalCost(totalCost);
            reservationRequestDto.setHostId(hostId);
            reservationRequestDto.setTenantId(tenantId);
            reservationRequestDto.setFlatId(flatId);
            return reservationRequestDto;
        }
    }
}
