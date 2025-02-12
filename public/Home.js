import React, { useEffect, useState } from 'react';
import { Carousel, Card, Button, Container, Row, Col } from 'react-bootstrap';
import './Home.css'; // Custom CSS for animations

const Home = () => {
  const [vehicles, setVehicles] = useState([]);

  // Mock data for available vehicles
  useEffect(() => {
    const mockVehicles = [
      {
        id: 1,
        name: 'Sedan',
        image: "verna.jpg",
        description: 'Comfortable and affordable rides for everyday travel.',
      },
      {
        id: 2,
        name: 'SUV',
        image: "thar.jpg",
        description: 'Spacious and perfect for family trips.',
      },
      {
        id: 3,
        name: 'Luxury',
        image: "amg.jpg",
        description: 'Premium rides for a luxurious experience.',
      },
      {
        id: 4,
        name: 'Bike',
        image: 'https://via.placeholder.com/300x200',
        description: 'Quick and eco-friendly rides for short distances.',
      },
    ];
    setVehicles(mockVehicles);
  }, []);

  return (
    <div>
      {/* Hero Section */}
      <div className="hero-section text-center">
        <div className="hero-overlay">
          <h1 className="display-4">Book Your Ride Now</h1>
          <p className="lead">Affordable, reliable, and comfortable rides at your fingertips.</p>
          <Button variant="primary" size="lg">
            Get Started
          </Button>
        </div>
      </div>

      {/* Moving Cards Section */}
      <Container className="my-5">
        <h2 className="text-center mb-4">Available Vehicles</h2>
        <Row>
          {vehicles.map((vehicle) => (
            <Col key={vehicle.id} md={4} className="mb-4">
              <Card className="moving-card">
                <Card.Img variant="top" src={vehicle.image}  />
                <Card.Body>
                  <Card.Title>{vehicle.name}</Card.Title>
                  <Card.Text>{vehicle.description}</Card.Text>
                  <Button variant="primary">Book Now</Button>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      </Container>

      {/* Carousel Section */}
      <Carousel className="my-5">
        {vehicles.map((vehicle) => (
          <Carousel.Item key={vehicle.id}>
            <img
              className="d-block w-100"
              src={vehicle.image}
              alt={vehicle.name}
            />
            <Carousel.Caption>
              <h3>{vehicle.name}</h3>
              <p>{vehicle.description}</p>
            </Carousel.Caption>
          </Carousel.Item>
        ))}
      </Carousel>
    </div>
  );
};

export default Home;