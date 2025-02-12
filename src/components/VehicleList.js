import React, { useEffect, useState } from 'react';
import axios from 'axios';
import DefenderImage from '../Photos/mcc.jpg'; // Import the background image

const VehicleList = () => {
  const [vehicles, setVehicles] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newVehicle, setNewVehicle] = useState({
    make: '',
    model: '',
    year: '',
    color: '',
    dailyRate: '',
    available: true,
  });

  useEffect(() => {
    const fetchVehicles = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/vehicles');
        const data = Array.isArray(response.data) ? response.data : [];
        setVehicles(data);
      } catch (error) {
        console.error('Failed to fetch vehicles', error);
      }
    };

    fetchVehicles();
  }, []);

  const fetchAvailableVehicles = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/vehicles/available');
      const data = Array.isArray(response.data) ? response.data : [];
      setVehicles(data);
    } catch (error) {
      console.error('Failed to fetch available vehicles', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewVehicle({ ...newVehicle, [name]: value });
  };

  const handleAddVehicle = async (e) => {
    e.preventDefault();
    try {
      console.log(newVehicle);
      const response = await axios.post('http://localhost:8080/api/vehicles', newVehicle);
      setVehicles((prevVehicles) => [...prevVehicles, response.data]);
      setShowForm(false);
      setNewVehicle({
        make: '',
        model: '',
        year: '',
        color: '',
        dailyRate: '',
        available: true,
      });
    } catch (error) {
      console.error('Failed to add vehicle', error);
    }
  };

  // Delete Vehicle Functionality
  const handleDeleteVehicle = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/vehicles/${id}`);
      setVehicles((prevVehicles) => prevVehicles.filter((vehicle) => vehicle.id !== id));
    } catch (error) {
      console.error('Failed to delete vehicle', error);
    }
  };

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
      <div
        style={{
          backgroundColor: 'rgba(255, 255, 255, 0.8)', // Adds a semi-transparent white background
          padding: '20px',
          borderRadius: '10px', // Rounded corners
          maxWidth: '1200px', // Limits the width of the content
          margin: '0 auto', // Centers the content horizontally
        }}
      >
        <h2>Available Vehicles</h2>

        {/* Table to display vehicles */}
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Make</th>
              <th>Model</th>
              <th>Year</th>
              <th>Color</th>
              <th>Daily Rate</th>
              <th>Availability</th>
              <th>Action</th> {/* New column for delete button */}
            </tr>
          </thead>
          <tbody>
            {Array.isArray(vehicles) && vehicles.length > 0 ? (
              vehicles.map((vehicle) => (
                <tr key={vehicle.id}>
                  <td>{vehicle.make}</td>
                  <td>{vehicle.model}</td>
                  <td>{vehicle.year}</td>
                  <td>{vehicle.color}</td>
                  <td>${vehicle.dailyRate}/day</td>
                  <td>{vehicle.available ? 'Available' : 'Not Available'}</td>
                  <td>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDeleteVehicle(vehicle.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="7" className="text-center">No vehicles available</td>
              </tr>
            )}
          </tbody>
        </table>

        <button className="btn btn-primary mb-3" onClick={() => setShowForm(!showForm)}>
          {showForm ? 'Cancel' : 'Add Vehicle'}
        </button>
        <button className="btn btn-secondary mb-3 ms-3" onClick={fetchAvailableVehicles}>
          Fetch Available Vehicles
        </button>

        {showForm && (
          <div className="card p-3">
            <h3>Add New Vehicle</h3>
            <form onSubmit={handleAddVehicle}>
              <div className="mb-3">
                <input
                  type="text"
                  name="make"
                  className="form-control"
                  placeholder="Make"
                  value={newVehicle.make}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <input
                  type="text"
                  name="model"
                  className="form-control"
                  placeholder="Model"
                  value={newVehicle.model}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <input
                  type="number"
                  name="year"
                  className="form-control"
                  placeholder="Year"
                  value={newVehicle.year}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <input
                  type="text"
                  name="color"
                  className="form-control"
                  placeholder="Color"
                  value={newVehicle.color}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <input
                  type="number"
                  name="dailyRate"
                  className="form-control"
                  placeholder="Daily Rate"
                  value={newVehicle.dailyRate}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <label>
                  <input
                    type="checkbox"
                    name="available"
                    checked={newVehicle.available}
                    onChange={(e) =>
                      setNewVehicle({ ...newVehicle, available: e.target.checked })
                    }
                  />{' '}
                  Available
                </label>
              </div>
              <button type="submit" className="btn btn-success">
                Add Vehicle
              </button>
            </form>
          </div>
        )}
      </div>
    </div>
  );
};

export default VehicleList;