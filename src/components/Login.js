import React, { useState, useRef } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import ReCAPTCHA from 'react-google-recaptcha';
import DefenderImage from '../Photos/defend.jpeg'; // Import the background image

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [captchaVerified, setCaptchaVerified] = useState(false); // State to track CAPTCHA verification
  const captchaRef = useRef(null); // Ref for the CAPTCHA component
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    // Check if CAPTCHA is verified
    if (!captchaVerified) {
      alert('Please verify the CAPTCHA.');
      return;
    }

    try {
      const response = await axios.post(
        `http://localhost:8080/api/users/login?email=${email}&password=${password}`
      );
      localStorage.setItem('token', response.data.token);
      localStorage.setItem('userId', response.data.user);
      localStorage.setItem('userId2', response.data.id);
      navigate('/dashboard');
    } catch (error) {
      console.error('Login failed', error);
    }
  };

  // Handle CAPTCHA verification
  const handleCaptchaChange = (value) => {
    if (value) {
      setCaptchaVerified(true); // CAPTCHA is verified
    } else {
      setCaptchaVerified(false); // CAPTCHA is not verified
    }
  };

  // Handle Forgot Password
  const handleForgotPassword = () => {
    navigate('/forgot-password'); // Redirect to the forgot password page
  };

  return (
    <div
      className="login-page"
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
          <div className="col-md-4">
            <div
              className="card shadow"
              style={{
                backgroundColor: 'rgba(255, 255, 255, 0.5)', // Semi-transparent white background
                backdropFilter: 'blur(10px)', // Adds a blur effect to the background
                border: '1px solid rgba(255, 255, 255, 0.3)', // Light border
              }}
            >
              <div className="card-body">
                <h2 className="card-title text-center mb-4" style={{ color: '#000' }}>Login</h2>
                <form onSubmit={handleLogin}>
                  <div className="mb-3">
                    <input
                      type="email"
                      className="form-control"
                      placeholder="Email"
                      value={email}
                      onChange={(e) => setEmail(e.target.value)}
                      required
                      style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)', border: '1px solid rgba(0, 0, 0, 0.1)' }}
                    />
                  </div>
                  <div className="mb-3">
                    <input
                      type="password"
                      className="form-control"
                      placeholder="Password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      required
                      style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)', border: '1px solid rgba(0, 0, 0, 0.1)' }}
                    />
                  </div>
                  {/* CAPTCHA Component */}
                  <div className="mb-3">
                    <ReCAPTCHA
                      ref={captchaRef}
                      sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI" // Replace with your reCAPTCHA site key
                      onChange={handleCaptchaChange}
                    />
                  </div>
                  <div className="d-grid">
                    <button
                      type="submit"
                      className="btn btn-primary"
                      style={{ backgroundColor: 'rgba(0, 123, 255, 0.8)', border: 'none' }}
                    >
                      Login
                    </button>
                  </div>
                  {/* Forgot Password Link */}
                  <div className="text-center mt-3">
                    <a
                      href="#"
                      onClick={handleForgotPassword}
                      style={{ textDecoration: 'none', color: '#000' }}
                    >
                      Forgot Password?
                    </a>
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

export default Login;