import React, {useState} from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import validator from 'validator';
import LoginService from "../services/LoginService";
import {Link} from "react-router-dom";
import './LoginPage.css';

function SignUpPage(){

    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');
    const[contact, setContact] = useState('');
    const[username, setUsername] = useState('');

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
          alert("Successful Login!");   
        } else {
          alert("Wrong User Credentials!")
        }
    }

    return(
        <Container className="center">
          <Row>
            <Col>
          <Form onSubmit={(e) => e.preventDefault()}>
            <Form.Group className="mb-3" controlId="formBasicUsername">
              <Form.Label className="required-field">Username</Form.Label>
              <Form.Control type="text" placeholder="Enter username" value={username} onChange={(e) => setUsername(e.target.value)}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label className="required-field">Email address</Form.Label>
              <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label className="required-field">Password</Form.Label>
              <Form.Control type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label className="required-field">Contact Number</Form.Label>
              <Form.Control type="text" placeholder="9999999999" value={contact} onChange={(e) => setContact(e.target.value)}/>
            </Form.Group>
            <Form.Group>
                <Form.Text>* marked fields are necessary</Form.Text>
            </Form.Group>
            <Button variant="primary" type="submit" disabled={!validate()} onClick={authenticate}>Submit</Button>
            <Form.Group className="mb-3" controlId="formBasicSignUp">
              <Form.Label>Already Registered? <Link to="/login">Login</Link></Form.Label>
            </Form.Group>
          </Form>
          </Col>
          </Row>
        </Container>
    );
}

export default SignUpPage;