import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const BookingForm = ({ vehicleId }) => {
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem('token');
      await axios.post(
        'http://localhost:8080/api/bookings',
        { vehicleId, startDate, endDate },
        { headers: { Authorization: `Bearer ${token}` } }
      );
      navigate('/dashboard');
    } catch (error) {
      console.error('Booking failed', error);
    }
  };

  return (
    <div>
      <h2>Book Vehicle</h2>
      <form onSubmit={handleSubmit}>
        <input type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} required />
        <input type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} required />
        <button type="submit">Book</button>
      </form>
    </div>
  );
};

export default BookingForm;