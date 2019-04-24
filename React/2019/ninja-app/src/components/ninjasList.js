import React from 'react';

class NinjasList extends React.Component
{
  render()
  {
    return(
      <form onSubmit={this.props.handleOnSubmit}>
        <div>Ninjas List Component</div>
        <input type="text" name="ninjaName" onChange={this.props.handleInputOnChangeForName} value={this.props.nameValue} placeholder="Name"/>
        <input type="text" name="ninjaColor" onChange={this.props.handleInputOnChangeForColor} value={this.props.colorValue} placeholder="Color"/>
        <input type="text" name="ninjaLocation" onChange={this.props.handleInputOnChangeForLocation} value={this.props.locationValue} placeholder="Location"/>
        <button>Submit</button>
        <div>
          {this.props.ninjasList.map((ninja,index)=>{
            return(
              <div key={index}>{index} : {ninja.name} : {ninja.color} : {ninja.location}</div>
              );
          })}
        </div>
      </form>
    );
  }
}

export default NinjasList;