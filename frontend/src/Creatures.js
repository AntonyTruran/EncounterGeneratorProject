import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class Creatures extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: '',
      creatureName: '',
      challengeRating: '',
      type: '',
      enviroment: '',
      climate: '',
      alignment: '',
      combatRole: ''
    }
    this.searchByName = this.searchByName.bind(this);
    this.searchByType = this.searchByType.bind(this);
    this.searchByEnvironment = this.searchByEnvironment.bind(this);
    this.searchByClimate = this.searchByClimate.bind(this);
    this.searchByAlignment = this.searchByAlignment.bind(this);
    this.searchByCombatRole = this.searchByCombatRole.bind(this);
    this.create = this.create.bind(this);
    this.update = this.update.bind(this);
    this.delete = this.delete.bind(this);
    this.setName = this.setName.bind(this);
    this.setCreatureName = this.setCreatureName.bind(this);
    this.setChallengeRating = this.setChallengeRating.bind(this)
    this.setType = this.setType.bind(this);
    this.setEnvironment = this.setEnvironment.bind(this);
    this.setClimate = this.setClimate.bind(this);
    this.setAlignment = this.setAlignment.bind(this);
    this.setCombatRole = this.setCombatRole.bind(this);
  }
  update = (e) => {
    axios.put('http://35.189.103.145:8888/EncounterGenerator/api/creature/updateCreature/' + this.state.creatureName, {
      "creatureName": document.getElementById('newName').value,
      "challengeRating": document.getElementById('cr').value,
      "type": document.getElementById('newType').value,
      "enviroment": document.getElementById('newEnviroment').value,
      "climate": document.getElementById('newClimate').value,
      "alignment": document.getElementById('newAlignment').value,
      "role": document.getElementById('newRole').value
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
    axios.post('http://35.189.103.145:8888/EncounterGenerator/api/creature/createCreature', {
      "creatureName": document.getElementById('newName').value,
      "challengeRating": document.getElementById('cr').value,
      "type": document.getElementById('newType').value,
      "environment": document.getElementById('newEnviroment').value,
      "climate": document.getElementById('newClimate').value,
      "alignment": document.getElementById('newAlignment').value,
      "combatRole": document.getElementById('newRole').value
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
    axios.delete('http://35.189.103.145:8888/EncounterGenerator/api/creature/deleteCreature/' + this.state.creatureName).then(response => {
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

      document.getElementById('creaturesByName').innerHTML = nameList;
    });
  }
  searchByType = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByType/' + this.state.type).then(response => {
      console.log(response.Data);
      this.setState({
        byType: response.data
      });
      let typeList = JSON.stringify(response.data);
      typeList = typeList.replace(/\[/g, " ");
      typeList = typeList.replace(/]/g, "</br> ");
      typeList = typeList.replace(/{/g, " <div>");
      typeList = typeList.replace(/}/g, " </div>");
      typeList = typeList.replace(/\"/g, "");
      typeList = typeList.replace(/,/g, " ");
      typeList = typeList.replace(/\\/g, "");
      document.getElementById('creaturesByType').innerHTML = typeList;
    });
  }
  searchByEnvironment = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByEnviroment/' + this.state.enviroment).then(response => {
      console.log(response.Data);
      this.setState({
        byEnvironment: response.data
      });
      let environmentList = JSON.stringify(response.data);
      environmentList = environmentList.replace(/\[/g, " ");
      environmentList = environmentList.replace(/]/g, "</br> ");
      environmentList = environmentList.replace(/{/g, " <div>");
      environmentList = environmentList.replace(/}/g, " </div>");
      environmentList = environmentList.replace(/\"/g, "");
      environmentList = environmentList.replace(/,/g, " ");
      environmentList = environmentList.replace(/\\/g, "");
      document.getElementById('creaturesByEnvironment').innerHTML = environmentList;
    });
  }
  searchByClimate = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByClimate/' + this.state.climate).then(response => {
      console.log(response.Data);
      this.setState({
        byClimates: response.data
      });
      let climateList = JSON.stringify(response.data);
      climateList = climateList.replace(/\[/g, " ");
      climateList = climateList.replace(/]/g, "</br> ");
      climateList = climateList.replace(/{/g, " <div>");
      climateList = climateList.replace(/}/g, " </div>");
      climateList = climateList.replace(/\"/g, "");
      climateList = climateList.replace(/,/g, " ");
      climateList = climateList.replace(/\\/g, "");
      document.getElementById('creaturesByClimate').innerHTML = climateList;
    });
  }
  searchByAlignment = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByAlignment/' + this.state.alignment).then(response => {
      console.log(response.Data);
      this.setState({
        byAlignment: response.data
      });
      let alignmentList = JSON.stringify(response.data);
      alignmentList = alignmentList.replace(/\[/g, " ");
      alignmentList = alignmentList.replace(/]/g, "</br> ");
      alignmentList = alignmentList.replace(/{/g, " <div>");
      alignmentList = alignmentList.replace(/}/g, " </div>");
      alignmentList = alignmentList.replace(/\"/g, "");
      alignmentList = alignmentList.replace(/,/g, " ");
      alignmentList = alignmentList.replace(/\\/g, "");
      document.getElementById('creaturesByAlignment').innerHTML = alignmentList;
    });
  }
  searchByCombatRole = (e) => {
    axios.get('http://35.189.103.145:8888/EncounterGenerator/api/creature/searchByRole/' + this.state.combatRole).then(response => {
      console.log(response.Data);
      this.setState({
        byRole: response.data
      });
      let roleList = JSON.stringify(response.data);
      roleList = roleList.replace(/\[/g, " ");
      roleList = roleList.replace(/]/g, "</br> ");
      roleList = roleList.replace(/{/g, " <div>");
      roleList = roleList.replace(/}/g, " </div>");
      roleList = roleList.replace(/\"/g, "");
      roleList = roleList.replace(/,/g, " ");
      roleList = roleList.replace(/\\/g, "");
      document.getElementById('creaturesByRole').innerHTML = roleList;
    });
  }
  setName(event) {
    this.setState({ creatureName: event.target.value });
    event.preventDefault();
  }
  setCreatureName(event) {
    this.setState({ creatureName: event.target.value });
    event.preventDefault();
  }
  setChallengeRating(event) {
    this.setState({ challengeRating: event.target.value });
    event.preventDefault();
  }
  setType(event) {
    this.setState({ type: event.target.value });
    event.preventDefault();
  }
  setEnvironment(event) {
    this.setState({ enviroment: event.target.value });
    event.preventDefault();
  }
  setClimate(event) {
    this.setState({ climate: event.target.value });
    event.preventDefault();
  }
  setAlignment(event) {
    this.setState({ alignment: event.target.value });
    event.preventDefault();
  }
  setCombatRole(event) {
    this.setState({ combatRole: event.target.value });
    event.preventDefault();
  }
  render() {
    return (
      <article className="App">
        <div>
          <h1>CREATURES</h1>
          <p>use the following text boxes to create new creatures, all entries need to be filled out</p>
        </div>
        <div id="modify">
          <input type="text" id="newName" placeholder="enter name" value={this.state.value} onChange={this.setCreatureName} />
          <input type="text" id="cr" placeholder="enter challenge rating" value={this.state.value} onChange={this.setChallengeRating} />
          <input type="text" id="newType" placeholder="enter type" value={this.state.value} onChange={this.setType} />
          <input type="text" id="newEnviroment" placeholder="enter environment" value={this.state.value} onChange={this.setEnvironment} />
          <input type="text" id="newClimate" placeholder="enter climate" value={this.state.value} onChange={this.setClimate} />
          <input type="text" id="newAlignment" placeholder="enter alignment" value={this.state.value} onChange={this.setAlignment} />
          <input type="text" id="newRole" placeholder="enter combat role" value={this.state.value} onChange={this.setCombatRole} />
          <br></br>
          <input type="button" id="create" value="create creature" onClick={this.create}></input>
          <input type="button" id="delete" value="delete creature" onClick={this.delete}></input>
          <input type="button" id="update" value="update creature" onClick={this.update}></input>
          <p id="result"></p>
        </div>
        <div id="name">
          <h2>Search by name</h2>
          <p>Please enter the creature name you wish to search for in lowercase</p>
          <br></br>
          <input type="text" id="creature" placeholder="enter name" value={this.state.value} onChange={this.setName} />
          <input type="button" id="nameSearch" value="searchByName" onClick={this.searchByName}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByName"></p>
        </div>
        <div id="type">
          <h2>Search by type</h2>
          <p>Please enter the creature type you wish to search for (abberation, animal, construct, dragon, fey, humanoid, magical beast, monstrous humanoid, ooze, outsider,plant, undead, vermin)</p>
          <br></br>
          <input type="text" id="chosentype" placeholder="choose environment" value={this.state.value} onChange={this.setType} />
          <input type="button" id="environmentSearch" value="searchByType" onClick={this.searchByType}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByType"></p>
        </div>
        <div id="environment">
          <h2>Search by enviroment</h2>
          <p>Please enter the environment you wish to search for (desert, forest-jungle, hill, mountain, plain, ruins, sky, swamp, underground, urban, water)</p>
          <br></br>
          <input type="text" id="chosenEnvironment" placeholder="choose environment" value={this.state.value} onChange={this.setEnvironment} />
          <input type="button" id="environmentSearch" value="searchByenvironment" onClick={this.searchByEnvironment}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByEnvironment"></p>
        </div>
        <div id="climate">
          <h2>Search by Climate</h2>
          <p>Please enter the climate you wish to search for (cold, extraplanar, temperate, tropical)</p>
          <br></br>
          <input type="text" id="chosenClimate" placeholder="choose climate" value={this.state.value} onChange={this.setClimate} />
          <input type="button" id="climateSearch" value="searchByClimate" onClick={this.searchByClimate}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByClimate"></p>
        </div>
        <div id="alignment">
          <h2>Search by Alignment</h2>
          <p>Please enter the alignment you wish to search for (LG, NG, CG, LN, NN, CN, LE, NE, CE)</p>
          <br></br>
          <input type="text" id="chosenAlignment" placeholder="choose role" value={this.state.value} onChange={this.setAlignment} />
          <input type="button" id="alignmentSearch" value="searchByAlignment" onClick={this.searchByAlignment}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByAlignment"></p>
        </div>
        <div id="role">
          <h2>Search by combat role</h2>
          <p>Please enter the combat role you wish to search for ()</p>
          <br></br>
          <input type="text" id="chosenRole" placeholder="choose role" value={this.state.value} onChange={this.setCombatRole} />
          <input type="button" id="roleSearch" value="searchByCombatRole" onClick={this.searchByCombatRole}></input>
          <p>creature name, cr, type, environment, climate, alignment, combat role</p>
          <p id="creaturesByRole"></p>
        </div>
      </article>
    );
  }
}
export default Creatures;