import React from 'react';

class List extends React.Component
{
  render()
  {
    return(
      <div>List Component
        <div>
          <ul>
          {this.props.ninjasList.map((ninja)=>{
            return(
              <li key={ninja.id}>{ninja.name} : {ninja.color}</li>
            );
          })}
          </ul>
        </div>
      </div>
    );
  }
}

export default List;