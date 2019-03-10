import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class EncounterCharts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: '',
      entryId: '',
      creatureName: '',
      biome: '',
      entryId: '',
      monsterKey: '',
      biomeKey: '',
      number: '',
      maxChance: '',
      minChance: ''
    }
    this.searchByName = this.searchByName.bind(this);
    this.searchByChart = this.searchByChart.bind(this);
    this.getBiomes = this.getBiomes.bind(this);
    this.setName = this.setName.bind(this);
    this.setBiome = this.setBiome.bind(this);
    this.create = this.create.bind(this);
    this.update = this.update.bind(this);
    this.delete = this.delete.bind(this);
    this.setEntryId = this.setEntryId.bind(this);
    this.setMonsterKey = this.setName.bind(this);
    this.setBiomeKey = this.setBiomeKey.bind(this);
    this.setNumber = this.setNumber.bind(this);
    this.setMaxChance = this.setMaxChance.bind(this);
    this.setMinChance = this.setMinChance.bind(this);
  }


  searchByChart = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/encounterCharts/getContentByChart/' + this.state.biome).then(response => {
      console.log(response.Data);
      this.setState({
        byName: response.data
      });
      let nameList = JSON.stringify(response.data);
      nameList = nameList.replace(/\[/g, " ");
      nameList = nameList.replace(/]/g, "</br> ");
      nameList = nameList.replace(/{/g, " <div>");
      nameList = nameList.replace(/}/g, " </div>");
      nameList = nameList.replace(/\"/g, "");
      nameList = nameList.replace(/,/g, " ");
      nameList = nameList.replace(/\\/g, "");

      document.getElementById('byChart').innerHTML = nameList;
    });
  }
  update = (e) => {
    axios.put('http://35.189.103.145:8888/EncounterGenerator/api/encounterCharts/updateChartEntry/' + this.state.entryId, {
      "monsterKey": document.getElementById('monsterKey').value,
      "biomeKey": document.getElementById('biomeKey').value,
      "number": document.getElementById('newNumber').value,
      "maxChance": document.getElementById('newMaxChance').value,
      "minChance": document.getElementById('newMinChance').value
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
  create = (e) => {
    axios.post('http://35.189.103.145:8888/EncounterGenerator/api/encounterCharts/newEncounterChart', {
      "monsterKey": document.getElementById('monsterKey').value,
      "biomeKey": document.getElementById('biomeKey').value,
      "number": document.getElementById('newNumber').value,
      "maxChance": document.getElementById('newMaxChance').value,
      "minChance": document.getElementById('newMinChance').value
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
    alert("are you sure you wish to delete this creature?");
    axios.delete('http://35.189.103.145:8888/EncounterGenerator/api/encounterCharts/removeEncounterChart/' + this.state.entryId).then(response => {
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
  searchByName = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByName/' + this.state.creatureName).then(response => {
      console.log(response.Data);
      this.setState({
        byName: response.data
      });
      let nameList = JSON.stringify(response.data);
      nameList = nameList.replace(/\[/g, " ");
      nameList = nameList.replace(/]/g, "</br> ");
      nameList = nameList.replace(/{/g, " <div>");
      nameList = nameList.replace(/}/g, " </div>");
      nameList = nameList.replace(/\"/g, "");
      nameList = nameList.replace(/,/g, " ");
      nameList = nameList.replace(/\\/g, "");

      document.getElementById('creatures').innerHTML = nameList;
    });
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
  setName(event) {
    this.setState({ creatureName: event.target.value });
    event.preventDefault();
  }
  setBiome(event) {
    this.setState({ biome: event.target.value });
    event.preventDefault();
  }
  setEntryId(event) {
    this.setState({ entryId: event.target.value })
    event.preventDefault();
  }
  setMonsterKey(event) {
    this.setState({ monsterKey: event.target.value });
    event.preventDefault();
  }
  setBiomeKey(event) {
    this.setState({ biomeKey: event.target.value });
    event.preventDefault();
  }
  setNumber(event) {
    this.setState({ number: event.target.value });
    event.preventDefault();
  }
  setMaxChance(event) {
    this.setState({ maxChance: event.target.value });
    event.preventDefault();
  }
  setMinChance(event) {
    this.setState({ minChance: event.target.value });
    event.preventDefault();
  }
  render() {
    return (
      <article className="App">
        <div>
        <h1>Encounter Charts</h1>
        <p>enter the information you wish to use for updating creating or deleting encounter chart entries</p>
        </div>
        <div id="modify">
          <input type="text" id="entryId" placeholder="enter chart entry id for delete+update" value={this.state.value} onChange={this.setEntryId} />
          <input type="text" id="monsterKey" placeholder="enter creature name" value={this.state.value} onChange={this.setMonsterKey} />
          <input type="text" id="biomeKey" placeholder="enter desired biome reference" value={this.state.value} onChange={this.setBiomeKey} />
          <input type="text" id="newNumber" placeholder="enter the number of monsters (as a number or *d4, *d6 *d8" value={this.state.value} onChange={this.setNumber} />
          <input type="text" id="newMaxChance" placeholder="enter enter the maximum roll for generating this creature (out of 100)" value={this.state.value} onChange={this.setMaxChance} />
          <input type="text" id="newMinChance" placeholder="enter enter the minimum roll for generating this creature (out of 100)" value={this.state.value} onChange={this.setMinChance} />
          <br></br>
          <input type="button" id="create" value="create chart entry" onClick={this.create}></input>
          <input type="button" id="delete" value="delete chart entry" onClick={this.delete}></input>
          <input type="button" id="update" value="update chart entry" onClick={this.update}></input>
          <p id="result"></p>
        </div>
        <div>

        </div>
        <div>
          <h2>show Encounter Charts</h2>
          <input type="text" id="biomeKey" placeholder="enter the key for the chart you wish to view" value={this.state.value} onChange={this.setBiome} />
          <input type="button" id="searchByChart" value="searchByChart" onClick={this.searchByChart}></input>
          <p id="byChart"></p>
        </div>
        <div>
          <h2>Search by name</h2>
          <p>Please enter the creature name you wish to search for in lowercase</p>
          <br></br>
          <input type="text" id="creature" placeholder="enter creature name" value={this.state.value} onChange={this.setName} />
          <input type="button" id="nameSearch" value="search for creature name" onClick={this.searchByName}></input>
          <input type="button" id="randomise" value="show biomes" onClick={this.getBiomes}></input>
          <table>
            <thead>
              <tr>
                <td>biomes</td>
                <td>show creature</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td id="biomes"></td>
                <td id="creatures"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </article>
    );
  }
}

export default EncounterCharts;
