package com.tomwaks.systemreservation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {

    private Long id;

    private Date rentalFrom;

    private Date rentalTo;

    private float totalCost;

    private Long hostId;

    private String hostName;

    private Long tenantId;

    private String tenantName;

    private Long flatId;

    private String flatName;

    private int flatPrice;

    private float flatArea;

    private String flatDescription;


    public static final class ReservationResponseDtoBuilder {
        private Long id;
        private Date rentalFrom;
        private Date rentalTo;
        private float totalCost;
        private Long hostId;
        private String hostName;
        private Long tenantId;
        private String tenantName;
        private Long flatId;
        private String flatName;
        private int flatPrice;
        private float flatArea;
        private String flatDescription;

        private ReservationResponseDtoBuilder() {
        }

        public static ReservationResponseDtoBuilder aReservationResponseDto() {
            return new ReservationResponseDtoBuilder();
        }

        public ReservationResponseDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReservationResponseDtoBuilder withRentalFrom(Date rentalFrom) {
            this.rentalFrom = rentalFrom;
            return this;
        }

        public ReservationResponseDtoBuilder withRentalTo(Date rentalTo) {
            this.rentalTo = rentalTo;
            return this;
        }

        public ReservationResponseDtoBuilder withTotalCost(float totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public ReservationResponseDtoBuilder withHostId(Long hostId) {
            this.hostId = hostId;
            return this;
        }

        public ReservationResponseDtoBuilder withHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public ReservationResponseDtoBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ReservationResponseDtoBuilder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public ReservationResponseDtoBuilder withFlatId(Long flatId) {
            this.flatId = flatId;
            return this;
        }

        public ReservationResponseDtoBuilder withFlatName(String flatName) {
            this.flatName = flatName;
            return this;
        }

        public ReservationResponseDtoBuilder withFlatPrice(int flatPrice) {
            this.flatPrice = flatPrice;
            return this;
        }

        public ReservationResponseDtoBuilder withFlatArea(float flatArea) {
            this.flatArea = flatArea;
            return this;
        }

        public ReservationResponseDtoBuilder withFlatDescription(String flatDescription) {
            this.flatDescription = flatDescription;
            return this;
        }

        public ReservationResponseDto build() {
            ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
            reservationResponseDto.setId(id);
            reservationResponseDto.setRentalFrom(rentalFrom);
            reservationResponseDto.setRentalTo(rentalTo);
            reservationResponseDto.setTotalCost(totalCost);
            reservationResponseDto.setHostId(hostId);
            reservationResponseDto.setHostName(hostName);
            reservationResponseDto.setTenantId(tenantId);
            reservationResponseDto.setTenantName(tenantName);
            reservationResponseDto.setFlatId(flatId);
            reservationResponseDto.setFlatName(flatName);
            reservationResponseDto.setFlatPrice(flatPrice);
            reservationResponseDto.setFlatArea(flatArea);
            reservationResponseDto.setFlatDescription(flatDescription);
            return reservationResponseDto;
        }
    }
}
