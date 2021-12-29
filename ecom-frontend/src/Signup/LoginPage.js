import React, {useState} from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import validator from 'validator';
import './LoginPage.css'

function LoginPage() {

    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');

    function validate(){
      if(validator.isEmail(email)){
        return password.length>0;
      }
      return false;
    }

    return (
        <Container className="center">
          <Row>
            <Col>
          <Form>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
            </Form.Group>
            <Button variant="primary" type="submit" disabled={!validate()}>Submit</Button>
          </Form>
          </Col>
          </Row>
        </Container>
    );
}

export default LoginPage;