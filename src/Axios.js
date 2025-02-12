import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const login = async (email, password) => {
  return axios.post(`${API_BASE_URL}/customer/login`, { email, password });
};

export const register = async (name, email, password) => {
  return axios.post(`${API_BASE_URL}/register`, { name, email, password });
};

export const getUser = async (token) => {
  return axios.get(`${API_BASE_URL}/user`, {
    headers: { Authorization: `Bearer ${token}` }
  });
};