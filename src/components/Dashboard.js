import React, { useEffect, useState } from 'react';
import axios from 'axios';
import BookingForm from './BookingForm';
import DefenderImage from '../Photos/range.jpg'; // Import the background image

const Dashboard = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const token = localStorage.getItem('token');
        const userId = localStorage.getItem('userId2');
        console.log(userId);
        const response = await axios.get(`http://localhost:8080/api/users/${userId}`, {
          headers: { Authorization: `Bearer ${token}` }, // Fixed template literal
        });
        setUser(response.data);
      } catch (error) {
        console.error('Failed to fetch user data', error);
      }
    };

    fetchUserData();
  }, []);

  return (
    <div
      style={{
        backgroundImage: `url(${DefenderImage})`,
        backgroundSize: 'cover', // Ensures the image covers the entire div
        backgroundPosition: 'center', // Centers the image
        minHeight: '100vh', // Ensures the div takes at least the full viewport height
        padding: '20px', // Adds some padding for better spacing
      }}
    >
      <h2>User Dashboard</h2>
      {user ? (
        <div
          style={{
            backgroundColor: 'rgba(255, 255, 255, 0.8)', // Adds a semi-transparent white background
            padding: '20px',
            borderRadius: '10px', // Rounded corners
            maxWidth: '800px', // Limits the width of the content
            margin: '0 auto', // Centers the content horizontally
          }}
        >
          <p>Welcome, {user.fname} {user.lname}</p>
          <p>Email: {user.email}</p>
          <p>Phone: {user.phoneNo}</p>
          <BookingForm />
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default Dashboard;