import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { BrowserRouter as Router, Route, NavLink } from "react-router-dom";

class RandomEncounter extends Component {
  constructor(props){
    super(props);
    this.state = {
      biome:''
    }
  }
  tableData = (e) =>{
    axios.get('localhost:8080/EncounterGenerator/api/creature/randomCreature/'+this.biome).then(Response => {
      console.log(response.data);
        this.setState({
          data: response.data
    })
  }
  }
  render() {
    return (
      <router>
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
            </tbody>
        </table>
      </router>
    );
  }
}

export default RandomEncounter;