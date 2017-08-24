import React, { Component } from 'react';
import Title from "./header/Title";
import logo from '../logo.svg';
import './App.css';

class Header extends Component {
  handleChange(e){
    const title = e.target.value;
    this.props.changeTitle(title);
  }
  render() {
    //console.log(this.props);
    //this.props.changeTitle("New Title");

    return (
      <div>
        <Title title={this.props.title}/>
        <input onChange={this.handleChange.bind(this)} />
      </div>
    );
  }
}

export default Header;
