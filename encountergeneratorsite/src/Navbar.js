import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Navbar extends Component {
  render() {
    return (
      <div>
      <header className="App-header">
        <ul>
          <button id="home">
            <Link to="/">Home</Link>
          </button>
          <button>
            <Link to="/RandomEncounter">randomise</Link>
          </button>
          <button>
            <Link to="/Creatures">Creatures table</Link>
          </button>
          <button>
            <Link to="/Biomes">Biome table</Link>
          </button>
          <button>
            <Link to="/EncounterCharts">Routing within routing!</Link>
          </button>
        </ul>
        </header>
        <body>
        <Route exact path="/" component={Home} />
        <Route path="/RandomEncounter" component={RandomEncounter} />
        <Route path="/Creatures" component={Creatures} />
        <Route path="/Biomes" component={Biomes} />} />
        <Route path="/EncounterCharts" component={EncounterCharts} />
        </body>
      </div>
    );
  }
}

export default Navbar;
