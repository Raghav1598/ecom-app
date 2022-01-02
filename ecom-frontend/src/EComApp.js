import React from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import LoginPage from "./Signup/LoginPage";
import Home from "./webpage/Home";
import Header from "./customs/Header";
import Footer from "./customs/Footer";

function EComApp(){
    return (
        <div>
            <Router>
                <Header/>
                <Routes>
                    <Route path="/" exact element={<Home/>}/>
                    <Route path="/login" element={<LoginPage/>}/>
                    {
                        //<AuthenticatedRoute path="/logout" component=LoginPage/>
                    }
                    <Route component={ErrorComponent}/>
                </Routes>
                <Footer/>
            </Router>
        </div>
    )
}

function ErrorComponent() {
    return (<div>An Error Occured.</div>);
}

export default EComApp;