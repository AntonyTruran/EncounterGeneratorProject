import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class Biomes extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: '',
      biomeRef: '',
      biomeName: ''
    }
    this.getBiomes = this.getBiomes.bind(this);
    this.update = this.create.bind(this);
    this.update = this.update.bind(this);
    this.delete = this.delete.bind(this);
    this.setBiomeRef = this.setBiomeRef.bind(this);
    this.setBiomeName = this.setBiomeName.bind(this);
  }
  create = (e) => {
    axios.post('http://localhost:8080/EncounterGenerator/api/biome/newBiome', {
      "biomeReference": document.getElementById('reference').value,
      "biomeName": document.getElementById('name').value
    }).then(response => {
      console.log(response.data);
      this.setState({
        result: response.data
      });
      let createResult = JSON.stringify(response.data);
      createResult = createResult.replace(/\[/g, " ");
      createResult = createResult.replace(/]/g, "</br> ");
      createResult = createResult.replace(/{/g, " <div>");
      createResult = createResult.replace(/}/g, " </div>");
      createResult = createResult.replace(/\"/g, "");
      createResult = createResult.replace(/,/g, " ");
      createResult = createResult.replace(/\\/g, "");

      document.getElementById('result').innerHTML = createResult;
    });
  }
  delete = (e) => {
    console.log("START DELETE");
    alert("are you sure you wish to delete this biome?");
    axios.delete('http://localhost:8080/EncounterGenerator/api/biome/removeBiome/' + this.state.biomeRef).then(response => {
      console.log(response.data);
      this.setState({
        result: response.data
      });
      let deleteResult = JSON.stringify(response.data);
      deleteResult = deleteResult.replace(/\[/g, " ");
      deleteResult = deleteResult.replace(/]/g, "</br> ");
      deleteResult = deleteResult.replace(/{/g, " <div>");
      deleteResult = deleteResult.replace(/}/g, " </div>");
      deleteResult = deleteResult.replace(/\"/g, "");
      deleteResult = deleteResult.replace(/,/g, " ");
      deleteResult = deleteResult.replace(/\\/g, "");

      document.getElementById('result').innerHTML = deleteResult;
    });
  }
  update = (e) => {
    axios.put('http://localhost:8080/EncounterGenerator/api/biome/updateBiome/'.this.state.biomeRef, {
      "biomeReference": document.getElementById('reference').value,
      "biomeName": document.getElementById('name').value
    }).then(response => {
      console.log(response.data);
      this.setState({
        result: response.data
      });
      let updateResult = JSON.stringify(response.data);
      updateResult = updateResult.replace(/\[/g, " ");
      updateResult = updateResult.replace(/]/g, "</br> ");
      updateResult = updateResult.replace(/{/g, " <div>");
      updateResult = updateResult.replace(/}/g, " </div>");
      updateResult = updateResult.replace(/\"/g, "");
      updateResult = updateResult.replace(/,/g, " ");
      updateResult = updateResult.replace(/\\/g, "");

      document.getElementById('result').innerHTML = updateResult;
    });
  }
  getBiomes = (e) => {
    axios.get('http://localhost:8080/EncounterGenerator/api/biome/getAllBiomes').then(response => {
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
  setBiomeRef(event) {
    this.setState({ biomeRef: event.target.value });
    event.preventDefault();
  }
  setBiomeName(event) {
    this.setState({ biomeName: event.target.value });
    event.preventDefault();
  }
  render() {
    return (
      <article>
        <br></br>
        <h1>Biomes Table</h1>
        <p>enter the information you wish to use for updating creating or deleting a biome</p>
        <input type="text" id="reference" value={this.state.value} onChange={this.setBiomeRef} />
        <input type="text" id="name" value={this.state.value} onChange={this.setBiomeName} />
        <input type="button" id="create" value="create biome" onClick={this.create}></input>
        <input type="button" id="delete" value="delete biome" onClick={this.delete}></input>
        <input type="button" id="update" value="update biome" onClick={this.update}></input>
        <p id='result'> </p>
        <br></br>
        <input type="button" id="randomise" value="show all" onClick={this.getBiomes}></input>
        <p id='biomes'></p>
      </article >
    );
  }
}

export default Biomes;
