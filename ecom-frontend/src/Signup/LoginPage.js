import React, {useState} from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import validator from 'validator';
import LoginService from "../services/LoginService";
import './LoginPage.css'

function LoginPage() {

    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');

    function validate(){
      if(validator.isEmail(email)){
        return password.length>8;
      }
      return false;
    }

    function authenticate(){
      LoginService.loginHandler(email).then(response => handleResponse(response));
    }

    function handleResponse(response){
      let expectedPassword = response.data.password;
      if(expectedPassword === password){
        
      }else console.log(password);
    }

    return (
        <Container className="center">
          <Row>
            <Col>
          <Form onSubmit={(e) => e.preventDefault()}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)}/>
              <Form.Text>*Please enter valid Email-Address to enable Submit Button.*</Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
              <Form.Text>*The Password Should be eight characters long.*</Form.Text>
            </Form.Group>
            <Button variant="primary" type="submit" disabled={!validate()} onClick={authenticate}>Submit</Button>
          </Form>
          </Col>
          </Row>
        </Container>
    );
}

export default LoginPage;