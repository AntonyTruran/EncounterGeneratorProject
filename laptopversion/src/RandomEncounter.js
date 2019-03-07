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
    this.tableData=this.tableData.bind(this);
    this.setBiome=this.setBiome.bind(this);
  }

  tableData = (e) => {
    axios.get('localhost:8080/EncounterGenerator/api/creature/randomCreature/' + this.state.biome).then(response => {
      console.log(response.data);
      this.setState({
        data: response.data
      });
      let wordnice = JSON.stringify(response.data);
      wordnice = wordnice.replace('[', "<tr>");
      wordnice = wordnice.replace(']', " </tr>");
      wordnice = wordnice.replace(/{/g, " ");
      wordnice = wordnice.replace(/}/g, " </td>");
      wordnice = wordnice.replace(/\"/g, "");
      wordnice = wordnice.replace(/,/g, "</td>");
      wordnice = wordnice.replace(/:/g, "<td>")
      document.write(wordnice)


      document.getElementById('testid').innerHTML = wordnice;
    });
  }
  setBiome(event){
    this.setState({biome:event.target.value});
    event.preventDefault();
  }
  render() {
    return (
        <article>
          <form>
            <input type="text" value={this.state.value} onChange={this.setBiome}/>
            <input type="submit" value="submit" onClick={this.tableData}/>
          </form>
        <table>
          <thead>
            <tr>
              <td>Creature Name</td>
              <td>Challenge Rating</td>
              <td>Type</td>
              <td>environment</td>
              <td>alignment</td>
              <td>Combat Role</td>
              <td>environment</td>
              <td>Quantity</td>
            </tr>
          </thead>
          <tbody>
            <tr></tr>
          </tbody>
        </table>
        </article>
    );
  }
}
export default RandomEncounter;