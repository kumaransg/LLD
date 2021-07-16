package com.system.design.oops.bookmyshow2;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class Customer extends Person {
    public boolean makeBooking(Booking booking) throws SQLException {  List<ShowSeat> seats = booking.getSeats();
        Integer seatIds[] = new Integer[seats.size()];
        int index = 0;
        for(ShowSeat seat : seats) {
            seatIds[index++] = seat.getShowSeatId();
        }

        Connection dbConnection = null;
        try {
            dbConnection = getDBConnection();
            dbConnection.setAutoCommit(false);
            // ‘Serializable’ is the highest isolation level and guarantees safety from
            // Dirty, Nonrepeatable, and Phantoms reads
            dbConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            Statement st = dbConnection.createStatement();
            String selectSQL = "Select * From ShowSeat where ShowID=? && ShowSeatID in (?) && isReserved=0";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, booking.getShow().getShowId());
            Array array = dbConnection.createArrayOf("INTEGER", seatIds);
            preparedStatement.setArray(2, array);

            ResultSet rs = preparedStatement.executeQuery();
            // With TRANSACTION_SERIALIZABLE all the read rows will have the write lock, so we can
            // safely assume that no one else is modifying them.
            if (rs.next()) {
                rs.last(); // move to the last row, to calculate the row count
                int rowCount = rs.getRow();
                // check if we have expected number of rows, if not, this means another process is
                // trying to process at least one of the same row, if that is the case we
                // should not process this booking.
                if(rowCount == seats.size()) {
                    // update ShowSeat table...
                    // update Booking table ...
                    dbConnection.commit();
                    return true;
                }
            }
        } catch (SQLException e) {
            dbConnection.rollback();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private Connection getDBConnection() {
        return null;
    }

    public List<Booking> getBookings(){ return Collections.emptyList();}
}
