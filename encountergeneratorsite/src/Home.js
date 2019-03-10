import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Navbar from './Navbar';

class Home extends Component {
  render() {
    return (
      <div className="App">
          <p>Welcome to the encoutner generator, \n 
            please select what table you wish to view, or select random encoutner</p>
      </div>
    );
  }
}

export default Home;
