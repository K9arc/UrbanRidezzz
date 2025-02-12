import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import DefenderImage from '../Photos/ll.jpg'; // Import the background image

const Register = () => {
  const [formData, setFormData] = useState({
    fname: '',
    lname: '',
    email: '',
    password: '',
    role: 'CUSTOMER', // Default role
    drivingLicence: '',
    phoneNo: '',
    address: '',
    city: '',
    state: '',
    zipCode: '',
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/users/register', formData);
      navigate('/login');
    } catch (error) {
      console.error('Registration failed', error);
    }
  };

  return (
    <div
      className="register-page"
      style={{
        backgroundImage: `url(${DefenderImage})`,
        backgroundSize: 'cover', // Ensures the image covers the entire div
        backgroundPosition: 'center', // Centers the image
        minHeight: '100vh', // Ensures the div takes at least the full viewport height
        display: 'flex',
        alignItems: 'center', // Vertically centers the content
        justifyContent: 'center', // Horizontally centers the content
      }}
    >
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-6">
            <div
              className="card shadow"
              style={{
                backgroundColor: 'rgba(255, 255, 255, 0.8)', // Makes the card slightly transparent
                borderRadius: '10px', // Rounded corners for the card
              }}
            >
              <div className="card-body">
                <h2 className="card-title text-center mb-4">Register</h2>
                <form onSubmit={handleSubmit}>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="fname"
                      className="form-control"
                      placeholder="First Name"
                      value={formData.fname}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="lname"
                      className="form-control"
                      placeholder="Last Name"
                      value={formData.lname}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="email"
                      name="email"
                      className="form-control"
                      placeholder="Email"
                      value={formData.email}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="password"
                      name="password"
                      className="form-control"
                      placeholder="Password"
                      value={formData.password}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <label className="form-label">Role:</label>
                    <select
                      name="role"
                      className="form-select"
                      value={formData.role}
                      onChange={handleChange}
                      required
                    >
                      <option value="CUSTOMER">Customer</option>
                      <option value="ADMIN">Admin</option>
                    </select>
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="drivingLicence"
                      className="form-control"
                      placeholder="Driving Licence"
                      value={formData.drivingLicence}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="phoneNo"
                      className="form-control"
                      placeholder="Phone Number"
                      value={formData.phoneNo}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="address"
                      className="form-control"
                      placeholder="Address"
                      value={formData.address}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="city"
                      className="form-control"
                      placeholder="City"
                      value={formData.city}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="state"
                      className="form-control"
                      placeholder="State"
                      value={formData.state}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="text"
                      name="zipCode"
                      className="form-control"
                      placeholder="Zip Code"
                      value={formData.zipCode}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="d-grid">
                    <button type="submit" className="btn btn-primary">
                      Register
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;