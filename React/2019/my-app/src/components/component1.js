import React, { Component } from 'react';

class Component1 extends Component {
  constructor(props)
  {
    super(props);
    this.state = {count:0}

  }
  render() {
    const handleComp1Click=()=>{
      this.setState({
        count: this.state.count + 1
      })
    }

    return (
    <div>
      Counter: {this.props.p1}
      <div>{this.props.p2}</div>
      <div>{this.props.p3}</div>
      <div>{this.props.p4}</div>
      <div>state = {this.state.count}</div>
      <button onClick={handleComp1Click}>Comp1 </button>
    </div>
    );
  }
}

export default Component1;
