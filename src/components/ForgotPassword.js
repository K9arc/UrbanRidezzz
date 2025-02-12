import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ForgotPassword = () => {
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/users/forgot-password', { email });
      setMessage(response.data.message);
    } catch (error) {
      setMessage('Failed to send reset password email.');
      console.error('Error:', error);
    }
  };

  return (
    <div className="forgot-password-page" style={{ minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-4">
            <div className="card shadow">
              <div className="card-body">
                <h2 className="card-title text-center mb-4">Forgot Password</h2>
                <form onSubmit={handleSubmit}>
                  <div className="mb-3">
                    <input
                      type="email"
                      className="form-control"
                      placeholder="Email"
                      value={email}
                      onChange={(e) => setEmail(e.target.value)}
                      required
                    />
                  </div>
                  <div className="d-grid">
                    <button type="submit" className="btn btn-primary">
                      Send Reset Link
                    </button>
                  </div>
                  {message && <div className="alert alert-info mt-3">{message}</div>}
                </form>
                <div className="text-center mt-3">
                  <a href="/login" style={{ textDecoration: 'none' }}>
                    Back to Login
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ForgotPassword;