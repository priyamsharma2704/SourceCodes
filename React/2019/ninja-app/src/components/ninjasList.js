import React from 'react';

class NinjasList extends React.Component
{
  render()
  {
    return(
      <form onSubmit={this.props.handleOnSubmit}>
        <div className="form-inline ninjasForm">
          <input className="form-control" type="text" name="ninjaName" onChange={this.props.handleInputOnChangeForName} value={this.props.nameValue} placeholder="Name"/>
          <input className="form-control" type="text" name="ninjaColor" onChange={this.props.handleInputOnChangeForColor} value={this.props.colorValue} placeholder="Color"/>
          <input className="form-control" type="text" name="ninjaLocation" onChange={this.props.handleInputOnChangeForLocation} value={this.props.locationValue} placeholder="Location"/>
          <button className="btn btn-primary">Submit</button>
        </div>
        <div className="ninjasListDiv">
          {this.props.ninjasList.map((ninja,index)=>{
            return(
              <div className="list-group-item list-group-item-light" key={index}><span>{index} : {ninja.name} : {ninja.color} : {ninja.location}</span>
                <span className="ninjaButtons">
                  <div className="btn-group btn-group-sm" role="group" aria-label="Basic example">
                    <button type="button" className="btn btn-secondary">Edit</button>
                    <button type="button" className="btn btn-secondary btn btn-danger">Delete</button>
                  </div>
                </span>
              </div>
              );
          })}
        </div>
      </form>
    );
  }
}

export default NinjasList;