import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Home extends Component {
  render() {
    return (
      <article className="App">
        <h1>Encounter Generator</h1>
        <p>Welcome to the encounter generator, for this program select the page you wish to use.</p>
        <br></br>
        <p>to randomise an encounter go onto the randomise tab enter the reference to the chart you wish to view and then press the randomsie button</p>
        <br></br>
        <p>to work on the creature table go onto the creature tab, use the form to edit, update or delete creatures and the buttons to search the preset options</p>
        <br></br>
        <p>to work on the biome table go onto the creature tab, use the form to edit, update or delete biomes use get all to show all biomes</p>
        <br></br>
        <p>to work on the encounter charts table go onto the creature tab, use the form to edit, update or delete creatures and the buttons to search the preset options</p>
      </article>
    );
  }
}

export default Home;