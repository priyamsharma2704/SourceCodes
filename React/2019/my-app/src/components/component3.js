import React, {Component} from 'react';

class Component3 extends Component
{
  constructor(props)
  {
    super(props);

    this.state = {
      message: "Default text"
    }
  }
  
  HandleTextChange=()=>{
    this.setState({
      message:"text changed!!!"
    });
  }

  render()
  {
    return(
      <div>
        ----------Component3------------
        <div>{this.state.message}</div>
        <button onClick={this.HandleTextChange}>Click to change the text</button>
      </div>
    )
  }

}

export default Component3;