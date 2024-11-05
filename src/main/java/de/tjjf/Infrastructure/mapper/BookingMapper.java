package de.tjjf.Infrastructure.mapper;

import de.tjjf.Domain.models.MBooking;
import de.tjjf.Infrastructure.models.Booking;
/*
public class BookingMapper extends Mapper<MBooking, Booking> {

    public Booking toEntity(MBooking mBooking){
        return new Booking(
                mBooking.getBookingId(),
                new PersonMapper().toEntity(mBooking.getPersonId()),
                mBooking.getFlight(),
                mBooking.getDateTimeOfBooking(),
                mBooking.getTotalPrice(),
                mBooking.getSeatNum(),
                mBooking.getSeatingClass(),
                mBooking.getBookingStatus(),
                mBooking.getMaxWeightOfLuggage()

        );
    }

    public MBooking toDomain(Booking booking){
        return new MBooking(
                booking.getBookingId(),
                booking.getPersonId(),
                booking.getFlightNum(),
                booking.getDateTimeOfBooking(),
                booking.getTotalPrice(),
                booking.getSeatNum(),
                booking.getSeatingClass(),
                booking.getBookingStatus(),
                booking.getMaxWeightOfLuggage()
        );
    }
}*/
