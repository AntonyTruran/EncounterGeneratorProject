import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { BrowserRouter as Router, Route, NavLink } from "react-router-dom";

class RandomEncounter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      biome: '',
      data: ''
    }
    this.tableData = this.tableData.bind(this);
    this.setBiome = this.setBiome.bind(this);
    this.getBiomes = this.getBiomes.bind(this);
  }
  getBiomes = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/biome/getAllBiomes').then(response => {
      console.log(response.Data);
      this.setState({
        biomes: response.data
      });
      let biomeList = JSON.stringify(response.data);
      biomeList = biomeList.replace(/\[/g, " ");
      biomeList = biomeList.replace(/]/g, "</br> ");
      biomeList = biomeList.replace(/{/g, " <div>");
      biomeList = biomeList.replace(/}/g, " </div>");
      biomeList = biomeList.replace(/\"/g, "");
      biomeList = biomeList.replace(/,/g, " ");
      biomeList = biomeList.replace(/\\/g, "");

      document.getElementById('biomes').innerHTML = biomeList;
    });
  }

  tableData = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/randomCreature/' + this.state.biome).then(response => {
      console.log(response.data);
      this.setState({
        data: response.data
      });
      let wordnice = JSON.stringify(response.data);
      wordnice = wordnice.replace(/\[/g, " ");
      wordnice = wordnice.replace(/]/g, "</br> ");
      wordnice = wordnice.replace(/{/g, " <div>");
      wordnice = wordnice.replace(/}/g, " </div>");
      wordnice = wordnice.replace(/\"/g, "");
      wordnice = wordnice.replace(/,/g, ", ");
      wordnice = wordnice.replace(/\\/g, "");
      document.getElementById('random').innerHTML = wordnice;
    });
  }
  setBiome(event) {
    this.setState({ biome: event.target.value });
    event.preventDefault();
  }
  render() {
    return (
      <article>
        <br></br>
        <h1>Encounter Randomiser</h1>
        <p>enter the biome Reference for the chart you wish to use, click on the show button to display the list of current biomes</p>
        <input type="text" value={this.state.value} onChange={this.setBiome} />
        <input type="button" id="randomise" value="randomise" onClick={this.tableData}></input>
        <p>creature name, cr, type, environment, climate, alignment, combat role</p>
        <p id='random'> </p>
        <br></br>
        <input type="button" id="randomise" value="show" onClick={this.getBiomes}></input>
        <p>biome reference, biome name</p>
        <p id='biomes'></p>
      </article>
    );
  }
}
export default RandomEncounter;