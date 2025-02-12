import React, { useEffect, useState } from 'react';
import { Carousel, Card, Button, Container, Row, Col } from 'react-bootstrap';
import './Home.css'; // Custom CSS for animations
import FortunerImage from '../Photos/Fortuner.jpg'; // Import the specific image

const Home = () => {
  const [vehicles, setVehicles] = useState([]);

  // Mock data for available vehicles
  useEffect(() => {
    const mockVehicles = [
      {
        id: 1,
        name: 'Sedan',
        image: "./images/verna.jpg",
        description: 'Comfortable and affordable rides for everyday travel.',
      },
      {
        id: 2,
        name: 'SUV',
        image: "./images/thar.jpg",
        description: 'Spacious and perfect for family trips.',
        /*description: 'Range : $1000-$1500',*/
      },
      {
        id: 3,
        name: 'Luxury',
        image: "./images/amg.jpg",
        description: 'Premium rides for a luxurious experience.',
      },
      {
        id: 4,
        name: 'Bike',
        image: "./images/bullet.jpg",
        description: 'Quick and eco-friendly rides for short distances.',
      },
    ];
    setVehicles(mockVehicles);
  }, []);

  return (
    <div>
      {/* Hero Section with Parallax Scrolling Effect */}
      <div
        className="hero-section text-center"
        style={{
          backgroundImage: `url(${FortunerImage})`,
          backgroundSize: 'cover',
          backgroundPosition: 'center',
          height: '100vh', // Full viewport height
          backgroundAttachment: 'fixed', // Enables parallax effect
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
        }}
      >
        <div className="hero-overlay" style={{ backgroundColor: 'rgba(0, 0, 0, 0.5)', padding: '20px', borderRadius: '10px' }}>
          <h1 className="display-4 text-white">Book Your Ride Now</h1>
          <p className="lead text-white">Affordable, reliable, and comfortable rides at your fingertips.</p>
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
            <Col key={vehicle.id} md={3} className="mb-4"> {/* Adjusted to md={3} for 4 cards in a row */}
              <Card className="moving-card h-100"> {/* Added h-100 to make cards equal height */}
                <Card.Img
                  variant="top"
                  src={vehicle.image}
                  className="card-img-top" // Added class for custom styling
                  style={{ height: '200px', objectFit: 'cover' }} // Set fixed height and cover
                />
                <Card.Body className="d-flex flex-column"> {/* Flexbox for proper alignment */}
                  <Card.Title>{vehicle.name}</Card.Title>
                  <Card.Text>{vehicle.description}</Card.Text>
                  <Button variant="primary" className="mt-auto"> {/* Pushes button to the bottom */}
                    Book Now
                  </Button>
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
              style={{ height: '500px',width:'250px', objectFit: 'scale-down' }} // Set fixed height for carousel images
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