import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Navbar from './Navbar';

class App extends Component {
  render() {
    return (
      <div>
      <header>
      <div className="App">
      <Navbar/>
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a>
            Learn React
          </a>
      </div>
      </header>
      <article>

      </article>
      </div>
    );
  }
}

export default App;
