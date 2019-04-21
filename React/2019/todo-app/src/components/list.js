import React from 'react';

class List extends React.Component
{

  render()
  {
    return(
      <div>
        {this.props.taskList.map((task, index)=>{
          return(
            <div key={index}>
              <span onClick={()=>this.props.handleClick(index)} style={{textDecoration: task.done ? 'line-through':'none'}}>{task.value}</span>
            </div>
            );
        })}
      </div>
    );
  }
}

export default List;