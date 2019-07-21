import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import List from './components/list'

class App extends Component {
  state={
    ninjas:[{name:"Ryu", color:"red",id:1},
            {name:"Ken", color:"green",id:3},
            {name:"Chun Li", color:"white",id:4},
            {name:"Sagat", color:"blue",id:5}]
  };
  render() {
    return (
      <div>
        Main Component
        <List ninjasList={this.state.ninjas}></List>
      </div>
    );
  }
}

export default App;
