import React, { Component } from 'react';
import { BrowserRouter as Router, Route, NavLink } from "react-router-dom";
import './App.css';
import Home from './Home';
import logo from './logo.svg';
import './App.css';
import RandomEncounter from './RandomEncounter';
import EncounterCharts from './EncounterCharts';
import Creatures from './Creatures';
import Biomes from './Biomes'

function Navbar() {

  return (
    <nav>
    <Router>
      <div className="grid-container">
        <div className="item1">
          <h1> </h1>
        </div>


        <div className="item2">
          <div className="topnav">
            <NavLink to="/">Home</NavLink>
            <NavLink to="/RandomEncounter">randomise</NavLink>
            <NavLink to="/Creatures">Creatures table</NavLink>
            <NavLink to="/Biomes">Biome table</NavLink>
            <NavLink to="/EncounterCharts">access charts</NavLink>
          </div>
        </div>
        <Route exact path="/" component={Home} />
        <Route path="/RandomEncounter" component={RandomEncounter} />
        <Route path="/Creatures" component={Creatures} />
        <Route path="/Biomes" component={Biomes} />
        <Route path="/EncounterCharts" component={EncounterCharts} />
        <div>
        </div>
      </div>
    </Router>
    </nav>
  );
}
export default Navbar;
